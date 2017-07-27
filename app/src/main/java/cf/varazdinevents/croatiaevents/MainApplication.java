package cf.varazdinevents.croatiaevents;

import android.app.Application;
import android.content.Context;

import cf.varazdinevents.croatiaevents.di.ApplicationComponent;
import cf.varazdinevents.croatiaevents.di.modules.ApplicationModule;
import cf.varazdinevents.croatiaevents.di.DaggerApplicationComponent;
import cf.varazdinevents.croatiaevents.di.modules.NetworkModule;
import timber.log.Timber;

/**
 * Created by antonio on 25/07/17.
 */

public class MainApplication extends Application {

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


        initializeInjection();
    }

    private void initializeInjection() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .build();
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
