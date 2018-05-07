package uz.zgora.pl.raspberry.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class ConfigurationDetails implements Serializable {
    private final int id;
    private final String name;
    private final List<SingleConfiguration> configurations;

    public static ConfigurationDetails EMPTY() {
        final List<SingleConfiguration> configurations = Arrays.asList(
                SingleConfiguration.EMPTY(SingleConfiguration.Type.PITCH),
                SingleConfiguration.EMPTY(SingleConfiguration.Type.ROLL),
                SingleConfiguration.EMPTY(SingleConfiguration.Type.THRUST),
                SingleConfiguration.EMPTY(SingleConfiguration.Type.YAW)
        );
        return new ConfigurationDetails(0, "EMPTY", configurations);
    }

    public ConfigurationDetails(final int id, final String name, final List<SingleConfiguration> configurations) {
        this.id = id;
        this.name = name;
        this.configurations = configurations;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<SingleConfiguration> getConfigurations() {
        return configurations;
    }
}
