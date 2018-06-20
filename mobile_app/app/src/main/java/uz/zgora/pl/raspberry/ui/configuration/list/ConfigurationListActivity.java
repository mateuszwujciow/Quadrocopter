package uz.zgora.pl.raspberry.ui.configuration.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import uz.zgora.pl.raspberry.model.Configuration;
import uz.zgora.pl.raspberry.ui.base.ListActivity;
import uz.zgora.pl.raspberry.ui.configuration.detail.ConfigurationDetailsActivity;

public class ConfigurationListActivity extends ListActivity {
    private final List<Configuration> configurations = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ConfigurationListPresenter(this).fetchConfigurations();
    }

    @Override
    protected RecyclerView.Adapter createAdapter() {
        return new ConfigurationListAdapter(configurations,
                it -> ConfigurationDetailsActivity.start(this, it.getId()));
    }

    public void bindConfigurations(final List<Configuration> configurations) {
        this.configurations.addAll(configurations);
        refreshData();
    }
}
