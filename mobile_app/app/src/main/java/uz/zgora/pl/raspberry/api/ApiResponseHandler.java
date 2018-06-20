package uz.zgora.pl.raspberry.api;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ApiResponseHandler {

    public static <T> void handle(final Observable<T> observable, final Consumer<T> onNext) {
        handle(observable, onNext, ApiResponseHandler::handleError);
    }

    public static <T> void handle(final Observable<T> observable, final Consumer<T> onNext, final Consumer<Throwable> onError) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError);
    }

    private static void handleError(final Throwable throwable) {
        Log.e("ApiResponseHandler", throwable.toString());
        for (final StackTraceElement stackTraceElement : throwable.getStackTrace()) {
            Log.e("ApiResponseHandler", stackTraceElement.toString());
        }
    }
}
