package com.constantcontact.v2.library;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author woogienoogie
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Folder implements Serializable {
    @JsonProperty("id")
    protected String _id;

    @JsonProperty("name")
    protected String _name;

    @JsonProperty("level")
    protected int _level;

    @JsonProperty("children")
    protected Folder[] _children;

    @JsonProperty("item_count")
    protected int _itemCount;

    @JsonProperty("parent_id")
    protected String _parentId;

    @JsonProperty("modified_date")
    protected String _modifiedDate;

    @JsonProperty("created_date")
    protected String _createdDate;

    public Folder() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public int getLevel() {
        return _level;
    }

    public void setLevel(int level) {
        _level = level;
    }

    public Folder[] getChildren() {
        return _children;
    }

    public void setChildren(Folder[] children) {
        _children = children;
    }

    public int getItemCount() {
        return _itemCount;
    }

    public void setItemCount(int itemCount) {
        _itemCount = itemCount;
    }

    public String getParentId() {
        return _parentId;
    }

    public void setParentId(String parentId) {
        _parentId = parentId;
    }

    public String getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getCreatedDate() {
        return _createdDate;
    }

    public void setCreatedDate(String createdDate) {
        _createdDate = createdDate;
    }
}
