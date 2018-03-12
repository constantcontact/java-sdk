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

/**
 * @author ngalbrai
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class LibraryInfo implements Serializable {
    @JsonProperty("max_free_file_num")
    protected int _maxFreeFileNum;

    @JsonProperty("max_premium_space_limit")
    protected int _maxPremiumSpaceLimit;

    @JsonProperty("image_root")
    protected String _imageRoot;

    @JsonProperty("usage_summary")
    protected UsageSummary _usageSummary;

    @JsonProperty("max_upload_size_limit")
    protected int _maxUploadSizeLimit;

    public LibraryInfo() {
    }

    public int getMaxFreeFileNum() {
        return _maxFreeFileNum;
    }

    public void setMaxFreeFileNum(int maxFreeFileNum) {
        _maxFreeFileNum = maxFreeFileNum;
    }

    public int getMaxPremiumSpaceLimit() {
        return _maxPremiumSpaceLimit;
    }

    public void setMaxPremiumSpaceLimit(int maxPremiumSpaceLimit) {
        _maxPremiumSpaceLimit = maxPremiumSpaceLimit;
    }

    public String getImageRoot() {
        return _imageRoot;
    }

    public void setImageRoot(String imageRoot) {
        _imageRoot = imageRoot;
    }

    public UsageSummary getUsageSummary() {
        return _usageSummary;
    }

    public void setUsageSummary(UsageSummary usageSummary) {
        _usageSummary = usageSummary;
    }

    public int getMaxUploadSizeLimit() {
        return _maxUploadSizeLimit;
    }

    public void setMaxUploadSizeLimit(int maxUploadSizeLimit) {
        _maxUploadSizeLimit = maxUploadSizeLimit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LibraryInfo)) {
            return false;
        } else {
            LibraryInfo rhs = (LibraryInfo) obj;
            return new EqualsBuilder()
                    .append(_maxFreeFileNum, rhs.getMaxFreeFileNum())
                    .append(_maxPremiumSpaceLimit, rhs.getMaxPremiumSpaceLimit())
                    .append(_imageRoot, rhs.getImageRoot())
                    .append(_usageSummary, rhs.getUsageSummary())
                    .append(_maxUploadSizeLimit, rhs.getMaxUploadSizeLimit())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_maxFreeFileNum)
                .append(_maxPremiumSpaceLimit)
                .append(_imageRoot)
                .append(_usageSummary)
                .append(_maxUploadSizeLimit)
                .hashCode();
    }
}
