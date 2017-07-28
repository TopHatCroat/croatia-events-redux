package cf.varazdinevents.croatiaevents.di.modules;

import cf.varazdinevents.croatiaevents.base.BaseFragment;
import dagger.Module;

/**
 * Created by antonio on 27/07/17.
 */

@Module
public class FragmentModule {
    private final BaseFragment fragment;

    public FragmentModule(BaseFragment fragment) {
        this.fragment = fragment;
    }
}
