package uz.zgora.pl.raspberry.ui.configuration.manage.edit;

import java.util.List;

import io.reactivex.Observable;
import uz.zgora.pl.raspberry.api.ApiResponseHandler;
import uz.zgora.pl.raspberry.api.ConfigurationProvider;
import uz.zgora.pl.raspberry.model.SensorDetails;
import uz.zgora.pl.raspberry.ui.configuration.manage.edit.request.SensorDetailsRequestBody;

class EditConfigurationPresenter {
    private final EditConfigurationActivity view;
    private final ConfigurationProvider provider;

    EditConfigurationPresenter(final EditConfigurationActivity editConfigurationActivity) {
        view = editConfigurationActivity;
        provider = new ConfigurationProvider();
    }

    void getDetails(final int configurationId) {
        ApiResponseHandler.handle(provider.getSensors(configurationId), view::showSensorDetailsList);
    }

    void update(final int configurationId, final List<SensorDetails> sensorDetailsList) {
        Observable.fromIterable(sensorDetailsList)
                .forEach(it -> {
                    final SensorDetailsRequestBody sensorRequest = new SensorDetailsRequestBody(it);
                    ApiResponseHandler.handle(provider.update(configurationId, it.getName(), sensorRequest), obj -> view.notifySaved(), view::logError);
                });
    }
}
