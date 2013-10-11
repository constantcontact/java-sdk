package com.constantcontact.components.library.file;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyLibraryThumbnail extends Component implements Serializable {

    private static final long serialVersionUID = 4566073496863150186L;

    @JsonIgnore
    private Integer height;
    
    @JsonIgnore
    private Integer width;
    
    @JsonIgnore
    private String url;

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("MyLibraryThumbnail [");

        builder.append("height=").append(height);
        builder.append(", width=").append(width);
        builder.append(", url=").append(url);

        builder.append("]");

        return builder.toString();
    }
}
