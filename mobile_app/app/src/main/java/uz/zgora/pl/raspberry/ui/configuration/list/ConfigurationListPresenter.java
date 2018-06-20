package uz.zgora.pl.raspberry.ui.configuration.list;

import uz.zgora.pl.raspberry.api.ApiResponseHandler;
import uz.zgora.pl.raspberry.api.ConfigurationProvider;

class ConfigurationListPresenter {
    private final ConfigurationListActivity view;
    private final ConfigurationProvider provider;

    ConfigurationListPresenter(final ConfigurationListActivity configurationListActivity) {
        view = configurationListActivity;
        provider = new ConfigurationProvider();
    }

    void fetchConfigurations() {
        ApiResponseHandler.handle(provider.getConfigurations(), view::bindConfigurations);
    }

}
