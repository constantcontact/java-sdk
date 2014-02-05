package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class RegistrantDetails extends Component implements Serializable {


    private static final long serialVersionUID = -3149418638388915227L;

    @JsonIgnore
    private String id;
    @JsonIgnore
    private String ticketId;
    @JsonIgnore
    private String registrationDate;
    @JsonIgnore
    private String attendanceStatus;

    @JsonIgnore
    private List<RegistrantSection> sections;

    @JsonIgnore
    private List<PromoCodeInfo> promoCodeInfos;

    @JsonIgnore
    private PaymentSummary paymentSummary;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("ticket_id")
    public String getTicketId() {
        return ticketId;
    }

    @JsonProperty("sections")
    public List<RegistrantSection> getSections() {
        return sections;
    }

    @JsonProperty("promo_code_info")
    public List<PromoCodeInfo> getPromoCodeInfos() {
        return promoCodeInfos;
    }

    @JsonProperty("payment_summary")
    public PaymentSummary getPaymentSummary() {
        return paymentSummary;
    }

    @JsonProperty("registration_date")
    public String getRegistrationDate() {
        return registrationDate;
    }

    @JsonProperty("attendance_status")
    public String getAttendanceStatus() {
        return attendanceStatus;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public void setSections(List<RegistrantSection> sections) {
        this.sections = sections;
    }

    public void setPromoCodeInfos(List<PromoCodeInfo> promoCodeInfos) {
        this.promoCodeInfos = promoCodeInfos;
    }

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
        builder.append(promoCodeInfos);
        builder.append(", order=");
        builder.append(", payment_summary=");
        builder.append(paymentSummary);
        builder.append("]");

        return builder.toString();
    }
}
