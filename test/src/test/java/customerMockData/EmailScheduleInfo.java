package customerMockData;

import com.constantcontact.components.emailcampaigns.schedules.EmailCampaignSchedule;

import java.util.Date;

/**
 * Data used to test the email campaign schedule functionality.<br/>
 *
 * @author ConstantContact
 */
public class EmailScheduleInfo {

    private EmailCampaignSchedule emailTestSchedule;

    /**
     * Custom constructor that sets the fields of the EmailCampaignSchedule object
     * used to test the email campaign schedule related functionality
     *
     */
    public EmailScheduleInfo() {
        EmailCampaignSchedule emailCampaignSchedule = new EmailCampaignSchedule();
        Date date = new Date();
        date.setTime(date.getTime()+1 * 24 * 60 * 60 * 1000);
        emailCampaignSchedule.setScheduledDate(date.toString());

        this.emailTestSchedule = emailCampaignSchedule;
    }

    /**
     * Gets the email campaign schedule
     * @return The EmailCampaignSchedule object
     */
    public EmailCampaignSchedule getEmailCampaignSchedule() {
        return emailTestSchedule;
    }

    /**
     * Sets the email campaign schedule
     * @param emailCampaignSchedule The EmailCampaignSchedule object to be set
     */
    public void setEmailCampaignSchedule(EmailCampaignSchedule emailCampaignSchedule) {
        this.emailTestSchedule = emailCampaignSchedule;
    }
}
