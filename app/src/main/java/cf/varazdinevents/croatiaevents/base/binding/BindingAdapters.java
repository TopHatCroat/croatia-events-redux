package cf.varazdinevents.croatiaevents.base.binding;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by antonio on 27/07/17.
 */

public class BindingAdapters {
    @BindingAdapter(value = "visibility")
    public static void visibility(View view, boolean visible) {
        view.setVisibility(visible? View.VISIBLE : View.INVISIBLE);
    }
}
