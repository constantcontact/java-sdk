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

package com.constantcontact.v2.library;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
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
    protected Date _modifiedDate;

    @JsonProperty("created_date")
    protected Date _createdDate;

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

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public Date getCreatedDate() {
        return _createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Folder)) {
            return false;
        } else {
            Folder rhs = (Folder) obj;
            return new EqualsBuilder()
                    .append(_id, rhs.getId())
                    .append(_parentId, rhs.getParentId())
                    .append(_name, rhs.getName())
                    .append(_level, rhs.getLevel())
                    .append(_children, rhs.getChildren())
                    .append(_itemCount, rhs.getItemCount())
                    .append(_modifiedDate, rhs.getModifiedDate())
                    .append(_createdDate, rhs.getCreatedDate())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_id)
                .append(_parentId)
                .append(_name)
                .append(_level)
                .append(_children)
                .append(_itemCount)
                .append(_modifiedDate)
                .append(_createdDate)
                .hashCode();
    }
}
