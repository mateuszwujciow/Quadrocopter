package uz.zgora.pl.raspberry.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import static uz.zgora.pl.raspberry.util.Objects.isNotNull;
import static uz.zgora.pl.raspberry.util.Objects.isNull;

public class ConfigurationGroup implements Serializable {
    private List<Configuration> configurations;

    public ConfigurationGroup(@Nullable final List<Configuration> configurations) {
        this.configurations = isNull(configurations) ? Collections.emptyList() : configurations;
    }

    public void add(@Nullable Configuration configuration) {
        if (isNotNull(configuration)) configurations.add(configuration);
    }

    @NonNull
    public List<Configuration> getConfigurations() {
        return configurations;
    }
}
