package uz.zgora.pl.raspberry.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Configuration implements Serializable {
    private int id;
    private String name;
    @SerializedName("last_update")
    private String lastModificationDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getLastModificationDate() {
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS", Locale.getDefault());
        Date date = new Date();
        try {
            date = formatter.parse(lastModificationDate);
        } catch (final ParseException exception) {
            exception.printStackTrace();
        }
        return date;
    }
}