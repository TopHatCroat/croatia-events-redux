package cf.varazdinevents.croatiaevents.places.events;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cf.varazdinevents.croatiaevents.base.BaseFragment;
import cf.varazdinevents.croatiaevents.di.ComponentCreator;
import cf.varazdinevents.croatiaevents.di.ComponentResolver;
import cf.varazdinevents.croatiaevents.di.FragmentComponent;

/**
 * Created by antonio on 26/07/17.
 */

public class EventsFragment extends BaseFragment {

    FragmentComponent component;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        component.inject(this);
        viewModel = ViewModelProviders.of(this).get(EventListViewModel.class);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void inject() {
        component = ComponentCreator.create(this, ComponentResolver.resolve(getActivity()));
    }
}
