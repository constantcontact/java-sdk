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

    /**
     * Unique ID of the event
     */
    @JsonIgnore
    private String id;
    /**
     * Date event was published or announced, in ISO-8601 format
     */
    @JsonIgnore
    private String activeDate;
    /**
     * Address specifying the event location, used to determine
     * event location on map if is_map_displayed set to true.
     */
    @JsonIgnore
    private EventAddress address;
    /**
     * Set to true allows registrants to view others who have registered for the event, Default is false
     */
    @JsonIgnore
    private boolean areRegistrantsPublic;
    /**
     * Date the event was cancelled in ISO-8601 format
     */
    @JsonIgnore
    private String cancelledDate;
    /**
     * The event host's contact information
     */
    @JsonIgnore
    private EventHostContact contact;
    /**
     * Date the event was created in ISO-8601 format
     */
    @JsonIgnore
    private String createdDate;
    /**
     * Currency that the account will be paid in.
     * Although this is not a required field, it has a default value of USD.
     */
    @JsonIgnore
    private String currencyType;
    /**
     * Date the event was deleted in ISO-8601 format
     */
    @JsonIgnore
    private String deletedDate;
    /**
     * Provide a brief description of the event that will be visible
     * on the event registration form and landing page
     */
    @JsonIgnore
    private String description;
    /**
     * The event end date, in ISO-8601 format
     */
    @JsonIgnore
    private String endDate;
    /**
     * Enter the Google analytics key if being used to track the event registration homepage
     */
    @JsonIgnore
    private String googleAnalyticsKey;
    /**
     * Google merchant id to which payments are made.
     * Google Checkout is not supported for new events,
     * only valid on events created prior to October 2013.
     */
    @JsonIgnore
    private String googleMerchantId;
    /**
     * Set to true to display the event on the account's calendar; Default = true
     */
    @JsonIgnore
    private boolean isCalendarDisplayed;
    /**
     * Set to true to enable registrant check-in, and indicate that the registrant attended the event; Default is false
     */
    @JsonIgnore
    private boolean isCheckingAvailable;
    /**
     * Indicates if the event home/landing page is displayed for the event; set to true only if a
     * landing page has been created for the event; Default is false
     */
    @JsonIgnore
    private boolean isHomePageDisplayed;
    /**
     * Set to true to publish the event in external event directories
     * such as SocialVents and EventsInAmerica; Default is false
     */
    @JsonIgnore
    private boolean isListedInExternalDirectory;
    /**
     * For future usage, Default = true
     */
    @JsonIgnore
    private boolean isMapDisplayed;
    /**
     * Set to true if this is an online event; Default is false
     */
    @JsonIgnore
    private boolean isVirtualEvent;
    /**
     * Name of the venue or Location at which the event is being held
     */
    @JsonIgnore
    private String location;
    /**
     * Specify keywords to improve search engine optimization (SEO) for the event; use commas to separate multiple keywords
     */
    @JsonIgnore
    private String metadataTags;
    /**
     * The event filename - not visible to registrants
     */
    @JsonIgnore
    private String name;
    /**
     * Define whether or not event notifications are sent to the contact email_address, and which notifications.
     */
    @JsonIgnore
    private List<NotificationOptions> notificationOptions;
    /**
     * Online meeting details, REQUIRED if is_virtual_event is set to true
     */
    @JsonIgnore
    private OnlineMeeting onlineMeeting;
    /**
     * Name to which registrants paying by check must make checks payable to; REQUIRED if 'CHECK' is selected as a payment option
     */
    @JsonIgnore
    private String payableTo;
    /**
     * Address to which checks will be sent. REQUIRED if CHECK is selected as a payment option
     */
    @JsonIgnore
    private PaymentAddress paymentAddress;
    /**
     * Specifies the payment options available to registrants
     */
    @JsonIgnore
    private List<String> paymentOptions;
    /**
     * Email address linked to PayPal account to which payments will be made.
     * REQUIRED if 'PAYPAL' is selected as a payment option
     */
    @JsonIgnore
    private String paypalAccountEmail;
    /**
     * The URL for the event home page if one exists, otherwise it points to the event registration page
     */
    @JsonIgnore
    private String registrationUrl;
    /**
     * The event start date, in ISO-8601 format
     */
    @JsonIgnore
    private String startDate;
    /**
     * The event status.
     */
    @JsonIgnore
    private String status;
    /**
     * The background and color theme for the event invitation, home page, and Registration form; default is Default
     */
    @JsonIgnore
    private String themeName;

//    /**
//     * Specify additional text to help describe the event time zone
//     */
//    @JsonIgnore
//    private String timeZoneDescription;
    /**
     * Time zone in which the event occurs, to see time_zone_id values go here.
     */
    @JsonIgnore
    private String timeZoneId;
    /**
     * The event title, visible to registrants
     */
    @JsonIgnore
    private String title;
    /**
     * Number of event registrants
     */
    @JsonIgnore
    private Integer totalRegisteredCount;
    /**
     * Use these settings to define the information displayed on the Event registration page
     */
    @JsonIgnore
    private TrackInformation trackInformation;
    /**
     * The event's Twitter hashtag
     */
    @JsonIgnore
    private String twitterHashTag;
    /**
     * The event type.
     */
    @JsonIgnore
    private String type;
    /**
     * Date the event was updated in ISO-8601 format
     */
    @JsonIgnore
    private String updatedDate;

    /**
     * Get the id.
     *
     * @return The {@link #id}
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Get the active date.
     *
     * @return The {@link #activeDate}
     */
    @JsonProperty("active_date")
    public String getActiveDate() {
        return activeDate;
    }

    /**
     * Get the address.
     *
     * @return The {@link #address}
     */
    @JsonProperty("address")
    public EventAddress getAddress() {
        return isVirtualEvent() ? null : address;
    }

    /**
     * Get the areRegistrantsPublic flag.
     *
     * @return The {@link #areRegistrantsPublic}
     */
    @JsonProperty("are_registrants_public")
    public boolean isAreRegistrantsPublic() {
        return areRegistrantsPublic;
    }

    /**
     * Get the cancelled date.
     *
     * @return The {@link #cancelledDate}
     */
    @JsonProperty("cancelled_date")
    public String getCancelledDate() {
        return cancelledDate;
    }

    /**
     * Get the contact.
     *
     * @return The {@link #contact}
     */
    @JsonProperty("contact")
    public EventHostContact getContact() {
        return contact;
    }

    /**
     * Get the created date.
     *
     * @return The {@link #createdDate}
     */
    @JsonProperty("created_date")
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Get the currency type.
     *
     * @return The {@link #currencyType}
     */
    @JsonProperty("currency_type")
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * Get the deleted date.
     *
     * @return The {@link #deletedDate}
     */
    @JsonProperty("deleted_date")
    public String getDeletedDate() {
        return deletedDate;
    }

    /**
     * Get the description.
     *
     * @return The {@link #description}
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Get the end date.
     *
     * @return The {@link #endDate}
     */
    @JsonProperty("end_date")
    public String getEndDate() {
        return endDate;
    }

    /**
     * Get the Google Analytics Key.
     *
     * @return The {@link #googleAnalyticsKey}
     */
    @JsonProperty("google_analytics_key")
    public String getGoogleAnalyticsKey() {
        return googleAnalyticsKey;
    }

    /**
     * Get the Google Merchant Id.
     *
     * @return The {@link #googleMerchantId}
     */
    @JsonProperty("google_merchant_id")
    public String getGoogleMerchantId() {
        return googleMerchantId;
    }

    /**
     * Get the isCalendarDisplayed flag.
     *
     * @return The {@link #isCalendarDisplayed}
     */
    @JsonProperty("is_calendar_displayed")
    public boolean isCalendarDisplayed() {
        return isCalendarDisplayed;
    }

    /**
     * Get the isCheckingAvailable flag.
     *
     * @return The {@link #isCheckingAvailable}
     */
    @JsonProperty("is_checkin_available")
    public boolean isCheckingAvailable() {
        return isCheckingAvailable;
    }

    /**
     * Get the isHomePageDisplayed flag.
     *
     * @return The {@link #isHomePageDisplayed}
     */

    @JsonProperty("is_home_page_displayed")
    public boolean isHomePageDisplayed() {
        return isHomePageDisplayed;
    }

    /**
     * Get the isListedInExternalDirectory flag.
     *
     * @return The {@link #isListedInExternalDirectory}
     */
    @JsonProperty("is_listed_in_external_directory")
    public boolean isListedInExternalDirectory() {
        return isListedInExternalDirectory;
    }

    /**
     * Get the isMapDisplayed flag.
     *
     * @return The {@link #isMapDisplayed}
     */
    @JsonProperty("is_map_displayed")
    public boolean isMapDisplayed() {
        return isMapDisplayed;
    }

    /**
     * Get the isVirtualEvent flag.
     *
     * @return The {@link #isVirtualEvent}
     */
    @JsonProperty("is_virtual_event")
    public boolean isVirtualEvent() {
        return isVirtualEvent;
    }

    /**
     * Get the location.
     *
     * @return The {@link #location}
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * Get the metadata tags.
     *
     * @return The {@link #metadataTags}
     */
    @JsonProperty("meta_data_tags")
    public String getMetadataTags() {
        return metadataTags;
    }

    /**
     * Get the name.
     *
     * @return The {@link #name}
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Get the notification options.
     *
     * @return The {@link #notificationOptions}
     */
    @JsonProperty("notification_options")
    public List<NotificationOptions> getNotificationOptions() {
        return notificationOptions;
    }

    /**
     * Get the online meeting.
     *
     * @return The {@link #onlineMeeting}
     */
    @JsonProperty("online_meeting")
    public OnlineMeeting getOnlineMeeting() {
        return onlineMeeting;
    }

    /**
     * Get the payableTo.
     *
     * @return The {@link #payableTo}
     */
    @JsonProperty("payable_to")
    public String getPayableTo() {
        return payableTo;
    }

    /**
     * Get the payment address.
     *
     * @return The {@link #paymentAddress}
     */
    @JsonProperty("payment_address")
    public PaymentAddress getPaymentAddress() {
        return paymentAddress;
    }

    /**
     * Get the payment options.
     *
     * @return The {@link #paymentOptions}
     */
    @JsonProperty("payment_options")
    public List<String> getPaymentOptions() {
        return paymentOptions;
    }

    /**
     * Get the Paypal account email.
     *
     * @return The {@link #paypalAccountEmail}
     */
    @JsonProperty("paypal_account_email")
    public String getPaypalAccountEmail() {
        return paypalAccountEmail;
    }

    /**
     * Get the registration url.
     *
     * @return The {@link #registrationUrl}
     */
    @JsonProperty("registration_url")
    public String getRegistrationUrl() {
        return registrationUrl;
    }

    /**
     * Get the start date.
     *
     * @return The {@link #startDate}
     */
    @JsonProperty("start_date")
    public String getStartDate() {
        return startDate;
    }

    /**
     * Get the status.
     *
     * @return The {@link #status}
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * Get the theme name.
     *
     * @return The {@link #themeName}
     */
    @JsonProperty("theme_name")
    public String getThemeName() {
        return themeName;
    }

    /**
     * Get the time zone ID.
     *
     * @return The {@link #timeZoneId}
     */
    @JsonProperty("time_zone_id")
    public String getTimeZoneId() {
        return timeZoneId;
    }

    /**
     * Get the title.
     *
     * @return The {@link #title}
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * Get the total registered count.
     *
     * @return The {@link #totalRegisteredCount}
     */
    @JsonProperty("total_registered_count")
    public Integer getTotalRegisteredCount() {
        return totalRegisteredCount;
    }

    /**
     * Get the track information.
     *
     * @return The {@link #trackInformation}
     */
    @JsonProperty("track_information")
    public TrackInformation getTrackInformation() {
        return trackInformation;
    }

    /**
     * Get the Twitter HashTag.
     *
     * @return The {@link #twitterHashTag}
     */
    @JsonProperty("twitter_hash_tag")
    public String getTwitterHashTag() {
        return twitterHashTag;
    }

    /**
     * Get the type.
     *
     * @return The {@link #type}
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Get the updated date.
     *
     * @return The {@link #updatedDate}
     */
    @JsonProperty("updated_date")
    public String getUpdatedDate() {
        return updatedDate;
    }

    /**
     * Set the id.
     *
     * @param id The id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set the activeDate.
     *
     * @param activeDate The activeDate.
     */
    public void setActiveDate(String activeDate) {
        this.activeDate = activeDate;
    }

    /**
     * Set the address.
     *
     * @param address The address.
     */
    public void setAddress(EventAddress address) {
        this.address = address;
    }

    /**
     * Set the areRegistrantsPublic flag.
     *
     * @param areRegistrantsPublic The areRegistrantsPublic.
     */
    public void setAreRegistrantsPublic(boolean areRegistrantsPublic) {
        this.areRegistrantsPublic = areRegistrantsPublic;
    }

    /**
     * Set the cancelledDate.
     *
     * @param cancelledDate The cancelledDate.
     */
    public void setCancelledDate(String cancelledDate) {
        this.cancelledDate = cancelledDate;
    }

    /**
     * Set the contact.
     *
     * @param contact The contact.
     */
    public void setContact(EventHostContact contact) {
        this.contact = contact;
    }

    /**
     * Set the createdDate.
     *
     * @param createdDate The createdDate.
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Set the currencyType.
     *
     * @param currencyType The currencyType.
     */
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    /**
     * Set the deletedDate.
     *
     * @param deletedDate The deletedDate.
     */
    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    /**
     * Set the description.
     *
     * @param description The description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set the endDate.
     *
     * @param endDate The endDate.
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * Set the googleAnalyticsKey.
     *
     * @param googleAnalyticsKey The googleAnalyticsKey.
     */
    public void setGoogleAnalyticsKey(String googleAnalyticsKey) {
        this.googleAnalyticsKey = googleAnalyticsKey;
    }

    /**
     * Set the googleMerchantId.
     *
     * @param googleMerchantId The googleMerchantId.
     */
    public void setGoogleMerchantId(String googleMerchantId) {
        this.googleMerchantId = googleMerchantId;
    }

    /**
     * Set the isCalendarDisplayed flag.
     *
     * @param isCalendarDisplayed The isCalendarDisplayed.
     */
    public void setCalendarDisplayed(boolean isCalendarDisplayed) {
        this.isCalendarDisplayed = isCalendarDisplayed;
    }

    /**
     * Set the isCheckingAvailable flag.
     *
     * @param isCheckingAvailable The isCheckingAvailable.
     */
    public void setCheckingAvailable(boolean isCheckingAvailable) {
        this.isCheckingAvailable = isCheckingAvailable;
    }

    /**
     * Set the isHomePageDisplayed flag.
     *
     * @param isHomePageDisplayed The isHomePageDisplayed.
     */
    public void setHomePageDisplayed(boolean isHomePageDisplayed) {
        this.isHomePageDisplayed = isHomePageDisplayed;
    }

    /**
     * Set the isListedInExternalDirectory flag.
     *
     * @param isListedInExternalDirectory The isListedInExternalDirectory.
     */
    public void setListedInExternalDirectory(boolean isListedInExternalDirectory) {
        this.isListedInExternalDirectory = isListedInExternalDirectory;
    }

    /**
     * Set the isMapDisplayed flag.
     *
     * @param isMapDisplayed The isMapDisplayed.
     */
    public void setMapDisplayed(boolean isMapDisplayed) {
        this.isMapDisplayed = isMapDisplayed;
    }

    /**
     * Set the isVirtualEvent flag.
     *
     * @param isVirtualEvent The isVirtualEvent.
     */
    public void setVirtualEvent(boolean isVirtualEvent) {
        this.isVirtualEvent = isVirtualEvent;
    }

    /**
     * Set the location.
     *
     * @param location The location.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Set the metadataTags.
     *
     * @param metadataTags The metadataTags.
     */
    public void setMetadataTags(String metadataTags) {
        this.metadataTags = metadataTags;
    }

    /**
     * Set the name.
     *
     * @param name The name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the notificationOptions.
     *
     * @param notificationOptions The notificationOptions.
     */
    public void setNotificationOptions(List<NotificationOptions> notificationOptions) {
        this.notificationOptions = notificationOptions;
    }

    /**
     * Set the onlineMeeting.
     *
     * @param onlineMeeting The onlineMeeting.
     */
    public void setOnlineMeeting(OnlineMeeting onlineMeeting) {
        this.onlineMeeting = onlineMeeting;
    }

    /**
     * Set the payableTo.
     *
     * @param payableTo The payableTo.
     */
    public void setPayableTo(String payableTo) {
        this.payableTo = payableTo;
    }

    /**
     * Set the paymentAddress.
     *
     * @param paymentAddress The paymentAddress.
     */
    public void setPaymentAddress(PaymentAddress paymentAddress) {
        this.paymentAddress = paymentAddress;
    }

    /**
     * Set the paymentOptions.
     *
     * @param paymentOptions The paymentOptions.
     */
    public void setPaymentOptions(List<String> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    /**
     * Set the paypalAccountEmail.
     *
     * @param paypalAccountEmail The paypalAccountEmail.
     */
    public void setPaypalAccountEmail(String paypalAccountEmail) {
        this.paypalAccountEmail = paypalAccountEmail;
    }

    /**
     * Set the registrationUrl.
     *
     * @param registrationUrl The registrationUrl.
     */
    public void setRegistrationUrl(String registrationUrl) {
        this.registrationUrl = registrationUrl;
    }

    /**
     * Set the startDate.
     *
     * @param startDate The startDate.
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Set the status.
     *
     * @param status The status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Set the themeName.
     *
     * @param themeName The themeName.
     */
    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    /**
     * Set the timeZoneId.
     *
     * @param timeZoneId The timeZoneId.
     */
    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    /**
     * Set the title.
     *
     * @param title The title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set the totalRegisteredCount.
     *
     * @param totalRegisteredCount The totalRegisteredCount.
     */
    public void setTotalRegisteredCount(Integer totalRegisteredCount) {
        this.totalRegisteredCount = totalRegisteredCount;
    }

    /**
     * Set the trackInformation.
     *
     * @param trackInformation The trackInformation.
     */
    public void setTrackInformation(TrackInformation trackInformation) {
        this.trackInformation = trackInformation;
    }

    /**
     * Set the twitterHashTag.
     *
     * @param twitterHashTag The twitterHashTag.
     */
    public void setTwitterHashTag(String twitterHashTag) {
        this.twitterHashTag = twitterHashTag;
    }

    /**
     * Set the type.
     *
     * @param type The type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Set the updatedDate.
     *
     * @param updatedDate The updatedDate.
     */
    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Event [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", title=");
        builder.append(title);
        builder.append(", description=");
        builder.append(description);
        builder.append(", status=");
        builder.append(status);
        builder.append(", location=");
        builder.append(location);
        builder.append(", type=");
        builder.append(type);
        builder.append(", contact=");
        builder.append(contact);
        builder.append(", location=");
        builder.append(location);
        builder.append(", start_date=");
        builder.append(startDate);
        builder.append(", end_date=");
        builder.append(endDate);
        builder.append(", created_date=");
        builder.append(createdDate);
        builder.append(", time_zone_id=");
        builder.append(timeZoneId);
        builder.append(", active_date=");
        builder.append(activeDate);
        builder.append(", is_checkin_available=");
        builder.append(isCheckingAvailable);
        builder.append(", registration_url=");
        builder.append(registrationUrl);
        builder.append(", meta_data_tags=");
        builder.append(metadataTags);
        builder.append(", theme_name=");
        builder.append(themeName);
        builder.append(", payment_address=");
        builder.append(paymentAddress);
        builder.append(", payable_to=");
        builder.append(payableTo);
        builder.append(", payment_options=");
        builder.append(paymentOptions);
        builder.append(", currency_type=");
        builder.append(currencyType);
        builder.append(", online_meeting=");
        builder.append(onlineMeeting);
        builder.append(", is_virtual_event=");
        builder.append(isVirtualEvent);
        builder.append(", twitter_hash_tag=");
        builder.append(twitterHashTag);
        builder.append(", notification_options=");
        builder.append(notificationOptions);
        builder.append(", is_home_page_displayed=");
        builder.append(isHomePageDisplayed);
        builder.append(", is_map_displayed=");
        builder.append(isMapDisplayed);
        builder.append(", is_calendar_displayed=");
        builder.append(isCalendarDisplayed);
        builder.append(", is_listed_in_external_directory=");
        builder.append(isListedInExternalDirectory);
        builder.append(", are_registrants_public=");
        builder.append(areRegistrantsPublic);
        builder.append(", track_information=");
        builder.append(trackInformation);
//        builder.append(", time_zone_description=");
//        builder.append(timeZoneDescription);

        builder.append("]\n");
        return builder.toString();

    }

    /**
     * Default constructor.
     */
    public Event() {
        super();
    }

    /**
     * Payment type constants for the usage of {@link Event} in Constant Contact
     *
     * @author ConstantContact
     */
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

    /**
     * Status constants for the usage of {@link Event} in Constant Contact
     *
     * @author ConstantContact
     */
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

    /**
     * Curency type constants for the usage of {@link Event} in Constant Contact
     *
     * @author ConstantContact
     */
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

    /**
     * Type constants for the usage of {@link Event} in Constant Contact
     *
     * @author ConstantContact
     */
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
