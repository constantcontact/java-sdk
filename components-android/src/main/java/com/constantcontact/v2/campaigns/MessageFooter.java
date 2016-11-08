package com.constantcontact.v2.campaigns;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class MessageFooter implements Parcelable {
    @JsonProperty("address_line_1")
    @JsonInclude(Include.NON_EMPTY)
    protected String _addressLine1;

    @JsonProperty("address_line_2")
    @JsonInclude(Include.NON_EMPTY)
    protected String _addressLine2;

    @JsonProperty("address_line_3")
    @JsonInclude(Include.NON_EMPTY)
    protected String _addressLine3;

    @JsonProperty("city")
    @JsonInclude(Include.NON_EMPTY)
    protected String _city;

    @JsonProperty("country")
    @JsonInclude(Include.NON_EMPTY)
    protected String _country;

    @JsonProperty("forward_email_link_text")
    @JsonInclude(Include.NON_EMPTY)
    protected String _forwardEmailLinkText;

    @JsonProperty("include_forward_email")
    protected boolean _includeForwardEmail;

    @JsonProperty("include_subscribe_link")
    protected boolean _includeSubscribeLink;

    @JsonProperty("international_state")
    @JsonInclude(Include.NON_EMPTY)
    protected String _internationalState;

    @JsonProperty("organization_name")
    @JsonInclude(Include.NON_EMPTY)
    protected String _organizationName;

    @JsonProperty("postal_code")
    @JsonInclude(Include.NON_EMPTY)
    protected String _postalCode;

    @JsonProperty("state")
    @JsonInclude(Include.NON_EMPTY)
    protected String _state;

    @JsonProperty("subscribe_link_text")
    @JsonInclude(Include.NON_EMPTY)
    protected String _subscribeLinkText;

    public MessageFooter() {
    }

    public String getAddressLine1() {
        return _addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        _addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return _addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        _addressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return _addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        _addressLine3 = addressLine3;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String city) {
        _city = city;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(String country) {
        _country = country;
    }

    public String getForwardEmailLinkText() {
        return _forwardEmailLinkText;
    }

    public void setForwardEmailLinkText(String forwardEmailLinkText) {
        _forwardEmailLinkText = forwardEmailLinkText;
    }

    public boolean getIsIncludeForwardEmail() {
        return _includeForwardEmail;
    }

    public void setIncludeForwardEmail(boolean includeForwardEmail) {
        _includeForwardEmail = includeForwardEmail;
    }

    public boolean getIsIncludeSubscribeLink() {
        return _includeSubscribeLink;
    }

    public void setIncludeSubscribeLink(boolean includeSubscribeLink) {
        _includeSubscribeLink = includeSubscribeLink;
    }

    public String getInternationalState() {
        return _internationalState;
    }

    public void setInternationalState(String internationalState) {
        _internationalState = internationalState;
    }

    public String getOrganizationName() {
        return _organizationName;
    }

    public void setOrganizationName(String organizationName) {
        _organizationName = organizationName;
    }

    public String getPostalCode() {
        return _postalCode;
    }

    public void setPostalCode(String postalCode) {
        _postalCode = postalCode;
    }

    public String getState() {
        return _state;
    }

    public void setState(String state) {
        _state = state;
    }

    public String getSubscribeLinkText() {
        return _subscribeLinkText;
    }

    public void setSubscribeLinkText(String subscribeLinkText) {
        _subscribeLinkText = subscribeLinkText;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_addressLine1);
        dest.writeString(_addressLine2);
        dest.writeString(_addressLine3);
        dest.writeString(_city);
        dest.writeString(_country);
        dest.writeString(_forwardEmailLinkText);
        dest.writeByte(_includeForwardEmail ? (byte) 1 : (byte) 0);
        dest.writeByte(_includeSubscribeLink ? (byte) 1 : (byte) 0);
        dest.writeString(_internationalState);
        dest.writeString(_organizationName);
        dest.writeString(_postalCode);
        dest.writeString(_state);
        dest.writeString(_subscribeLinkText);
    }

    protected MessageFooter(Parcel in) {
        _addressLine1 = in.readString();
        _addressLine2 = in.readString();
        _addressLine3 = in.readString();
        _city = in.readString();
        _country = in.readString();
        _forwardEmailLinkText = in.readString();
        _includeForwardEmail = in.readByte() != 0;
        _includeSubscribeLink = in.readByte() != 0;
        _internationalState = in.readString();
        _organizationName = in.readString();
        _postalCode = in.readString();
        _state = in.readString();
        _subscribeLinkText = in.readString();
    }

    public static final Creator<MessageFooter> CREATOR = new Creator<MessageFooter>() {
        @Override
        public MessageFooter createFromParcel(Parcel source) {
            return new MessageFooter(source);
        }

        @Override
        public MessageFooter[] newArray(int size) {
            return new MessageFooter[size];
        }
    };
}
