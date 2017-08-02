package cf.varazdinevents.croatiaevents;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import cf.varazdinevents.croatiaevents.di.ApplicationComponent;
import cf.varazdinevents.croatiaevents.di.ComponentCreator;
import timber.log.Timber;

/**
 * Created by antonio on 25/07/17.
 */

public final class MainApplication extends MultiDexApplication {

    private ApplicationComponent applicationComponent;

    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

//        if (BuildConfig.DEBUG) {
//            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                    .detectAll()
//                    .penaltyLog()
//                    .penaltyDialog()
//                    .build());
//            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
//                    .detectAll()
//                    .penaltyLog()
//                    .build());
//        }


        applicationComponent = ComponentCreator.create(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public ApplicationComponent getAppComponent() {
        return applicationComponent;
    }

}
