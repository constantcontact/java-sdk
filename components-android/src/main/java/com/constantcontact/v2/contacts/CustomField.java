package com.constantcontact.v2.contacts;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class CustomField implements Parcelable {
    @JsonProperty("name")
    protected String _name;

    @JsonProperty("label")
    protected String _label;

    @JsonProperty("value")
    protected String _value;

    public CustomField() {
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getLabel() {
        return _label;
    }

    public void setLabel(String label) {
        _label = label;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String value) {
        _value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_name);
        dest.writeString(_label);
        dest.writeString(_value);
    }

    protected CustomField(Parcel in) {
        _name = in.readString();
        _label = in.readString();
        _value = in.readString();
    }

    public static final Parcelable.Creator<CustomField> CREATOR = new Parcelable.Creator<CustomField>() {
        @Override
        public CustomField createFromParcel(Parcel source) {
            return new CustomField(source);
        }

        @Override
        public CustomField[] newArray(int size) {
            return new CustomField[size];
        }
    };
}
