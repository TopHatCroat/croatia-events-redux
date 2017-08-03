package cf.varazdinevents.croatiaevents.places.eventDetail;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;

import cf.varazdinevents.croatiaevents.R;
import cf.varazdinevents.croatiaevents.base.BaseFragment;
import cf.varazdinevents.croatiaevents.base.binding.BindingComponent;
import cf.varazdinevents.croatiaevents.databinding.FragmentEventDetailBinding;
import cf.varazdinevents.croatiaevents.di.ComponentCreator;
import cf.varazdinevents.croatiaevents.di.ComponentResolver;
import cf.varazdinevents.croatiaevents.di.FragmentComponent;

/**
 * Created by antonio on 02/08/17.
 */

public class EventDetailFragment extends BaseFragment {

    public static final String EVENT_ID_EXTRA = "eventDetail:id";
    public static final String TAG = EventDetailFragment.class.getName();
    private FragmentComponent component;
    private BindingComponent bindingComponent = new BindingComponent(this);

    public static EventDetailFragment newInstance(int id) {
        EventDetailFragment fragment = new EventDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(EVENT_ID_EXTRA, id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentEventDetailBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_event_detail, container, false, bindingComponent);

        EventDetailViewModel viewModel = ViewModelProviders.of(this).get(EventDetailViewModel.class);
        viewModel.init(getArguments().getInt(EVENT_ID_EXTRA));

        binding.setViewModel(viewModel);
        viewModel.getEvent().observe(this, binding::setEvent);

        SupportMapFragment fragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(subscribeMap(viewModel));

        return binding.getRoot();
    }

    @NonNull
    private OnMapReadyCallback subscribeMap(EventDetailViewModel viewModel) {
        return googleMap -> {
            viewModel.getLocation().observe(this, latLng -> {
                if (latLng == null)
                    return;

                googleMap.clear();
                googleMap.addMarker(
                        new MarkerOptions()
                                .position(latLng)
                );
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            });
            googleMap.moveCamera(CameraUpdateFactory.zoomTo(15f));
        };
    }

    @Override
    protected void inject() {
        component = ComponentCreator.create(this, ComponentResolver.resolve(getActivity()));
    }
}
