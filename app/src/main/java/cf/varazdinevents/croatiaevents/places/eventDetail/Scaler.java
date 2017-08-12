package cf.varazdinevents.croatiaevents.places.eventDetail;

/**
 * Created by antonio on 10/08/17.
 */

public interface Scaler {
    float getScale();
    void setScale(float scale);
    void cancelAnimations();
    void obtainInitialValues();
}
