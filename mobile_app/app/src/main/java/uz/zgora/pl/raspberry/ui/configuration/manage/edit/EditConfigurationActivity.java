package uz.zgora.pl.raspberry.ui.configuration.manage.edit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import uz.zgora.pl.raspberry.R;
import uz.zgora.pl.raspberry.model.SensorDetails;
import uz.zgora.pl.raspberry.ui.base.TabActivity;
import uz.zgora.pl.raspberry.ui.base.TabPage;
import uz.zgora.pl.raspberry.ui.configuration.list.ConfigurationListActivity;
import uz.zgora.pl.raspberry.util.AndroidUtils;

public class EditConfigurationActivity extends TabActivity<SensorDetails> {
    private static final String KEY_CONFIGURATION_ID = "key-configuration-id";

    private EditConfigurationPresenter presenter;

    private List<TabPage<SensorDetails>> configurationPages;
    private int configurationId;

    private int saveStatus = 0;

    public static Intent createExtras(final Context context, final int configurationId) {
        final Intent intent = new Intent(context, EditConfigurationActivity.class);
        intent.putExtra(KEY_CONFIGURATION_ID, configurationId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new EditConfigurationPresenter(this);
        configurationId = getIntent().getIntExtra(KEY_CONFIGURATION_ID, 0);

        if (savedInstanceState == null) {
            presenter.getDetails(configurationId);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_configuration_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        goToConfigurationList();
    }

    private void goToConfigurationList() {
        AndroidUtils.startActivityWithoutHistory(this, ConfigurationListActivity.class);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == R.id.action_update) {
            presenter.update(configurationId, build());
            return true;
        } else return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        goToConfigurationList();
        return super.onSupportNavigateUp();
    }

    public List<SensorDetails> build() {
        return Observable.fromIterable(configurationPages)
                .map(TabPage::build)
                .toList()
                .blockingGet();
    }

    void showSensorDetailsList(final List<SensorDetails> sensorDetailsList) {
        configurationPages.addAll(Observable.fromIterable(sensorDetailsList)
                .map(ConfigurationPage::newInstance)
                .toList()
                .blockingGet());
        notifyDataSetChanged();
    }

    @Override
    protected List<TabPage<SensorDetails>> getPages() {
        configurationPages = new ArrayList<>();
        return configurationPages;
    }

    public void notifySaved() {
        if (++saveStatus == 4) {
            setResult(RESULT_OK);
            finish();
        }
    }
}