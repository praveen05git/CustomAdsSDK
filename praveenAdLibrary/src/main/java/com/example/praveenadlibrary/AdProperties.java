package com.example.praveenadlibrary;

public class AdProperties {

    String name;
    String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AdProperties() {
    }

    public AdProperties(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
