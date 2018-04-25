/*
 * Copyright (c) 2016 Constant Contact, Inc. All Rights Reserved.
 * Boston, MA 02451, USA
 * Phone: (781) 472-8100
 * Fax: (781) 472-8101
 * This software is the confidential and proprietary information
 * of Constant Contact, Inc. created for Constant Contact, Inc.
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Constant Contact, Inc.
 */

package com.constantcontact.v2.bulkactivities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
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
    @JsonProperty("status")
    protected Status _status;

    /// Type of activity, valid values are:
    ///
    /// * ADD_CONTACTS - add the contacts to contact list(s) specified in the import file
    /// * CLEAR_CONTACTS_FROM_LISTS - removes all contacts from the contactlist(s) specified in the import file
    /// * EXPORT_CONTACTS - export contacts to a supported file type
    /// * REMOVE_CONTACTS_FROM_LISTS - remove the contacts from the list(s), all specified in the import file
    @JsonProperty("type")
    protected Type _type;

    /**
     * Class Creator
     */
    public Activity() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
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

    public Status getStatus() {
        return _status;
    }

    public void setStatus(Status activityStatus) {
        _status = activityStatus;
    }

    public Type getType() {
        return _type;
    }

    public void setType(Type activityType) {
        _type = activityType;
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
                    .append(_id, rhs.getId())
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

    public enum Status {
        // the activity has been picked up from the queue and is running
        RUNNING,
        // the activity has completed without errors
        COMPLETE,
        // the activity was cancelled; activities can be cancelled using the product UI only
        CANCELLED,
        // errors occurred when the job was run
        ERROR,
        // initial state for an activity after it is created
        PENDING,
        // the activity has been retrieved and is in the queue to be run
        QUEUED,
        // the activity has not been created yet
        UNCONFIRMED
    }

    public enum Type {
        // add the contacts to contact list(s) specified in the import file
        ADD_CONTACTS,
        // export contacts to a supported file type
        EXPORT_CONTACTS,
        // removes all contacts from the contactlist(s) specified in the import file
        CLEAR_CONTACTS_FROM_LISTS,
        // remove the contacts from the list(s), all specified in the import file
        REMOVE_CONTACT_FROM_LISTS
    }
}
