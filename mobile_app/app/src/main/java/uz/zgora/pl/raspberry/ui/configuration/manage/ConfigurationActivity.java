package uz.zgora.pl.raspberry.ui.configuration.manage;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import io.reactivex.Observable;
import uz.zgora.pl.raspberry.R;
import uz.zgora.pl.raspberry.model.ConfigurationDetails;
import uz.zgora.pl.raspberry.model.SingleConfiguration;
import uz.zgora.pl.raspberry.ui.base.TabActivity;
import uz.zgora.pl.raspberry.ui.base.TabPage;

import static uz.zgora.pl.raspberry.util.Objects.isNull;

public class ConfigurationActivity extends TabActivity<SingleConfiguration> implements ManageConfigurationView {
    private static final String KEY_CONFIGURATION = "key-configuration";

    private ManageConfigurationPresenter presenter;

    private List<TabPage<SingleConfiguration>> configurationPages;

    private String configurationName = "temporaryName";

    public static void start(final Context context, final @NonNull ConfigurationDetails configurationDetails) {
        final Intent intent = new Intent(context, ConfigurationActivity.class);
        intent.putExtra(KEY_CONFIGURATION, configurationDetails);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ManageConfigurationPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_configuration_activity, menu);
        final MenuItem item = menu.findItem(R.id.action_manage);
        item.setTitle(isEditMode() ? "SAVE" : "ADD");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_manage:
                final FragmentTransaction transaction = getFragmentManager().beginTransaction();
                final ConfigurationNameDialog dialog = new ConfigurationNameDialog();
                dialog.setPossitiveAction(it -> {
                    configurationName = it;
                    presenter.manageConfiguration();
                });
                dialog.show(transaction, null);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public ConfigurationDetails build() {
        return Observable.fromIterable(configurationPages)
                .map(TabPage::build)
                .toList()
                .map(it -> new ConfigurationDetails(getConfigurationDetails().getId(), configurationName, it))
                .blockingGet();
    }

    public boolean isEditMode() {
        return getIntent().hasExtra(KEY_CONFIGURATION);
    }

    @Override
    protected List<TabPage<SingleConfiguration>> getPages() {
        configurationPages = Observable.fromIterable(getConfigurationDetails().getConfigurations())
                .map(ConfigurationPage::newInstance)
                .toList()
                .blockingGet();
        return configurationPages;
    }

    private ConfigurationDetails getConfigurationDetails() {
        final ConfigurationDetails configurationDetails = (ConfigurationDetails) getIntent().getSerializableExtra(KEY_CONFIGURATION);
        return isNull(configurationDetails) ? ConfigurationDetails.EMPTY() : configurationDetails;
    }
}