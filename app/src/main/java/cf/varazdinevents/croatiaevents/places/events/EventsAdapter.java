package cf.varazdinevents.croatiaevents.places.events;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import cf.varazdinevents.croatiaevents.R;
import cf.varazdinevents.croatiaevents.base.ui.list.SimpleListAdapter;
import cf.varazdinevents.croatiaevents.data.model.Event;
import cf.varazdinevents.croatiaevents.databinding.EventItemBinding;

/**
 * Created by antonio on 28/07/17.
 */

class EventsAdapter extends SimpleListAdapter<Event, EventItemBinding> {

    private final DataBindingComponent component;

    EventsAdapter(DataBindingComponent component) {
        this.component = component;
    }

    @NonNull
    @Override
    protected EventItemBinding createBinding(ViewGroup parent) {
        EventItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.event_item,
                parent, false, component);
        return binding;
    }

    @Override
    protected void bind(EventItemBinding binding, Event item) {
        binding.setItem(item);
    }
}
