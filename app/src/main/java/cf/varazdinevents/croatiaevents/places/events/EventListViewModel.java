package cf.varazdinevents.croatiaevents.places.events;

import android.app.Application;
import android.databinding.ObservableField;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import cf.varazdinevents.croatiaevents.MainApplication;
import cf.varazdinevents.croatiaevents.base.BaseViewModel;
import cf.varazdinevents.croatiaevents.base.utils.Schedule;
import cf.varazdinevents.croatiaevents.data.EventRepository;
import cf.varazdinevents.croatiaevents.data.model.Event;
import timber.log.Timber;

/**
 * Created by antonio on 26/07/17.
 */

public class EventListViewModel extends BaseViewModel {

    public ObservableField<Boolean> loading = new ObservableField<>(true);
    @Inject
    EventRepository repository;
    public ObservableField<List<Event>> items = new ObservableField<>(new ArrayList<>());

    public EventListViewModel(Application application) {
        super(application);
        MainApplication.get(application).getAppComponent().inject(this);

        disposables.add(
                repository
                        .getEvents()
                        .observeOn(Schedule.ui())
                        .subscribe(items -> {
                            this.items.set(items);
                            this.loading.set(false);
                        }, Timber::d)
        );
    }
}
