package uz.zgora.pl.raspberry.ui.configuration.manage;

import uz.zgora.pl.raspberry.model.ConfigurationDetails;

public interface ManageConfigurationView {

    ConfigurationDetails build();

    boolean isEditMode();
}
