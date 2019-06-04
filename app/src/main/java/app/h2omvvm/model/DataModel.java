package app.h2omvvm.model;

import android.support.annotation.Nullable;

public class DataModel {
    private String title;
    private String name;


    public DataModel() {
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }





    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }
}
