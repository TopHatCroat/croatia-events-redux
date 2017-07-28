package cf.varazdinevents.croatiaevents.data;

import java.util.List;

import cf.varazdinevents.croatiaevents.data.model.Event;
import io.reactivex.Flowable;

/**
 * Created by antonio on 28/07/17.
 */

public interface EventRepository {
    Flowable<List<Event>> getEvents();
}
