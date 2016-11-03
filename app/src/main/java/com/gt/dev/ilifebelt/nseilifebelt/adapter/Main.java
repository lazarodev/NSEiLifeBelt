package com.gt.dev.ilifebelt.nseilifebelt.adapter;

/**
 * Created by Lazarus on 25/10/2016.
 */

public class Main {

    private String title;
    private String description;
    private int picture;

    public String getTitle() {
        return title;
    }

    public Main(String title, String description, int picture) {
        super();
        this.title = title;
        this.description = description;
        this.picture = picture;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }


}
