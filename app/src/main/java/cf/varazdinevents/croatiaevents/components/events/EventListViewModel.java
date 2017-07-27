package cf.varazdinevents.croatiaevents.components.events;

import android.app.Application;
import android.databinding.ObservableField;

import java.util.List;

import cf.varazdinevents.croatiaevents.base.BaseViewModel;
import cf.varazdinevents.croatiaevents.base.ui.list.ListListener;
import cf.varazdinevents.croatiaevents.base.ui.list.ListViewModel;
import cf.varazdinevents.croatiaevents.data.model.Event;

/**
 * Created by antonio on 26/07/17.
 */

public class EventListViewModel extends BaseViewModel implements ListViewModel<Event> {

    private ObservableField<List<Event>> items;

    protected EventListViewModel(Application application) {
        super(application);
    }


    @Override
    public ObservableField<List<Event>> getItems() {
        return items;
    }

    @Override
    public ListListener getListener() {
        return null;
    }
}
