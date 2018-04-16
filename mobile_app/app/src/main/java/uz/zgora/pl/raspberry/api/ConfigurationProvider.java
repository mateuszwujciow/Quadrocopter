package uz.zgora.pl.raspberry.api;

import io.reactivex.Observable;

public class ConfigurationProvider {
    private final ConfigurationInterface configurationInterface;

    public ConfigurationProvider() {
        configurationInterface = BaseProvider.getRetrofit().create(ConfigurationInterface.class);
    }

    public Observable<String> getConfigurations() {
        return configurationInterface.all();
    }
}
