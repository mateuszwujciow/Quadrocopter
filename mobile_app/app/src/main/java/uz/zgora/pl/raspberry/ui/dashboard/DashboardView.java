package uz.zgora.pl.raspberry.ui.dashboard;

import android.support.annotation.Nullable;

import uz.zgora.pl.raspberry.model.ConfigurationDetails;
import uz.zgora.pl.raspberry.model.ConfigurationGroup;

interface DashboardView {

    void navigateToConfigurationView(final @Nullable ConfigurationDetails configurationDetails);

    void navigateToConnectionView();

    void navigateToConfigurationListView(ConfigurationGroup configurationGroup);

    void navigateToVideoStreamView();
}
