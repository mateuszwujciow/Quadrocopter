package uz.zgora.pl.raspberry.ui.configuration.manage.add;

import uz.zgora.pl.raspberry.api.ApiResponseHandler;
import uz.zgora.pl.raspberry.api.ConfigurationProvider;

public class AddConfigurationPresenter {
    private final AddConfigurationActivity view;
    private final ConfigurationProvider provider;

    AddConfigurationPresenter(final AddConfigurationActivity addConfigurationActivity) {
        view = addConfigurationActivity;
        provider = new ConfigurationProvider();
    }

    void add(final String configurationName) {
        ApiResponseHandler.handle(provider.add(new AddConfigurationRequestBody(configurationName)), view::showConfigurationDetails, view::logError);
    }

}
