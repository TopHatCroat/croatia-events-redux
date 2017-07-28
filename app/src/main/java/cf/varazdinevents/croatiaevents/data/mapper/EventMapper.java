package cf.varazdinevents.croatiaevents.data.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import cf.varazdinevents.croatiaevents.data.api.responses.EventResponse;
import cf.varazdinevents.croatiaevents.data.db.EventEntity;
import cf.varazdinevents.croatiaevents.data.model.Event;

/**
 * Created by antonio on 28/07/17.
 */

public class EventMapper {

    public static List<EventEntity> fromResponse(EventResponse[] events) {
        List<EventEntity> result = new LinkedList<>();
        for(EventResponse e : events) {
            result.add(
                    new EventEntity(
                            0/*e.id*/, e.id, e.title, e.text, e.date * 1000, e.dateTo * 1000,
                            e.host, e.officialLink, e.image, e.facebook, e.offers,
                            e.category, e.dateUpdated, e.hostApiId, e.longitude ,e.latitude,
                            e.address, e.festivalId == null ? 0 : e.festivalId)
            );
        }
        return result;
    }

    public static List<Event> fromEntity(List<EventEntity> events) {
        List<Event> result = new ArrayList<>();
        for(EventEntity er : events) {
            result.add(
                    new Event(er.apiId, er.title, er.text, new Date(er.date), new Date(er.dateTo),
                            er.host, er.officialLink, er.image, er.facebook, er.offers,
                            er.category, er.dateUpdated, er.hostApiId, er.longitude, er.latitude,
                            er.address, er.festivalId)
            );
        }
        return result;
    }


//    public static List<Event> map(EventResponse[] events) {
//        List<Event> result = new ArrayList<>();
//        for(EventResponse er : events) {
//            result.add(
//                    new Event(er.id, er.title, er.text, new Date(er.date), new Date(er.dateTo),
//                            er.host, er.officialLink, er.image, er.facebook, er.offers,
//                            er.category, er.dateUpdated, er.hostApiId, er.longitude, er.latitude,
//                            er.address, er.festivalId)
//            );
//        }
//        return result;
//    }
//
//    public static List<EventEntity> map(List<Event> events) {
//        List<EventEntity> result = new LinkedList<>();
//        for(Event e : events) {
//            result.add(
//                    new EventEntity(
//                            e.getId(), e.getApiId(), e.getTitle(), e.getText(), e.getDate().getTime(), e.getDateTo().getTime(),
//                            e.getHost(), e.getOfficialLink(), e.getImage(), e.getFacebook(), e.getOffers(),
//                            e.getCategory(), e.getDateUpdated(), e.getHostApiId(), e.getLongitude(), e.getLatitude(),
//                            e.getAddress(), e.getFestivalId())
//            );
//        }
//        return result;
//    }
//
//    public static List<Event> map(List<EventEntity> events) {
//        List<Event> result = new ArrayList<>();
//        for(EventEntity er : events) {
//            result.add(
//                    new Event(er.id, er.title, er.text, new Date(er.date), new Date(er.dateTo),
//                            er.host, er.officialLink, er.image, er.facebook, er.offers,
//                            er.category, er.dateUpdated, er.hostApiId, er.longitude, er.latitude,
//                            er.address, er.festivalId)
//            );
//        }
//        return result;
//    }
}
