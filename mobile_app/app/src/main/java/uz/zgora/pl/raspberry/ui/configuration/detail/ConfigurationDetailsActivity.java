package uz.zgora.pl.raspberry.ui.configuration.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import io.reactivex.Observable;
import uz.zgora.pl.raspberry.R;
import uz.zgora.pl.raspberry.model.Sensor;
import uz.zgora.pl.raspberry.model.SensorDetails;
import uz.zgora.pl.raspberry.ui.base.BaseActivity;
import uz.zgora.pl.raspberry.ui.configuration.list.ConfigurationListActivity;
import uz.zgora.pl.raspberry.ui.configuration.manage.edit.EditConfigurationActivity;
import uz.zgora.pl.raspberry.util.AndroidUtils;

public class ConfigurationDetailsActivity extends BaseActivity {
    public static final int CURRENT_CONFIGURATION_ID = -1;

    private static final String KEY_CONFIGURATION_ID = "key-configuration-id";
    private static final int UPDATE_REQUEST = 10;

    @BindView(R.id.viewPitch)
    SectionView viewPitch;
    @BindView(R.id.viewRoll)
    SectionView viewRoll;
    @BindView(R.id.viewThrust)
    SectionView viewThrust;
    @BindView(R.id.viewYaw)
    SectionView viewYaw;

    private ConfigurationDetailsPresenter presenter;

    private Map<String, SectionView> sectionViewMap;
    private int configurationId;

    public static void start(final Activity startingActivity, final int configurationId) {
        final Intent intent = new Intent(startingActivity, ConfigurationDetailsActivity.class);
        intent.putExtra(KEY_CONFIGURATION_ID, configurationId);
        startingActivity.startActivity(intent);
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_configuration_details;
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sectionViewMap = new HashMap<>();
        sectionViewMap.put("Pitch", viewPitch);
        sectionViewMap.put("Roll", viewRoll);
        sectionViewMap.put("Thrust", viewThrust);
        sectionViewMap.put("Yaw", viewYaw);
        configurationId = getIntent().getIntExtra(KEY_CONFIGURATION_ID, CURRENT_CONFIGURATION_ID);
        presenter = new ConfigurationDetailsPresenter(this);
        presenter.fetchConfiguration(configurationId);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == UPDATE_REQUEST && resultCode == RESULT_OK) {
            presenter.fetchConfiguration(configurationId);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_configuration_details_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_upload:
                presenter.uploadConfiguration(configurationId);
                return true;

            case R.id.action_edit:
                final Intent intent = EditConfigurationActivity.createExtras(this, configurationId);
                startActivityForResult(intent, UPDATE_REQUEST);
                return true;

            case R.id.action_remove:
                presenter.removeConfiguration(configurationId);
                return true;

            default: return super.onOptionsItemSelected(item);
        }
    }

    public void bindConfigurationDetails(final List<SensorDetails> sensorDetailsGroup) {
        configurationId = sensorDetailsGroup.isEmpty() ? 0 : sensorDetailsGroup.get(0).getId();
        Observable.fromIterable(sensorDetailsGroup).forEach(this::bindSensor);
    }

    private void bindSensor(final SensorDetails sensorDetails) {
        final Sensor configuration = sensorDetails.getSensor();
        final SectionView sectionView = sectionViewMap.get(sensorDetails.getName());
        bindSensor(sectionView, configuration);
    }

    private void bindSensor(final SectionView sectionView, final Sensor configuration) {
        sectionView.setKd(configuration.getKd());
        sectionView.setKi(configuration.getKi());
        sectionView.setKp(configuration.getKp());
        sectionView.setTf(configuration.getTf());
    }

    void showUploaded() {
        Toast.makeText(this, "Configuration uploaded successfully!", Toast.LENGTH_LONG).show();
    }

    public void handleRemoved() {
        Toast.makeText(this, "Configuration removed successfully!", Toast.LENGTH_LONG).show();
        AndroidUtils.startActivityWithoutHistory(this, ConfigurationListActivity.class);
    }
}
