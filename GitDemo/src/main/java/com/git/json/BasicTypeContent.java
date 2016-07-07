package com.git.json;

public class BasicTypeContent {

    private String type;
    
    private String text;
    
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BasicTypeContent [type=" + type + ", text=" + text + ", url=" + url + "]";
    }
    
    
}
