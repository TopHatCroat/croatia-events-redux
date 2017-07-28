package cf.varazdinevents.croatiaevents.data;

import java.util.List;

import cf.varazdinevents.croatiaevents.base.utils.Schedule;
import cf.varazdinevents.croatiaevents.base.utils.SharedPrefs;
import cf.varazdinevents.croatiaevents.data.api.RestService;
import cf.varazdinevents.croatiaevents.data.db.EventDao;
import cf.varazdinevents.croatiaevents.data.mapper.EventMapper;
import cf.varazdinevents.croatiaevents.data.model.Event;
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
    public Single<List<Event>> getEvents() {
        return service
                .getEventsByCity(DEFAULT_CITY_ID)
                .flatMap(response -> {
//                    if (!response.isSuccessful())
//                        return Single.error(new Exception(response.errorMessage));
//                    return Single.just(EventMapper.map(response.body));
                    return Single.just(EventMapper.map(response));
                })
                .subscribeOn(Schedule.io());
    }
}
