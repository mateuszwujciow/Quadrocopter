package uz.zgora.pl.raspberry.util;

import android.app.Activity;
import android.content.Intent;

public class AndroidUtils {

    public static void startActivityWithoutHistory(final Activity currentActivity, final Class activityToStart) {
        final Intent intent = new Intent(currentActivity, activityToStart);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        currentActivity.startActivity(intent);
    }
}
