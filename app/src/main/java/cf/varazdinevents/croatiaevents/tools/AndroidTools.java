package cf.varazdinevents.croatiaevents.tools;

import android.os.Build;

/**
 * Created by antonio on 02/08/17.
 */

public class AndroidTools {
    public static boolean is24() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N;
    }
}
