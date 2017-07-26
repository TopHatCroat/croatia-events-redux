package cf.varazdinevents.croatiaevents.base;

import android.arch.lifecycle.LifecycleFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by antonio on 25/07/17.
 */

public abstract class BaseFragment extends LifecycleFragment {
    public String NAME = this.getClass().getSimpleName();
    @NonNull
    protected BaseViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

    protected abstract void inject();

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}

