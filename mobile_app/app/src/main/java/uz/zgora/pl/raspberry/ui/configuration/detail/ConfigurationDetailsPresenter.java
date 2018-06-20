package uz.zgora.pl.raspberry.ui.configuration.detail;

import uz.zgora.pl.raspberry.api.ApiResponseHandler;
import uz.zgora.pl.raspberry.api.ConfigurationProvider;

import static uz.zgora.pl.raspberry.ui.configuration.detail.ConfigurationDetailsActivity.CURRENT_CONFIGURATION_ID;

class ConfigurationDetailsPresenter {
    private final ConfigurationDetailsActivity view;
    private final ConfigurationProvider provider;

    ConfigurationDetailsPresenter(final ConfigurationDetailsActivity configurationListActivity) {
        view = configurationListActivity;
        provider = new ConfigurationProvider();
    }

    void fetchConfiguration(final int configurationId) {
        if (configurationId == CURRENT_CONFIGURATION_ID)
            ApiResponseHandler.handle(provider.getCurrentSensors(), view::bindConfigurationDetails, view::logError);
        else
            ApiResponseHandler.handle(provider.getSensors(configurationId), view::bindConfigurationDetails, view::logError);
    }

    void uploadConfiguration(final int configurationId) {
        ApiResponseHandler.handle(provider.uploadToQuadrocopter(configurationId), message -> view.showUploaded(), view::logError);
    }

    void removeConfiguration(final int configurationId) {
        ApiResponseHandler.handle(provider.remove(configurationId), message -> view.handleRemoved(), view::logError);
    }

}
