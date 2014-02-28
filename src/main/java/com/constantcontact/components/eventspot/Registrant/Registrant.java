package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Registrant for the Events in Constant Contact.
 *
 * @author ConstantContact
 * @see EventSpotService
 */
public class Registrant extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = 5229419988108762830L;


    /**
     * Unique ID for the registrant
     */
    @JsonIgnore
    private String id;

    /**
     * Unique ID of the registrant's event ticket
     */
    @JsonIgnore
    private String ticketId;


    /**
     * Number of guests the registrant is bringing to the event
     */
    @JsonIgnore
    private Integer guestCount;

    /**
     * The Registrant's first (given) name
     */
    @JsonIgnore
    private String firstName;

    /**
     * The Registrant's last (family) name
     */
    @JsonIgnore
    private String lastName;

    /**
     * Most recent date registrant was updated
     */
    @JsonIgnore
    private String updatedDate;

    /**
     * The Registrant's registration status
     */
    @JsonIgnore
    private String registrationStatus;

    /**
     * The Registrant's email address
     */
    @JsonIgnore
    private String email;

    /**
     * Date the registrant registered for the event
     */
    @JsonIgnore
    private String registrationDate;

    /**
     * The Registrant's attendance status, ATTENDED or NOT_ATTENDED
     */
    @JsonIgnore
    private String attendanceStatus;

    /**
     * The Registrant's payment status
     */
    @JsonIgnore
    private String paymentStatus;

    /**
     * Get the registrant id.
     *
     * @return The {@link #id}
     */
    public String getId() {
        return id;
    }

    /**
     * Get the ticket ID.
     *
     * @return The {@link #ticketId}
     */
    public String getTicketId() {
        return ticketId;
    }

    /**
     * Get the guest count.
     *
     * @return The {@link #guestCount}
     */
    @JsonProperty("guest_count")
    public Integer getGuestCount() {
        return guestCount;
    }

    /**
     * Get the first name.
     *
     * @return The {@link #firstName}
     */

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the last name.
     *
     * @return The {@link #lastName}
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
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
     * Get the registration status.
     *
     * @return The {@link #registrationStatus}
     */
    @JsonProperty("registration_status")
    public String getRegistrationStatus() {
        return registrationStatus;
    }

    /**
     * Get the email.
     *
     * @return The {@link #email}
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * Get the registration date.
     *
     * @return The {@link #registrationDate}
     */
    @JsonProperty("registration_date")
    public String getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Get the attendance status.
     *
     * @return The {@link #attendanceStatus}
     */
    @JsonProperty("attendance_status")
    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    /**
     * Get the payment status.
     *
     * @return The {@link #paymentStatus}
     */
    @JsonProperty("payment_status")
    public String getPaymentStatus() {
        return paymentStatus;
    }


    /**
     * Set the registrant ID.
     *
     * @param id The ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set the ticket ID.
     *
     * @param ticketId The ticket ID.
     */
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * Set the Field guest count.
     *
     * @param guestCount The guest count.
     */
    public void setGuestCount(Integer guestCount) {
        this.guestCount = guestCount;
    }

    /**
     * Set the Field first name.
     *
     * @param firstName The first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set the Field last name.
     *
     * @param lastName The last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set the updated date.
     *
     * @param updatedDate The updated date.
     */
    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * Set the registration status.
     *
     * @param registrationStatus The registration status.
     */
    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    /**
     * Set the email.
     *
     * @param email The email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set the registration date.
     *
     * @param registrationDate The registration date.
     */
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Set the attendance status.
     *
     * @param attendanceStatus The attendance status.
     */
    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    /**
     * Set the payment status.
     *
     * @param paymentStatus The payment status.
     */
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" [id=");
        builder.append(id);
        builder.append(", ticket_id=");
        builder.append(ticketId);
        builder.append(", guest_count=");
        builder.append(guestCount);
        builder.append(", first_name=");
        builder.append(firstName);
        builder.append(", last_name=");
        builder.append(lastName);
        builder.append(", updated_date=");
        builder.append(updatedDate);
        builder.append(", registration_status=");
        builder.append(registrationStatus);
        builder.append(", email=");
        builder.append(email);
        builder.append(", registration_date=");
        builder.append(registrationDate);
        builder.append(", attendance_status=");
        builder.append(attendanceStatus);
        builder.append(", payment_status=");
        builder.append(paymentStatus);
        builder.append("]");

        return builder.toString();
    }

    /**
     * Payment status constants for the usage of {@link PromoCodeInfo} in Constant Contact
     *
     * @author ConstantContact
     */
    public static final class PaymentStatus {
        /**
         * ATTENDED status
         */
        public static final String ATTENDED = "ATTENDED";

        /**
         * NOT_ATTENDED status
         */
        public static final String NOT_ATTENDED = "NOT_ATTENDED";

        /**
         * Default constructor.<br/>
         * Made private to prevent instantiation.<br/>
         * This is unreachable from the outside, since current class is used only as a repository for constants.
         */
        private PaymentStatus() {
        }
    }


}
