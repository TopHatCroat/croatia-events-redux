package cf.varazdinevents.croatiaevents.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import cf.varazdinevents.croatiaevents.R;
import timber.log.Timber;

/**
 * Created by antonio on 25/07/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements LifecycleOwner {

    public String NAME = this.getClass().getSimpleName();
    private Lifecycle lifecycle = new LifecycleRegistry(this);
    private View contentHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.i("Activity initiated %s", NAME);
        setupActivityComponent();
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.i("Activity destroyed %s", NAME);
    }

    /**
     * Specify wich layout should be inflated for the activity
     *
     * @return layout resource ID
     */
    protected abstract int getLayout();

    /**
     * Activity should put define DI graph genrating
     * code by overriding this method
     */
    protected abstract void setupActivityComponent();

    @Override
    public Lifecycle getLifecycle() {
        return lifecycle;
    }

    public View getContentHolder() {
        if(contentHolder == null) {
            contentHolder = findViewById(R.id.content_holder);
        }
        return contentHolder;
    }
}
