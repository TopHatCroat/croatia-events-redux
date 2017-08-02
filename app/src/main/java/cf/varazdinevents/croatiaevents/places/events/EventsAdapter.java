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
    private final EventItemListener listener;

    EventsAdapter(DataBindingComponent component, EventItemListener listener) {
        this.component = component;
        this.listener = listener;
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
        binding.setListener(listener);
    }

    @Override
    public boolean areItemsTheSame(Event old, Event current) {
        return old.getApiId().equals(current.getApiId());
    }

    @Override
    public boolean areContentsTheSame(Event old, Event current) {
        return old.getDateUpdated().equals(current.getDateUpdated());
    }
}
