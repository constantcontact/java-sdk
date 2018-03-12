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

package com.constantcontact.v2.campaigns;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Comparator;

/**
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class ClickThroughDetail implements Serializable {
    public static Comparator<ClickThroughDetail> AscendingClickCountComparator = new Comparator<ClickThroughDetail>() {
        @Override
        public int compare(ClickThroughDetail lhs, ClickThroughDetail rhs) {
            if (lhs.getClickCount() < rhs.getClickCount()) {
                return -1;
            }
            if (lhs.getClickCount() > rhs.getClickCount()) {
                return 1;
            }
            return 0;
        }
    };

    public static Comparator<ClickThroughDetail> DescendingClickCountComparator = new Comparator<ClickThroughDetail>() {
        @Override
        public int compare(ClickThroughDetail lhs, ClickThroughDetail rhs) {
            if (lhs.getClickCount() < rhs.getClickCount()) {
                return 1;
            }
            if (lhs.getClickCount() > rhs.getClickCount()) {
                return -1;
            }
            return 0;
        }
    };

    @JsonProperty("click_count")
    protected int _clickCount;

    @JsonProperty("url")
    protected String _url;

    @JsonProperty("url_uid")
    protected String _urlUid;

    public ClickThroughDetail() {
    }

    public int getClickCount() {
        return _clickCount;
    }

    public void setClickCount(int clickCount) {
        _clickCount = clickCount;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String url) {
        _url = url;
    }

    public String getUrlUid() {
        return _urlUid;
    }

    public void setUrlUid(String urlUid) {
        _urlUid = urlUid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ClickThroughDetail)) {
            return false;
        } else {
            ClickThroughDetail rhs = (ClickThroughDetail) obj;
            return new EqualsBuilder()
                    .append(_clickCount, rhs.getClickCount())
                    .append(_url, rhs.getUrl())
                    .append(_urlUid, rhs.getUrlUid())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_clickCount)
                .append(_url)
                .append(_urlUid)
                .hashCode();
    }
}
