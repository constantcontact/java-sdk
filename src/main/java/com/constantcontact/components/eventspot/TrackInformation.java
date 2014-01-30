package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class TrackInformation extends Component implements Serializable{

    private static final long serialVersionUID = -678644077929558066L;

    private String earlyFeeDate;
    private String guestDisplayLabel;
    private Integer guestLimit;
    private List<String> informationSections;
    private boolean isGuestAnonymousEnabled;
    private boolean isGuestNameRequired;
    private boolean isRegistrationClosedManually;
    private boolean isTicketingLinkDisplayed;
    private String lateFeeDate;
    private Integer registrationLimitCount;
    private String registrationLimitDate;


    @JsonProperty("early_fee_date")
    public String getEarlyFeeDate() {
        return earlyFeeDate;
    }

    @JsonProperty("guest_display_label")
    public String getGuestDisplayLabel() {
        return guestDisplayLabel;
    }

    @JsonProperty("guest_limit")
    public Integer getGuestLimit() {
        return guestLimit;
    }

    @JsonProperty("information_sections")
    public List<String> getInformationSections() {
        return informationSections;
    }

    @JsonProperty("is_guest_anonymous_enabled")
    public boolean isGuestAnonymousEnabled() {
        return isGuestAnonymousEnabled;
    }

    @JsonProperty("is_guest_name_required")
    public boolean isGuestNameRequired() {
        return isGuestNameRequired;
    }

    @JsonProperty("is_registration_closed_manually")
    public boolean isRegistrationClosedManually() {
        return isRegistrationClosedManually;
    }

    @JsonProperty("is_ticketing_link_displayed")
    public boolean isTicketingLinkDisplayed() {
        return isTicketingLinkDisplayed;
    }

    @JsonProperty("late_fee_date")
    public String getLateFeeDate() {
        return lateFeeDate;
    }

    @JsonProperty("registration_limit_count")
    public Integer getRegistrationLimitCount() {
        return registrationLimitCount;
    }

    @JsonProperty("registration_limit_date")
    public String getRegistrationLimitDate() {
        return registrationLimitDate;
    }

    public void setEarlyFeeDate(String earlyFeeDate) {
        this.earlyFeeDate = earlyFeeDate;
    }

    public void setGuestDisplayLabel(String guestDisplayLabel) {
        this.guestDisplayLabel = guestDisplayLabel;
    }

    public void setGuestLimit(Integer guestLimit) {
        this.guestLimit = guestLimit;
    }

    public void setInformationSections(List<String> informationSections) {
        this.informationSections = informationSections;
    }

    public void setGuestAnonymousEnabled(boolean isGuestAnonymousEnabled) {
        this.isGuestAnonymousEnabled = isGuestAnonymousEnabled;
    }

    public void setGuestNameRequired(boolean isGuestNameRequired) {
        this.isGuestNameRequired = isGuestNameRequired;
    }

    public void setRegistrationClosedManually(boolean isRegistrationClosedManually) {
        this.isRegistrationClosedManually = isRegistrationClosedManually;
    }

    public void setTicketingLinkDisplayed(boolean isTicketingLinkDisplayed) {
        this.isTicketingLinkDisplayed = isTicketingLinkDisplayed;
    }

    public void setLateFeeDate(String lateFeeDate) {
        this.lateFeeDate = lateFeeDate;
    }

    public void setRegistrationLimitCount(Integer registrationLimitCount) {
        this.registrationLimitCount = registrationLimitCount;
    }

    public void setRegistrationLimitDate(String registrationLimitDate) {
        this.registrationLimitDate = registrationLimitDate;
    }


    /**
     * Default constructor.
     */
    public TrackInformation() {
        super();
    }

    public static final class InformationSections {
        public static final String CONTACT = "CONTACT";
        public static final String TIME = "TIME";
        public static final String LOCATION = "LOCATION";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private InformationSections() {
        }
    }

}
