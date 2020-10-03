package com.example.praveenadlibrary;

public class adProperties {

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

    public adProperties() {
    }

    public adProperties(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
