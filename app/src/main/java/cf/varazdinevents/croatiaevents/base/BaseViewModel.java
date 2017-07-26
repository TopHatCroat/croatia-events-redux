package cf.varazdinevents.croatiaevents.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import cf.varazdinevents.croatiaevents.MainApplication;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by antonio on 25/07/17.
 */


public abstract class BaseViewModel extends AndroidViewModel {
    protected CompositeDisposable disposables = new CompositeDisposable();

    protected BaseViewModel(Application application) {
        super(application);
        disposables = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.dispose();
    }

    @Override
    @SuppressWarnings("unchecked")
    public MainApplication getApplication() {
        return (MainApplication) super.getApplication();
    }


}
