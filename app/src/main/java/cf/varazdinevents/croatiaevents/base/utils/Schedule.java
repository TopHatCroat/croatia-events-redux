package cf.varazdinevents.croatiaevents.base.utils;

import android.support.annotation.NonNull;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by antonio on 26/07/17.
 */

public class Schedule {
    @NonNull
    public static Scheduler compute() {
        return Schedulers.computation();
    }

    @NonNull
    public static Scheduler io() {
        return Schedulers.io();
    }

    @NonNull
    public static Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
