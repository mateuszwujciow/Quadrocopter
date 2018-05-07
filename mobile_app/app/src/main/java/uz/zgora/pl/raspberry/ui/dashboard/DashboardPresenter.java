package uz.zgora.pl.raspberry.ui.dashboard;

import uz.zgora.pl.raspberry.api.ApiResponseHandler;
import uz.zgora.pl.raspberry.api.ConfigurationProvider;
import uz.zgora.pl.raspberry.model.ConfigurationGroup;

class DashboardPresenter {
    private final DashboardView view;

    DashboardPresenter(final DashboardView view) {
        this.view = view;
    }

    void showCurrentConfiguration() {
    }

    void showConfigurationList() {
        new ApiResponseHandler<>(new ConfigurationProvider().getAll(),
                it -> view.navigateToConfigurationListView(new ConfigurationGroup(it)));
    }

    void showAddConfigurationView() {
        view.navigateToConfigurationView(null);

    }

    void disconnect() {
        view.navigateToConnectionView();
    }

    public void showVideoStream() {
        view.navigateToVideoStreamView();
    }
}
