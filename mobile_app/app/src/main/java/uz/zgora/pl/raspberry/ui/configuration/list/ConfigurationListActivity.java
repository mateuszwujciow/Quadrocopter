package uz.zgora.pl.raspberry.ui.configuration.list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import uz.zgora.pl.raspberry.model.ConfigurationGroup;
import uz.zgora.pl.raspberry.ui.base.ListActivity;

public class ConfigurationListActivity extends ListActivity {
    private static final String KEY_CONFIGURATION_GROUP = "key-configuration-group";

    public static void start(final Context context, final ConfigurationGroup configurationGroup) {
        final Intent intent = new Intent(context, ConfigurationListActivity.class);
        intent.putExtra(KEY_CONFIGURATION_GROUP, configurationGroup);
        context.startActivity(intent);
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        final ConfigurationGroup configurationGroup = (ConfigurationGroup) getIntent().getSerializableExtra(KEY_CONFIGURATION_GROUP);
        return new ConfigurationListAdapter(configurationGroup, null);
    }
}
