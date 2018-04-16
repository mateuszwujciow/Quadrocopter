package uz.zgora.pl.raspberry.ui.dashboard;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import butterknife.OnClick;
import uz.zgora.pl.raspberry.R;
import uz.zgora.pl.raspberry.model.Configuration;
import uz.zgora.pl.raspberry.ui.base.BaseActivity;
import uz.zgora.pl.raspberry.ui.configuration.ConfigurationActivity;
import uz.zgora.pl.raspberry.ui.configuration.list.ConfigurationListActivity;
import uz.zgora.pl.raspberry.ui.connection.ConnectionActivity;

import static uz.zgora.pl.raspberry.util.AndroidUtils.startActivityWithoutHistory;

public class DashboardActivity extends BaseActivity implements DashboardView {
    private DashboardPresenter presenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new DashboardPresenter(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_dashboard;
    }

    @OnClick(R.id.btnCurrentConfiguration)
    void showCurrentConfiguration() {
        presenter.showCurrentConfiguration();
    }

    @OnClick(R.id.btnConfigurationList)
    void showConfigurationList() {
        presenter.showConfigurationList();
    }

    @OnClick(R.id.btnAddConfiguration)
    void showAddConfigurationView() {
        presenter.showAddConfigurationView();
    }

    @OnClick(R.id.btnVideoStream)
    void showVideoStream() {
        presenter.showVideoStream();
    }

    @OnClick(R.id.btnDisconnect)
    void disconnect() {
        presenter.disconnect();
    }

    @Override
    public void navigateToConfigurationView(@NonNull Configuration configuration) {
        ConfigurationActivity.start(this, configuration);
    }

    @Override
    public void navigateToConnectionView() {
        startActivityWithoutHistory(this, ConnectionActivity.class);
    }

    @Override
    public void navigateToConfigurationListView() {
        ConfigurationListActivity.start(this);
    }
}
