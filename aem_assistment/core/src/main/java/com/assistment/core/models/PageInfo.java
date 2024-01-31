package com.assistment.core.models;

public class PageInfo {
    private String path;
    private String title;

    public PageInfo(String path, String title) {
        this.path = path;
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }
}
