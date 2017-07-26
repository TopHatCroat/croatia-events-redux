package cf.varazdinevents.croatiaevents.places.settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

import cf.varazdinevents.croatiaevents.R;

/**
 * Created by antonio on 25/07/17.
 */

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.app_preferances);
    }
}
