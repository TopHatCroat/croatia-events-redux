package cf.varazdinevents.croatiaevents.places.eventDetail;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

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

public class EventDetailViewModel extends BaseViewModel {

    public ObservableField<Boolean> loading = new ObservableField<>(true);
    @Inject
    EventRepository repository;
    public ObservableField<List<Event>> items = new ObservableField<>(new ArrayList<>());
    private MutableLiveData<Event> event = new MutableLiveData<>();
    private int eventId;
    private MutableLiveData<LatLng> location = new MutableLiveData<>();

    public void init(int eventId) {
        this.eventId = eventId;

        disposables.add(
                repository
                        .getEvent(eventId)
                        .observeOn(Schedule.ui())
                        .subscribe(this::update, Timber::d)
        );

    }

    private void update(Event event) {
        this.event.setValue(event);
        this.location.setValue(new LatLng(event.getLatitude(), event.getLongitude()));
    }

    public EventDetailViewModel(Application application) {
        super(application);
        MainApplication.get(application).getAppComponent().inject(this);
    }

    public LiveData<Event> getEvent() {
        return event;
    }

    public LiveData<LatLng> getLocation() {
        return location;
    }
}
