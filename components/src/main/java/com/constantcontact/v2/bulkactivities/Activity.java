package com.constantcontact.v2.bulkactivities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Activity implements Serializable {

    /// Unique ID for the activity.
    @JsonProperty("id")
    protected String _id;

    /// Displays the number of contacts that were processed, and is meaningful only after the activity is completed (the value is not
    /// predictable until the activity is complete).
    @JsonProperty("contact_count")
    protected int _contactCount;

    /// Displays the number of errors encountered, and is meaningful only after the activity is completed (the value is not predictable
    /// until the activity is complete).
    @JsonProperty("error_count")
    protected int _errorCount;

    /// The URI pointing to the exported file. Make a GET call to the URI to retrieve the file.
    @JsonProperty("file_name")
    protected String _fileName;

    /// Time and date that created the activity after importing the file, in ISO 8601 format.
    @JsonProperty("created_date")
    protected Date _createdDate;

    /// Time and date that the API started processing the activity, in ISO 8601 format.
    @JsonProperty("start_date")
    protected Date _startDate;

    /// Time and date that activity was completed, in ISO-8601 format.
    @JsonProperty("finish_date")
    protected Date _finishDate;

    /// The status of the activity, valid values are:
    ///
    /// * UNCONFIRMED - the activity has not been created yet
    /// * PENDING - initial state for an activity after it is created
    /// * QUEUED - the activity has been retrieved and is in the queue to be run
    /// * RUNNING - the activity has been picked up from the queue and is running
    /// * COMPLETE - the activity has completed without errors
    /// * CANCELLED - the activity was cancelled; activities can be cancelled using the product UI only.
    /// * ERROR - errors occurred when the job was run
    @JsonProperty("activity_status")
    protected ActivityStatus _activityStatus;

    /// Type of activity, valid values are:
    ///
    /// * ADD_CONTACTS - add the contacts to contact list(s) specified in the import file
    /// * CLEAR_CONTACTS_FROM_LISTS - removes all contacts from the contactlist(s) specified in the import file
    /// * EXPORT_CONTACTS - export contacts to a supported file type
    /// * REMOVE_CONTACTS_FROM_LISTS - remove the contacts from the list(s), all specified in the import file
    @JsonProperty("activity_type")
    protected ActivityType _activityType;



    /**
     * Class Creator
     */
    public Activity() {
    }

    public String getID() {
        return _id;
    }

    public void setID(String id) {
        _id = id;
    }

    public int getContactCount() {
        return _contactCount;
    }

    public void setContactCount(int contactCount) {
        _contactCount = contactCount;
    }

    public int getErrorCount() {
        return _errorCount;
    }

    public void setErrorCount(int errorCount) {
        _errorCount = errorCount;
    }

    public String getFileName() {
        return _fileName;
    }

    public void setFileName(String fileName) {
        _fileName = fileName;
    }

    public Date getCreatedDate() {
        return _createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;
    }

    public Date getStartDate() {
        return _startDate;
    }

    public void setStartDate(Date startDate) {
        _startDate = startDate;
    }

    public Date getFinishDate() {
        return _finishDate;
    }

    public void setFinishDate(Date finishDate) {
        _finishDate = finishDate;
    }

    public ActivityStatus getActivityStatus() {
        return _activityStatus;
    }

    public void setActivityStatus(ActivityStatus activityStatus) {
        _activityStatus = activityStatus;
    }

    public ActivityType getActivityType() {
        return _activityType;
    }

    public void setActivityType(ActivityType activityType) {
        _activityType = activityType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Activity)) {
            return false;
        } else {
            Activity rhs = (Activity) obj;
            return new EqualsBuilder()
                    .append(_id, rhs.getID())
                    .append(_contactCount, rhs.getContactCount())
                    .append(_errorCount, rhs.getErrorCount())
                    .append(_fileName, rhs.getFileName())
                    .append(_createdDate, rhs.getCreatedDate())
                    .append(_startDate, rhs.getStartDate())
                    .append(_finishDate, rhs.getFinishDate())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_id)
                .append(_contactCount)
                .append(_errorCount)
                .append(_fileName)
                .append(_createdDate)
                .append(_startDate)
                .append(_finishDate)
                .hashCode();
    }

}
