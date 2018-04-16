package uz.zgora.pl.raspberry.ui.configuration.list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;

import uz.zgora.pl.raspberry.model.Configuration;
import uz.zgora.pl.raspberry.ui.base.ListActivity;

public class ConfigurationListActivity extends ListActivity {

    public static void start(final Context context) {
        final Intent intent = new Intent(context, ConfigurationListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new ConfigurationListAdapter(Arrays.asList(Configuration.EMPTY(), Configuration.EMPTY(), Configuration.EMPTY(), Configuration.EMPTY(), Configuration.EMPTY(), Configuration.EMPTY(), Configuration.EMPTY(), Configuration.EMPTY(), Configuration.EMPTY(), Configuration.EMPTY(), Configuration.EMPTY(), Configuration.EMPTY(), Configuration.EMPTY(), Configuration.EMPTY(), Configuration.EMPTY()), null);
    }
}
