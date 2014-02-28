package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * RegistrantDetails for the Events in Constant Contact.
 *
 * @author ConstantContact
 * @see EventSpotService
 */
public class RegistrantDetails extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = -3149418638388915227L;

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
     * Field sections displayed
     */
    @JsonIgnore
    private List<RegistrantSection> sections;

    /**
     * A List of promo code info properties
     */
    @JsonIgnore
    private List<PromoCodeInfo> promoCodeInfoList;

    /**
     *The Registrant's payment summary
     */
    @JsonIgnore
    private PaymentSummary paymentSummary;

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
     * Get the sections.
     *
     * @return The {@link #sections}
     */
    @JsonProperty("sections")
    public List<RegistrantSection> getSections() {
        return sections;
    }

    /**
     * Get the promo code info list.
     *
     * @return The {@link #promoCodeInfoList}
     */
    @JsonProperty("promo_code_info")
    public List<PromoCodeInfo> getPromoCodeInfoList() {
        return promoCodeInfoList;
    }

    /**
     * Get the payment summary.
     *
     * @return The {@link #paymentSummary}
     */
    @JsonProperty("payment_summary")
    public PaymentSummary getPaymentSummary() {
        return paymentSummary;
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
     * Set the registrant ID.
     *
     * @param id The ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set the ticketId ID.
     *
     * @param ticketId The ID.
     */
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
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
     * Set the sections.
     *
     * @param sections The sections.
     */
    public void setSections(List<RegistrantSection> sections) {
        this.sections = sections;
    }

    /**
     * Set the promo code info list.
     *
     * @param promoCodeInfoList The the promo code info list.
     */
    public void setPromoCodeInfoList(List<PromoCodeInfo> promoCodeInfoList) {
        this.promoCodeInfoList = promoCodeInfoList;
    }

    /**
     * Set the payment summary.
     *
     * @param paymentSummary The payment summary.
     */
    public void setPaymentSummary(PaymentSummary paymentSummary) {
        this.paymentSummary = paymentSummary;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" [id=");
        builder.append(id);
        builder.append(", ticket_id=");
        builder.append(ticketId);
        builder.append(", registration_date=");
        builder.append(registrationDate);
        builder.append(", attendance_status=");
        builder.append(attendanceStatus);
        builder.append(", sections=");
        builder.append(sections);
        builder.append(", promo_code_info=");
        builder.append(promoCodeInfoList);
        builder.append(", order=");
        builder.append(", payment_summary=");
        builder.append(paymentSummary);
        builder.append("]");

        return builder.toString();
    }
}
