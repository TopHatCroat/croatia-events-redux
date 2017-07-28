package cf.varazdinevents.croatiaevents.di;

import cf.varazdinevents.croatiaevents.di.modules.FragmentModule;
import cf.varazdinevents.croatiaevents.places.events.EventsFragment;
import dagger.Subcomponent;

/**
 * Created by antonio on 27/07/17.
 */

@Subcomponent(modules = {
        FragmentModule.class,
})
@FragmentScope
public interface FragmentComponent {

    void inject(EventsFragment eventsFragment);
}
