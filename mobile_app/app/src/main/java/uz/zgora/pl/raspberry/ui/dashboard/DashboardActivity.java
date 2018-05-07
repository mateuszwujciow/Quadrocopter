package uz.zgora.pl.raspberry.ui.dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.OnClick;
import uz.zgora.pl.raspberry.R;
import uz.zgora.pl.raspberry.model.ConfigurationDetails;
import uz.zgora.pl.raspberry.model.ConfigurationGroup;
import uz.zgora.pl.raspberry.ui.base.BaseActivity;
import uz.zgora.pl.raspberry.ui.configuration.list.ConfigurationListActivity;
import uz.zgora.pl.raspberry.ui.configuration.manage.ConfigurationActivity;
import uz.zgora.pl.raspberry.ui.connection.ConnectionActivity;
import uz.zgora.pl.raspberry.ui.video.VideoStreamActivity;
import uz.zgora.pl.raspberry.util.AndroidUtils;

import static uz.zgora.pl.raspberry.util.Objects.isNull;

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
    public void navigateToConfigurationView(@Nullable final ConfigurationDetails configurationDetails) {
        if (isNull(configurationDetails)) {
            AndroidUtils.startActivity(this, ConfigurationActivity.class);
        } else {
            ConfigurationActivity.start(this, configurationDetails);
        }
    }

    @Override
    public void navigateToConnectionView() {
        AndroidUtils.startActivityWithoutHistory(this, ConnectionActivity.class);
    }

    @Override
    public void navigateToConfigurationListView(final ConfigurationGroup configurationGroup) {
        ConfigurationListActivity.start(this, configurationGroup);
    }

    @Override
    public void navigateToVideoStreamView() {
        AndroidUtils.startActivity(this, VideoStreamActivity.class);
    }
}
