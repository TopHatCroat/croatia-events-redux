package cf.varazdinevents.croatiaevents.data.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cf.varazdinevents.croatiaevents.data.api.responses.EventResponse;
import cf.varazdinevents.croatiaevents.data.model.Event;

/**
 * Created by antonio on 28/07/17.
 */

public class EventMapper {

    public static List<Event> map(EventResponse[] events) {
        List<Event> result = new ArrayList<>();
        for(EventResponse er : events) {
            result.add(
                    new Event(er.id, er.title, er.text, new Date(er.date), new Date(er.dateTo),
                            er.host, er.officialLink, er.image, er.facebook, er.offers,
                            er.category, er.dateUpdated, er.hostApiId, er.longitude, er.latitude,
                            er.address, er.festivalId)
            );
        }
        return result;
    }
}
