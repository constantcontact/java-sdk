package com.constantcontact.v2.contacts;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Payload to give the server when requesting a signup form
 * @see <a href="http://developer.constantcontact.com/docs/signup-forms-tools/signup-form-creation.html">Signup Form Creation</a>
 *
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class SignupFormRequest {
    @JsonProperty("contact_lists")
    private String[] _contactLists;

    @JsonProperty("list_name")
    private String _listName;

    @JsonProperty("source")
    private String _source;

    public String[] getContactLists() {
        return _contactLists;
    }

    public void setContactLists(String[] contactLists) {
        _contactLists = contactLists;
    }

    public String getListName() {
        return _listName;
    }

    public void setListName(String listName) {
        _listName = listName;
    }

    public String getSource() {
        return _source;
    }

    public void setSource(String source) {
        _source = source;
    }
}
