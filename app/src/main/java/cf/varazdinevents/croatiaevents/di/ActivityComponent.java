package cf.varazdinevents.croatiaevents.di;

import cf.varazdinevents.croatiaevents.di.modules.ActivityModule;
import cf.varazdinevents.croatiaevents.di.modules.FragmentModule;
import dagger.Subcomponent;

/**
 * Created by antonio on 27/07/17.
 */

@Subcomponent(modules = {
        ActivityModule.class,
})
@ActivityScope
public interface ActivityComponent extends ApplicationComponent.Exposes {

    FragmentComponent plus(FragmentModule fragmentModule);

}