package uz.zgora.pl.raspberry.ui.configuration;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;
import uz.zgora.pl.raspberry.model.Configuration;
import uz.zgora.pl.raspberry.ui.base.TabActivity;
import uz.zgora.pl.raspberry.ui.base.TabPage;

public class ConfigurationActivity extends TabActivity {
    private static final String KEY_CONFIGURATION = "key-configuration";

    public static void start(final Context context, final @NonNull Configuration configuration) {
        final Intent intent = new Intent(context, ConfigurationActivity.class);
        intent.putExtra(KEY_CONFIGURATION, configuration);
        context.startActivity(intent);
    }

    @Override
    protected List<TabPage> getPages() {
        return Observable.fromIterable(getConfiguration().getConfigurations())
                .map(ConfigurationPage::newInstance)
                .toList()
                .blockingGet();
    }

    private Configuration getConfiguration() {
        final Intent intent = getIntent();
        final Configuration configuration = (Configuration) intent.getSerializableExtra(KEY_CONFIGURATION);
        return configuration == null ? Configuration.EMPTY() : configuration;
    }
}