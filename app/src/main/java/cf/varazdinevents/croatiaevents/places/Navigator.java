package cf.varazdinevents.croatiaevents.places;

/**
 * Created by antonio on 02/08/17.
 */

public interface Navigator {
    void toListEvents();

    void toEventDetails(int eventId);

    void goBack();
}
