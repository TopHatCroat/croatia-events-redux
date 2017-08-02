package cf.varazdinevents.croatiaevents.data.mapper;

import android.support.annotation.NonNull;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.Date;
import java.util.List;

import cf.varazdinevents.croatiaevents.data.api.responses.EventResponse;
import cf.varazdinevents.croatiaevents.data.db.EventEntity;
import cf.varazdinevents.croatiaevents.data.model.Event;

/**
 * Created by antonio on 28/07/17.
 */

public class EventMapper {

    public static List<EventEntity> fromResponse(EventResponse[] events) {
        return Stream.of(events).map(EventMapper::fromResponse).collect(Collectors.toList());
    }

    @NonNull
    private static EventEntity fromResponse(EventResponse e) {
        return new EventEntity(
                0/*e.id*/, e.id, e.title, e.text, e.date * 1000, e.dateTo * 1000,
                e.host, e.officialLink, e.image, e.facebook, e.offers,
                e.category, e.dateUpdated, e.hostApiId, e.longitude, e.latitude,
                e.address, e.festivalId == null ? 0 : e.festivalId);
    }

    public static List<Event> fromEntity(List<EventEntity> events) {
        return Stream.of(events).map(EventMapper::fromEntity).collect(Collectors.toList());
    }

    public static Event fromEntity(EventEntity ee) {
        return new Event(ee.apiId, ee.title, ee.text, new Date(ee.date), new Date(ee.dateTo),
                ee.host, ee.officialLink, ee.image, ee.facebook, ee.offers,
                ee.category, ee.dateUpdated, ee.hostApiId, ee.longitude, ee.latitude,
                ee.address, ee.festivalId);

    }
}
