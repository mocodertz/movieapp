package com.jengasoft.movietheater;

import java.io.Serializable;

/**
 * Created by MoCoder#1956# on 4/1/2018.
 */

public class Cinema implements Serializable {
    private String name;
    private String photo;

    public Cinema(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
