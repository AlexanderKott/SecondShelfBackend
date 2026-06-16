package com.example.secondShelf.controller.models;

public class Posting {
    long id;
    String caption;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Posting(long id) {
        this.id = id;
    }
}
