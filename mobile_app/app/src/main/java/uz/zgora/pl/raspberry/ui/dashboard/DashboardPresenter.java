package uz.zgora.pl.raspberry.ui.dashboard;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import uz.zgora.pl.raspberry.api.ConfigurationProvider;
import uz.zgora.pl.raspberry.model.Configuration;

class DashboardPresenter {
    private final DashboardView view;

    DashboardPresenter(final DashboardView view) {
        this.view = view;
    }

    void showCurrentConfiguration() {
        new ConfigurationProvider()
                .getConfigurations()
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(final Disposable d) {

                    }

                    @Override
                    public void onNext(final String configurations) {
                        Log.e("dupa", configurations + "::");
                    }

                    @Override
                    public void onError(final Throwable throwable) {
                        Log.e("dupa", "onError");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    void showConfigurationList() {
        view.navigateToConfigurationListView();
    }

    void showAddConfigurationView() {
        view.navigateToConfigurationView(Configuration.EMPTY());
    }

    void disconnect() {
        view.navigateToConnectionView();
    }

    public void showVideoStream() {

    }
}
