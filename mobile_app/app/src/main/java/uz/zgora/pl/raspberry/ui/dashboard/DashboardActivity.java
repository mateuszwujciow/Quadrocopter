package uz.zgora.pl.raspberry.ui.dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.OnClick;
import uz.zgora.pl.raspberry.R;
import uz.zgora.pl.raspberry.ui.base.BaseActivity;
import uz.zgora.pl.raspberry.ui.configuration.detail.ConfigurationDetailsActivity;
import uz.zgora.pl.raspberry.ui.configuration.list.ConfigurationListActivity;
import uz.zgora.pl.raspberry.ui.configuration.manage.add.AddConfigurationActivity;
import uz.zgora.pl.raspberry.ui.video.VideoStreamActivity;
import uz.zgora.pl.raspberry.util.AndroidUtils;

import static uz.zgora.pl.raspberry.ui.configuration.detail.ConfigurationDetailsActivity.CURRENT_CONFIGURATION_ID;

public class DashboardActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_dashboard;
    }

    @OnClick(R.id.btnCurrentConfiguration)
    void showCurrentConfiguration() {
        ConfigurationDetailsActivity.start(this, CURRENT_CONFIGURATION_ID);
    }

    @OnClick(R.id.btnConfigurationList)
    void showConfigurationList() {
        AndroidUtils.startActivity(this, ConfigurationListActivity.class);
    }

    @OnClick(R.id.btnAddConfiguration)
    void showAddConfigurationView() {
        AndroidUtils.startActivity(this, AddConfigurationActivity.class);
    }

    @OnClick(R.id.btnVideoStream)
    void showVideoStream() {
        AndroidUtils.startActivity(this, VideoStreamActivity.class);
    }

    @OnClick(R.id.btnSettings)
    void disconnect() {
//        AndroidUtils.startActivityWithoutHistory(this, ConnectionActivity.class);
    }

}
