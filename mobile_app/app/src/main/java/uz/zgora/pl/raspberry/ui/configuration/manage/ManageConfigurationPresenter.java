package uz.zgora.pl.raspberry.ui.configuration.manage;

import uz.zgora.pl.raspberry.api.ConfigurationProvider;
import uz.zgora.pl.raspberry.model.ConfigurationDetails;

class ManageConfigurationPresenter {
    private final ManageConfigurationView view;
    private final ConfigurationProvider provider;

    ManageConfigurationPresenter(final ManageConfigurationView view) {
        this.view = view;
        provider = new ConfigurationProvider();
    }

    void manageConfiguration() {
        if (view.isEditMode()) updateConfiguration();
        else addConfiguration();
    }

    private void addConfiguration() {
        provider.add(view.build());
    }

    private void updateConfiguration() {
        final ConfigurationDetails configurationDetails = view.build();
        provider.update(configurationDetails.getId(), configurationDetails);
    }
}