package com.constantcontact.v2.contacts;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Generated response from the server after requesting a signup form.
 * @see <a href="http://developer.constantcontact.com/docs/signup-forms-tools/signup-form-creation.html">Signup Form Creation</a>
 *
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class SignupFormResponse implements Parcelable {
    @JsonProperty("source")
    private String _source;

    @JsonProperty("list_name")
    private String _listName;

    @JsonProperty("signup_form_url")
    private String _signupFormUrl;

    @JsonProperty("contact_lists")
    private String[] _contactLists;

    public String getSource() {
        return _source;
    }

    public void setSource(String source) {
        _source = source;
    }

    public String getListName() {
        return _listName;
    }

    public void setListName(String listName) {
        _listName = listName;
    }

    public String getSignupFormUrl() {
        return _signupFormUrl;
    }

    public void setSignupFormUrl(String signupFormUrl) {
        _signupFormUrl = signupFormUrl;
    }

    public String[] getContactLists() {
        return _contactLists;
    }

    public void setContactLists(String[] contactLists) {
        _contactLists = contactLists;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_source);
        dest.writeString(_listName);
        dest.writeString(_signupFormUrl);
        dest.writeStringArray(_contactLists);
    }

    public SignupFormResponse() {
    }

    protected SignupFormResponse(Parcel in) {
        _source = in.readString();
        _listName = in.readString();
        _signupFormUrl = in.readString();
        _contactLists = in.createStringArray();
    }

    public static final Parcelable.Creator<SignupFormResponse> CREATOR = new Parcelable.Creator<SignupFormResponse>() {
        @Override
        public SignupFormResponse createFromParcel(Parcel source) {
            return new SignupFormResponse(source);
        }

        @Override
        public SignupFormResponse[] newArray(int size) {
            return new SignupFormResponse[size];
        }
    };
}
