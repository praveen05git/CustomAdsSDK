package com.example.adslibrary;

public class adProperties {

    String Name;
    String Url;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public adProperties() {
    }

    public adProperties(String name, String url) {
        Name = name;
        Url = url;
    }
}
