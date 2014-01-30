package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Event extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = -7112248408381452939L;

    @JsonIgnore
    private String id;
    @JsonIgnore
    private String activeDate;
    @JsonIgnore
    private EventAddress address;
    @JsonIgnore
    private boolean areRegistrantsPublic;
    @JsonIgnore
    private String cancelledDate;
    @JsonIgnore
    private EventHostContact contact;
    @JsonIgnore
    private String createdDate;
    @JsonIgnore
    private String currencyType;
    @JsonIgnore
    private String deletedDate;
    @JsonIgnore
    private String description;
    @JsonIgnore
    private String endDate;
    @JsonIgnore
    private String googleAnalyticsKey;
    @JsonIgnore
    private String googleMechantId;
    @JsonIgnore
    private boolean isCalendarDisplayed;
    @JsonIgnore
    private boolean isCheckingAvailable;
    @JsonIgnore
    private boolean isHomePageDisplayed;
    @JsonIgnore
    private boolean isListedInExternalDirectory;
    @JsonIgnore
    private boolean isMapDisplayed;
    @JsonIgnore
    private boolean isVirtualEvent;
    @JsonIgnore
    private String location;
    @JsonIgnore
    private String metadataTags;
    @JsonIgnore
    private String name;
    @JsonIgnore
    private List<NotificationOptions> notificationOptions;
    @JsonIgnore
    private OnlineMeeting onlineMeeting;
    @JsonIgnore
    private String payableTo;

    @JsonIgnore
    private PaymentAddress paymentAddress;
    @JsonIgnore
    private List<String> paymentOptions;
    @JsonIgnore
    private String paypalAccountEmail;
    @JsonIgnore
    private String registrationUrl;
    @JsonIgnore
    private String startDate;
    @JsonIgnore
    private String status;
    @JsonIgnore
    private String themeName;
    @JsonIgnore
    private String timeZoneDescription;
    @JsonIgnore
    private String timeZoneId;
    @JsonIgnore
    private String title;
    @JsonIgnore
    private Integer totalRegisteredCount;
    @JsonIgnore
    private TrackInformation trackInformation;
    @JsonIgnore
    private String twitterHashTag;
    @JsonIgnore
    private String type;
    @JsonIgnore
    private String updatedDate;


    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("active_date")
    public String getActiveDate() {
        return activeDate;
    }

    @JsonProperty("address")
    public EventAddress getAddress() {
        //Todo ask if this is the desired workflow
        return isVirtualEvent() ? null : address;
    }

    @JsonProperty("are_registrants_public")
    public boolean isAreRegistrantsPublic() {
        return areRegistrantsPublic;
    }

    @JsonProperty("cancelled_date")
    public String getCancelledDate() {
        return cancelledDate;
    }

    @JsonProperty("contact")
    public EventHostContact getContact() {
        return contact;
    }

    @JsonProperty("created_date")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("currency_type")
    public String getCurrencyType() {
        return currencyType;
    }

    @JsonProperty("deleted_date")
    public String getDeletedDate() {
        return deletedDate;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("end_date")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("google_analytics_key")
    public String getGoogleAnalyticsKey() {
        return googleAnalyticsKey;
    }

    @JsonProperty("google_merchant_id")
    public String getGoogleMechantId() {
        return googleMechantId;
    }

    @JsonProperty("is_calendar_displayed")
    public boolean isCalendarDisplayed() {
        return isCalendarDisplayed;
    }

    @JsonProperty("is_checkin_available")
    public boolean isCheckingAvailable() {
        return isCheckingAvailable;
    }

    @JsonProperty("is_home_page_displayed")
    public boolean isHomePageDisplayed() {
        return isHomePageDisplayed;
    }

    @JsonProperty("is_listed_in_external_directory")
    public boolean isListedInExternalDirectory() {
        return isListedInExternalDirectory;
    }

    @JsonProperty("is_map_displayed")
    public boolean isMapDisplayed() {
        return isMapDisplayed;
    }

    @JsonProperty("is_virtual_event")
    public boolean isVirtualEvent() {
        return isVirtualEvent;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("meta_data_tags")
    public String getMetadataTags() {
        return metadataTags;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("notification_options")
    public List<NotificationOptions> getNotificationOptions() {
        return notificationOptions;
    }

    @JsonProperty("online_meeting")
    public OnlineMeeting getOnlineMeeting() {
        return onlineMeeting;
    }

    @JsonProperty("payable_to")
    public String getPayableTo() {
        return payableTo;
    }

    @JsonProperty("payment_address")
    public PaymentAddress getPaymentAddress() {
        return paymentAddress;
    }

    @JsonProperty("payment_options")
    public List<String> getPaymentOptions() {
        return paymentOptions;
    }

    @JsonProperty("paypal_account_email")
    public String getPaypalAccountEmail() {
        return paypalAccountEmail;
    }

    @JsonProperty("registration_url")
    public String getRegistrationUrl() {
        return registrationUrl;
    }

    @JsonProperty("start_date")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("theme_name")
    public String getThemeName() {
        return themeName;
    }

    //@JsonProperty("time_zone_description")
    public String getTimeZoneDescription() {
        return timeZoneDescription;
    }

    @JsonProperty("time_zone_id")
    public String getTimeZoneId() {
        return timeZoneId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("total_registered_count")
    public Integer getTotalRegisteredCount() {
        return totalRegisteredCount;
    }

    @JsonProperty("track_information")
    public TrackInformation getTrackInformation() {
        return trackInformation;
    }

    @JsonProperty("twitter_hash_tag")
    public String getTwitterHashTag() {
        return twitterHashTag;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("updated_date")
    public String getUpdatedDate() {
        return updatedDate;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    public void setAddress(EventAddress address) {
        this.address = address;
    }

    public void setAreRegistrantsPublic(boolean areRegistrantsPublic) {
        this.areRegistrantsPublic = areRegistrantsPublic;
    }

    public void setCancelledDate(String cancelledDate) {
        this.cancelledDate = cancelledDate;
    }

    public void setContact(EventHostContact contact) {
        this.contact = contact;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setGoogleAnalyticsKey(String googleAnalyticsKey) {
        this.googleAnalyticsKey = googleAnalyticsKey;
    }

    public void setGoogleMechantId(String googleMechantId) {
        this.googleMechantId = googleMechantId;
    }

    public void setCalendarDisplayed(boolean isCalendarDisplayed) {
        this.isCalendarDisplayed = isCalendarDisplayed;
    }

    public void setCheckingAvailable(boolean isCheckingAvailable) {
        this.isCheckingAvailable = isCheckingAvailable;
    }

    public void setHomePageDisplayed(boolean isHomePageDisplayed) {
        this.isHomePageDisplayed = isHomePageDisplayed;
    }

    public void setListedInExternalDirectory(boolean isListedInExternalDirectory) {
        this.isListedInExternalDirectory = isListedInExternalDirectory;
    }

    public void setMapDisplayed(boolean isMapDisplayed) {
        this.isMapDisplayed = isMapDisplayed;
    }

    public void setVirtualEvent(boolean isVirtualEvent) {
        this.isVirtualEvent = isVirtualEvent;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMetadataTags(String metadataTags) {
        this.metadataTags = metadataTags;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotificationOptions(List<NotificationOptions> notificationOptions) {
        this.notificationOptions = notificationOptions;
    }

    public void setOnlineMeeting(OnlineMeeting onlineMeeting) {
        this.onlineMeeting = onlineMeeting;
    }

    public void setPayableTo(String payableTo) {
        this.payableTo = payableTo;
    }

    public void setPaymentAddress(PaymentAddress paymentAddress) {
        this.paymentAddress = paymentAddress;
    }

    public void setPaymentOptions(List<String> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public void setPaypalAccountEmail(String paypalAccountEmail) {
        this.paypalAccountEmail = paypalAccountEmail;
    }

    public void setRegistrationUrl(String registrationUrl) {
        this.registrationUrl = registrationUrl;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public void setTimeZoneDescription(String timeZoneDescription) {
        this.timeZoneDescription = timeZoneDescription;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTotalRegisteredCount(Integer totalRegisteredCount) {
        this.totalRegisteredCount = totalRegisteredCount;
    }

    public void setTrackInformation(TrackInformation trackInformation) {
        this.trackInformation = trackInformation;
    }

    public void setTwitterHashTag(String twitterHashTag) {
        this.twitterHashTag = twitterHashTag;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }


    @Override
    public String toString() {
        //Todo fill all attributes
        StringBuilder builder = new StringBuilder();
        builder.append("Event [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", ");
        builder.append(contact);
        builder.append(", title=");
        builder.append(title);
        builder.append(", status=");
        builder.append(status);
        builder.append(", location=");
        builder.append(location);
        builder.append("]\n");

        return builder.toString();

    }

    /**
     * Default constructor.
     */
    public Event() {
        super();
    }

    //Todo declare all members
    public static final class PaymentType {
        public static final String ONLINE_CREDIT_CARD_PROCESSOR = "ONLINE_CREDIT_CARD_PROCESSOR";
        public static final String PAYPAL = "PAYPAL";
        public static final String GOOGLE_CHECKOUT = "GOOGLE_CHECKOUT";
        public static final String CHECK = "CHECK";
        public static final String DOOR = "DOOR";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private PaymentType() {
        }
    }

    public static final class Status {
        public static final String DRAFT = "DRAFT";
        public static final String ACTIVE = "ACTIVE";
        public static final String COMPLETE = "COMPLETE";
        public static final String CANCELLED = "CANCELLED";
        public static final String DELETED = "DELETED";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private Status() {
        }
    }

    public static final class CurrencyType {

        public static final String USD = "USD";
        public static final String CAD = "CAD";
        public static final String AUD = "AUD";
        public static final String CHF = "CHF";
        public static final String CZK = "CZK";
        public static final String DKK = "DKK";
        public static final String EUR = "EUR";
        public static final String GBP = "GBP";
        public static final String HKD = "HKD";
        public static final String HUF = "ILS";
        public static final String JPY = "JPY";
        public static final String MXN = "MXN";
        public static final String NOK = "NOK";
        public static final String NZD = "NZD";
        public static final String PHP = "PHP";
        public static final String PLN = "PLN";
        public static final String SEK = "SEK";
        public static final String SGD = "SGD";
        public static final String THB = "THB";
        public static final String TWD = "TWD";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private CurrencyType() {
        }
    }

    public static final class Type {

        public static final String AUCTION = "AUCTION";
        public static final String BIRTHDAY = "BIRTHDAY";
        public static final String BUSINESS_FINANCE_SALES = "BUSINESS_FINANCE_SALES";
        public static final String CLASSES_WORKSHOPS = "CLASSES_WORKSHOPS";
        public static final String COMPETITION_SPORTS = "COMPETITION_SPORTS";
        public static final String CONFERENCES_SEMINARS_FORUM = "CONFERENCES_SEMINARS_FORUM";
        public static final String CONVENTIONS_TRADESHOWS_EXPOS = "CONVENTIONS_TRADESHOWS_EXPOS";
        public static final String FESTIVALS_FAIRS = "FESTIVALS_FAIRS";
        public static final String FOOD_WINE = "FOOD_WINE";
        public static final String FUNDRAISERS_CHARITIES = "FUNDRAISERS_CHARITIES";
        public static final String HOLIDAY = "HOLIDAY";
        public static final String INCENTIVE_REWARD_RECOGNITION = "INCENTIVE_REWARD_RECOGNITION";
        public static final String MOVIES_FILM = "MOVIES_FILM";
        public static final String MUSIC_CONCERTS = "MUSIC_CONCERTS";
        public static final String NETWORKING_CLUBS = "NETWORKING_CLUBS";
        public static final String PERFORMING_ARTS = "PERFORMING_ARTS";
        public static final String OUTDOORS_RECREATION = "OUTDOORS_RECREATION";
        public static final String RELIGION_SPIRITUALITY = "RELIGION_SPIRITUALITY";
        public static final String SCHOOLS_REUNIONS_ALUMNI = "SCHOOLS_REUNIONS_ALUMNI";
        public static final String PARTIES_SOCIAL_EVENTS_MIXERS = "PARTIES_SOCIAL_EVENTS_MIXERS";
        public static final String TRAVEL = "TRAVEL";
        public static final String WEBINAR_TELESEMINAR_TELECLASS = "WEBINAR_TELESEMINAR_TELECLASS";
        public static final String WEDDINGS = "WEDDINGS";
        public static final String OTHER = "OTHER";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private Type() {
        }
    }

}
