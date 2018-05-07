package uz.zgora.pl.raspberry.api;

import java.util.List;

import io.reactivex.Observable;
import uz.zgora.pl.raspberry.model.Configuration;
import uz.zgora.pl.raspberry.model.ConfigurationDetails;

public class ConfigurationProvider {
    private final ConfigurationInterface configurationInterface;

    public ConfigurationProvider() {
        configurationInterface = BaseProvider.getRetrofit().create(ConfigurationInterface.class);
    }

    public Observable<List<Configuration>> getAll() {
        return configurationInterface.all();
    }

    public Observable<CommonResponse> add(final ConfigurationDetails configurationDetails) {
        return configurationInterface.add(configurationDetails);
    }

    public Observable<CommonResponse> update(final long configurationId, final ConfigurationDetails configurationDetails) {
        return configurationInterface.update(configurationId, configurationDetails);
    }

    public Observable<CommonResponse> remove(final long configurationId) {
        return configurationInterface.remove(configurationId);
    }
}
