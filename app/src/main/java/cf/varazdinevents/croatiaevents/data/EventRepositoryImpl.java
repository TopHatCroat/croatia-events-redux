package cf.varazdinevents.croatiaevents.data;

import com.annimon.stream.Stream;

import java.util.List;

import cf.varazdinevents.croatiaevents.base.utils.Schedule;
import cf.varazdinevents.croatiaevents.base.utils.SharedPrefs;
import cf.varazdinevents.croatiaevents.data.api.RestService;
import cf.varazdinevents.croatiaevents.data.db.EventDao;
import cf.varazdinevents.croatiaevents.data.mapper.EventMapper;
import cf.varazdinevents.croatiaevents.data.model.Event;
import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * Created by antonio on 28/07/17.
 */

public class EventRepositoryImpl implements EventRepository {

    private static final Integer DEFAULT_CITY_ID = 1;
    private final RestService service;
    private final EventDao eventDao;
    private final SharedPrefs sharedPrefs;

    public EventRepositoryImpl(RestService service, EventDao eventDao, SharedPrefs sharedPrefs) {
        this.service = service;
        this.eventDao = eventDao;
        this.sharedPrefs = sharedPrefs;
    }

    @Override
    public Flowable<List<Event>> getEvents() {
        return Single
                .merge(fromDb(), fromApi())
                .subscribeOn(Schedule.io());
    }

    @Override
    public Single<Event> getEvent(int apiId) {
        return eventDao
                .getEventByApiId(apiId)
                .subscribeOn(Schedule.io())
                .map(EventMapper::fromEntity);
    }

    private Single<List<Event>> fromApi() {
        return service
                .getEventsByCity(DEFAULT_CITY_ID)
                .map(EventMapper::fromResponse)
                .doOnSuccess(eventEntities ->
                        Stream.of(eventEntities).filter(ee -> eventDao.count(ee.apiId) == 0)
                                                .forEach(eventDao::insert))
                .map(EventMapper::fromEntity);
    }

    private Single<List<Event>> fromDb() {
        return eventDao
                .getAllEvents()
                .map(EventMapper::fromEntity);
    }
}
