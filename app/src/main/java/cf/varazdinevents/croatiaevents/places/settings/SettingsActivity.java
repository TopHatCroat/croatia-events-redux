package cf.varazdinevents.croatiaevents.places.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;

import cf.varazdinevents.croatiaevents.R;
import cf.varazdinevents.croatiaevents.base.BaseActivity;

/**
 * Created by antonio on 25/07/17.
 */

public class SettingsActivity extends BaseActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    private SharedPreferences prefs;
    private SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle(getResources().getString(R.string.settings));
    }

    @Override
    protected void onStart() {
        super.onStart();
        settingsFragment = new SettingsFragment();

        getFragmentManager().beginTransaction()
                .replace(R.id.settings_holder, settingsFragment).commit();

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    protected int getLayout() {
        return R.layout.view_settings;
    }

    @Override
    protected void setupActivityComponent() {}

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

    }
}
