package uz.zgora.pl.raspberry.model;

import java.io.Serializable;
import java.util.Date;

public class Configuration implements Serializable {
    private final long id;
    private final String name;
    private final Date lastModificationDate;

    public Configuration(final long id, final String name, final Date lastModificationDate) {
        this.id = id;
        this.name = name;
        this.lastModificationDate = lastModificationDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getLastModificationDate() {
        return lastModificationDate == null ? new Date() : lastModificationDate;
    }
}