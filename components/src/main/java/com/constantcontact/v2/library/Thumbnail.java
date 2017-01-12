package com.constantcontact.v2.library;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Thumbnail implements Serializable {
    @JsonProperty("url")
    protected String _url;

    @JsonProperty("height")
    protected int _height;

    @JsonProperty("width")
    protected int _width;

    public Thumbnail() {
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String url) {
        _url = url;
    }

    public int getHeight() {
        return _height;
    }

    public void setHeight(int height) {
        _height = height;
    }

    public int getWidth() {
        return _width;
    }

    public void setWidth(int width) {
        _width = width;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Thumbnail)) {
            return false;
        } else {
            Thumbnail rhs = (Thumbnail) obj;
            return new EqualsBuilder()
                    .append(_url, rhs.getUrl())
                    .append(_height, rhs.getHeight())
                    .append(_width, rhs.getWidth())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_url)
                .append(_height)
                .append(_width)
                .hashCode();
    }
}
