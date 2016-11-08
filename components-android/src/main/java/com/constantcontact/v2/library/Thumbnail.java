package com.constantcontact.v2.library;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Thumbnail implements Parcelable {
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_url);
        dest.writeInt(_height);
        dest.writeInt(_width);
    }

    protected Thumbnail(Parcel in) {
        _url = in.readString();
        _height = in.readInt();
        _width = in.readInt();
    }

    public static final Parcelable.Creator<Thumbnail> CREATOR = new Parcelable.Creator<Thumbnail>() {
        @Override
        public Thumbnail createFromParcel(Parcel source) {
            return new Thumbnail(source);
        }

        @Override
        public Thumbnail[] newArray(int size) {
            return new Thumbnail[size];
        }
    };
}
