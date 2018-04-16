package uz.zgora.pl.raspberry.ui.dashboard;

import android.support.annotation.NonNull;

import uz.zgora.pl.raspberry.model.Configuration;

interface DashboardView {

    void navigateToConfigurationView(final @NonNull Configuration configuration);

    void navigateToConnectionView();

    void navigateToConfigurationListView();
}
