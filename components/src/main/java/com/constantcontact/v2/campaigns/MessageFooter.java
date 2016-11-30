package com.constantcontact.v2.campaigns;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class MessageFooter implements Serializable {
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
}
