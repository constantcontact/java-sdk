package com.constantcontact.v2.contacts;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Payload to give the server when requesting a signup form
 * @see <a href="http://developer.constantcontact.com/docs/signup-forms-tools/signup-form-creation.html">Signup Form Creation</a>
 *
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class SignupFormRequest implements Parcelable {
    @JsonProperty("contact_lists")
    private String[] _contactLists;

    @JsonProperty("list_name")
    private String _listName;

    @JsonProperty("source")
    private String _source;

    public String[] getContactLists() {
        return _contactLists;
    }

    public void setContactLists(String[] contactLists) {
        _contactLists = contactLists;
    }

    public String getListName() {
        return _listName;
    }

    public void setListName(String listName) {
        _listName = listName;
    }

    public String getSource() {
        return _source;
    }

    public void setSource(String source) {
        _source = source;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(_contactLists);
        dest.writeString(_listName);
        dest.writeString(_source);
    }

    public SignupFormRequest() {
    }

    protected SignupFormRequest(Parcel in) {
        _contactLists = in.createStringArray();
        _listName = in.readString();
        _source = in.readString();
    }

    public static final Parcelable.Creator<SignupFormRequest> CREATOR = new Parcelable.Creator<SignupFormRequest>() {
        @Override
        public SignupFormRequest createFromParcel(Parcel source) {
            return new SignupFormRequest(source);
        }

        @Override
        public SignupFormRequest[] newArray(int size) {
            return new SignupFormRequest[size];
        }
    };
}
