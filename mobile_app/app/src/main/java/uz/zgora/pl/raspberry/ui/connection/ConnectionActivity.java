package uz.zgora.pl.raspberry.ui.connection;

import butterknife.OnClick;
import uz.zgora.pl.raspberry.R;
import uz.zgora.pl.raspberry.ui.base.BaseActivity;
import uz.zgora.pl.raspberry.ui.dashboard.DashboardActivity;

import static uz.zgora.pl.raspberry.util.AndroidUtils.startActivityWithoutHistory;

public class ConnectionActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_connection;
    }

    @OnClick(R.id.btnConnect)
    void tryToConnect() {
        startActivityWithoutHistory(this, DashboardActivity.class);
    }
}
