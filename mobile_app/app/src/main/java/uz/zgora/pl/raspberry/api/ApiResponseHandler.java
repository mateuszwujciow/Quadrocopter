package uz.zgora.pl.raspberry.api;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ApiResponseHandler<T> {

    public ApiResponseHandler(final Observable<T> observable, final Consumer<T> onNext) {
        this(observable, onNext, throwable -> Log.e("ApiResponseHandler", throwable.toString()));
    }

    public ApiResponseHandler(final Observable<T> observable, final Consumer<T> onNext, final Consumer<Throwable> onError) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError);
    }
}
