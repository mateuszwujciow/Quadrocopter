package uz.zgora.pl.raspberry.api;

import java.util.List;

import io.reactivex.Observable;
import uz.zgora.pl.raspberry.model.Configuration;
import uz.zgora.pl.raspberry.model.SensorDetails;
import uz.zgora.pl.raspberry.ui.configuration.manage.add.AddConfigurationRequestBody;
import uz.zgora.pl.raspberry.ui.configuration.manage.edit.request.SensorDetailsRequestBody;

public class ConfigurationProvider {
    private final ConfigurationInterface configurationInterface;

    public ConfigurationProvider() {
        configurationInterface = BaseProvider.getRetrofit().create(ConfigurationInterface.class);
    }

    public Observable<List<Configuration>> getConfigurations() {
        return configurationInterface.getConfigurations();
    }

    public Observable<List<SensorDetails>> getSensors(final int configurationId) {
        return configurationInterface.getSensors(configurationId);
    }

    public Observable<List<SensorDetails>> getCurrentSensors() {
        return configurationInterface.getCurrentSensors();
    }

    public Observable<Integer> add(final AddConfigurationRequestBody configurationName) {
        return configurationInterface.add(configurationName);
    }

    public Observable<String> update(final long configurationId, final String sensorName, final SensorDetailsRequestBody sensorRequestBody) {
        return configurationInterface.update(configurationId, sensorName, sensorRequestBody);
    }

    public Observable<String> remove(final long configurationId) {
        return configurationInterface.remove(configurationId);
    }

    public Observable<String> uploadToQuadrocopter(final long configurationId) {
        return configurationInterface.uploadToQuadrocopter(configurationId);
    }
}
