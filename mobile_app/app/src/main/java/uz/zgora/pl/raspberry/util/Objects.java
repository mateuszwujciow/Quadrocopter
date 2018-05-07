package uz.zgora.pl.raspberry.util;

public class Objects {

    public static boolean isNotNull(final Object object) {
        return !isNull(object);
    }

    public static boolean isNull(final Object object) {
        return object == null;
    }
}
