package uz.zgora.pl.raspberry.util;

import android.support.annotation.NonNull;
import android.widget.TextView;

public class UiUtils {

    public static double getDouble(@NonNull final TextView textView) {
        try {
            return Double.parseDouble(getText(textView));
        } catch (final NumberFormatException exception) {
            return 0d;
        }
    }

    public static String getText(@NonNull final TextView textView) {
        return textView.getText().toString();
    }

    public static void setText(@NonNull final TextView textView, final float value) {
        textView.setText(String.valueOf(value));
    }

}
