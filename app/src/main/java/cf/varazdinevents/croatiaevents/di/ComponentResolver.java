package cf.varazdinevents.croatiaevents.di;

import android.content.Context;

/**
 * Created by antonio on 28/07/17.
 */

public class ComponentResolver {
    @SuppressWarnings("unchecked")
    public static <T> T resolve(Context context) {
        return ((HasComponent<T>) context).getComponent();
    }
}
