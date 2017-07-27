package cf.varazdinevents.croatiaevents.base.binding;

import android.databinding.DataBindingComponent;
import android.support.v4.app.Fragment;

/**
 * Created by antonio on 27/07/17.
 */

public class BindingComponent implements DataBindingComponent {
    private final FragmentBindings fragmentBindings;

    public BindingComponent(Fragment fragment) {
        this.fragmentBindings = new FragmentBindings(fragment);
    }

    @Override
    public FragmentBindings getFragmentBindings() {
        return fragmentBindings;
    }
}
