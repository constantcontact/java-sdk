package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class Registrant extends Component implements Serializable {


    private static final long serialVersionUID = 5229419988108762830L;

    @JsonIgnore
    private String id;
    @JsonIgnore
    private String ticketId;
    @JsonIgnore
    private Integer guestCount;
    @JsonIgnore
    private String firstName;
    @JsonIgnore
    private String lastName;
    @JsonIgnore
    private String updatedDate;
    @JsonIgnore
    private String registrationStatus;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String registrationDate;
    @JsonIgnore
    private String attendanceStatus;
    @JsonIgnore
    private String paymentStatus;

    @JsonProperty("guest_count")
    public Integer getGuestCount() {
        return guestCount;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("updated_date")
    public String getUpdatedDate() {
        return updatedDate;
    }

    @JsonProperty("registration_status")
    public String getRegistrationStatus() {
        return registrationStatus;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("registration_date")
    public String getRegistrationDate() {
        return registrationDate;
    }

    @JsonProperty("attendance_status")
    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    @JsonProperty("payment_status")
    public String getPaymentStatus() {
        return paymentStatus;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setGuestCount(Integer guestCount) {
        this.guestCount = guestCount;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

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

    public static final class PaymentStatus {
        public static final String ATTENDED = "ATTENDED";
        public static final String NOT_ATTENDED = "NOT_ATTENDED";
    }


}
