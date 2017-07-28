package cf.varazdinevents.croatiaevents.places.events;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cf.varazdinevents.croatiaevents.R;
import cf.varazdinevents.croatiaevents.base.BaseFragment;
import cf.varazdinevents.croatiaevents.base.binding.BindingComponent;
import cf.varazdinevents.croatiaevents.base.ui.list.ListHolder;
import cf.varazdinevents.croatiaevents.base.ui.list.ListListener;
import cf.varazdinevents.croatiaevents.base.ui.list.SimpleListAdapter;
import cf.varazdinevents.croatiaevents.data.model.Event;
import cf.varazdinevents.croatiaevents.databinding.EventsFragmentBinding;
import cf.varazdinevents.croatiaevents.di.ComponentCreator;
import cf.varazdinevents.croatiaevents.di.ComponentResolver;
import cf.varazdinevents.croatiaevents.di.FragmentComponent;

/**
 * Created by antonio on 26/07/17.
 */

public class EventsFragment extends BaseFragment implements ListHolder<Event> {

    FragmentComponent component;
    private DataBindingComponent fragmentBinding = new BindingComponent(this);
    private EventsAdapter adapter = new EventsAdapter(fragmentBinding);


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        component.inject(this);

        EventsFragmentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.events_fragment, container, false, fragmentBinding);

        binding.setListOwner(this);

        EventListViewModel viewModel = ViewModelProviders.of(getActivity()).get(EventListViewModel.class);

        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

    @Override
    protected void inject() {
        component = ComponentCreator.create(this, ComponentResolver.resolve(getActivity()));
    }

    @Override
    public ListListener<Event> getListener() {
        return null;
    }

    @Override
    public SimpleListAdapter getAdapter() {
        return adapter;
    }

    @Override
    public RecyclerView.LayoutManager createLayoutManger() {
        return new LinearLayoutManager(getContext());
    }
}
