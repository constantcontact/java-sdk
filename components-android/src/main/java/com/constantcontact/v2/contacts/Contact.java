package com.constantcontact.v2.contacts;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author woogienoogie
 */
@JsonFilter("RequestFilter")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Contact implements Parcelable {
    @JsonProperty("addresses")
    protected Address[] _addresses;

    @JsonProperty("cell_phone")
    protected String _cellPhone;

    @JsonProperty("company_name")
    protected String _companyName;

    @JsonProperty("confirmed")
    protected boolean _confirmed;

    @JsonProperty("created_date")
    protected Date _createdDate;

    @JsonProperty("custom_fields")
    protected CustomField[] _customFields;

    @JsonProperty("department_name")
    protected String _departmentName;

    @JsonProperty("email_addresses")
    protected EmailAddress[] _emailAddresses;

    @JsonProperty("fax")
    protected String _fax;

    @JsonProperty("first_name")
    protected String _firstName;

    @JsonProperty("home_phone")
    protected String _homePhone;

    @JsonProperty("id")
    protected String _id;

    @JsonProperty("insert_date")
    protected Date _insertDate;

    @JsonProperty("job_title")
    protected String _jobTitle;

    @JsonProperty("last_name")
    protected String _lastName;

    @JsonProperty("last_update_date")
    protected Date _lastUpdateDate;

    @JsonProperty("lists")
    protected ContactListMetaData[] _contactLists;

    @JsonProperty("middle_name")
    protected String _middleName;

    @JsonProperty("modified_date")
    protected Date _modifiedDate;

    @JsonProperty("notes")
    protected Note[] _notes;

    @JsonProperty("prefix_name")
    protected String _prefixName;

    @JsonProperty("source")
    protected String _source;

    @JsonProperty("source_details")
    protected String _sourceDetails;

    @JsonProperty("status")
    protected ContactStatus _status;

    @JsonProperty("work_phone")
    protected String _workPhone;

    public Contact() {
    }

    public Address[] getAddresses() {
        return _addresses;
    }

    public void setAddresses(Address[] addresses) {
        _addresses = addresses;
    }

    public String getCellPhone() {
        return _cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        _cellPhone = cellPhone;
    }

    public String getCompanyName() {
        return _companyName;
    }

    public void setCompanyName(String companyName) {
        _companyName = companyName;
    }

    public boolean isConfirmed() {
        return _confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        _confirmed = confirmed;
    }

    public Date getCreatedDate() {
        return _createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;
    }

    public CustomField[] getCustomFields() {
        return _customFields;
    }

    public void setCustomFields(CustomField[] customFields) {
        _customFields = customFields;
    }

    public String getDepartmentName() {
        return _departmentName;
    }

    public void setDepartmentName(String departmentName) {
        _departmentName = departmentName;
    }

    public EmailAddress[] getEmailAddresses() {
        return _emailAddresses;
    }

    public void setEmailAddresses(EmailAddress[] emailAddresses) {
        _emailAddresses = emailAddresses;
    }

    public String getFax() {
        return _fax;
    }

    public void setFax(String fax) {
        _fax = fax;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getHomePhone() {
        return _homePhone;
    }

    public void setHomePhone(String homePhone) {
        _homePhone = homePhone;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    public Date getInsertDate() {
        return _insertDate;
    }

    public void setInsertDate(Date insertDate) {
        _insertDate = insertDate;
    }

    public String getJobTitle() {
        return _jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        _jobTitle = jobTitle;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public Date getLastUpdateDate() {
        return _lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        _lastUpdateDate = lastUpdateDate;
    }

    public ContactListMetaData[] getContactLists() {
        return _contactLists;
    }

    public void setContactLists(ContactListMetaData[] contactLists) {
        _contactLists = contactLists;
    }

    public String getMiddleName() {
        return _middleName;
    }

    public void setMiddleName(String middleName) {
        _middleName = middleName;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public Note[] getNotes() {
        return _notes;
    }

    public void setNotes(Note[] notes) {
        _notes = notes;
    }

    public String getPrefixName() {
        return _prefixName;
    }

    public void setPrefixName(String prefixName) {
        _prefixName = prefixName;
    }

    public String getSource() {
        return _source;
    }

    public void setSource(String source) {
        _source = source;
    }

    public String getSourceDetails() {
        return _sourceDetails;
    }

    public void setSourceDetails(String sourceDetails) {
        _sourceDetails = sourceDetails;
    }

    public ContactStatus getStatus() {
        return _status;
    }

    public void setStatus(ContactStatus status) {
        _status = status;
    }

    public String getWorkPhone() {
        return _workPhone;
    }

    public void setWorkPhone(String workPhone) {
        _workPhone = workPhone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedArray(_addresses, flags);
        dest.writeString(_cellPhone);
        dest.writeString(_companyName);
        dest.writeByte(_confirmed ? (byte) 1 : (byte) 0);
        dest.writeLong(_createdDate != null ? _createdDate.getTime() : - 1);
        dest.writeParcelableArray(_customFields, flags);
        dest.writeString(_departmentName);
        dest.writeParcelableArray(_emailAddresses, flags);
        dest.writeString(_fax);
        dest.writeString(_firstName);
        dest.writeString(_homePhone);
        dest.writeString(_id);
        dest.writeLong(_insertDate != null ? _insertDate.getTime() : - 1);
        dest.writeString(_jobTitle);
        dest.writeString(_lastName);
        dest.writeLong(_lastUpdateDate != null ? _lastUpdateDate.getTime() : - 1);
        dest.writeParcelableArray(_contactLists, flags);
        dest.writeString(_middleName);
        dest.writeLong(_modifiedDate != null ? _modifiedDate.getTime() : - 1);
        dest.writeParcelableArray(_notes, flags);
        dest.writeString(_prefixName);
        dest.writeString(_source);
        dest.writeString(_sourceDetails);
        dest.writeInt(_status == null ? - 1 : _status.ordinal());
        dest.writeString(_workPhone);
    }

    protected Contact(Parcel in) {
        _addresses = in.createTypedArray(Address.CREATOR);
        _cellPhone = in.readString();
        _companyName = in.readString();
        _confirmed = in.readByte() != 0;
        long tmp_createdDate = in.readLong();
        _createdDate = tmp_createdDate == - 1 ? null : new Date(tmp_createdDate);
        _customFields = in.createTypedArray(CustomField.CREATOR);
        _departmentName = in.readString();
        _emailAddresses = in.createTypedArray(EmailAddress.CREATOR);
        _fax = in.readString();
        _firstName = in.readString();
        _homePhone = in.readString();
        _id = in.readString();
        long tmp_insertDate = in.readLong();
        _insertDate = tmp_insertDate == - 1 ? null : new Date(tmp_insertDate);
        _jobTitle = in.readString();
        _lastName = in.readString();
        long tmp_lastUpdateDate = in.readLong();
        _lastUpdateDate = tmp_lastUpdateDate == - 1 ? null : new Date(tmp_lastUpdateDate);
        _contactLists = in.createTypedArray(ContactListMetaData.CREATOR);
        _middleName = in.readString();
        long tmp_modifiedDate = in.readLong();
        _modifiedDate = tmp_modifiedDate == - 1 ? null : new Date(tmp_modifiedDate);
        _notes = in.createTypedArray(Note.CREATOR);
        _prefixName = in.readString();
        _source = in.readString();
        _sourceDetails = in.readString();
        int tmp_status = in.readInt();
        _status = tmp_status == - 1 ? null : ContactStatus.values()[tmp_status];
        _workPhone = in.readString();
    }

    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel source) {
            return new Contact(source);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
