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
public class UsageSummary implements Serializable {
    @JsonProperty("folder_count")
    protected int _folderCount;

    @JsonProperty("file_count")
    protected int _fileCount;

    @JsonProperty("image_count")
    protected int _imageCount;

    @JsonProperty("document_count")
    protected int _documentCount;

    @JsonProperty("total_bytes_used")
    protected int _totalBytesUsed;

    @JsonProperty("image_bytes_used")
    protected int _imageBytesUsed;

    @JsonProperty("document_bytes_used")
    protected int _documentBytesUsed;

    @JsonProperty("total_bytes_remaining")
    protected int _totalBytesRemaining;

    @JsonProperty("free_files_remaining")
    protected int _freeFilesRemaining;

    public UsageSummary() {
    }

    public int getFolderCount() {
        return _folderCount;
    }

    public void setFolderCount(int folderCount) {
        _folderCount = folderCount;
    }

    public int getFileCount() {
        return _fileCount;
    }

    public void setFileCount(int fileCount) {
        _fileCount = fileCount;
    }

    public int getImageCount() {
        return _imageCount;
    }

    public void setImageCount(int imageCount) {
        _imageCount = imageCount;
    }

    public int getDocumentCount() {
        return _documentCount;
    }

    public void setDocumentCount(int documentCount) {
        _documentCount = documentCount;
    }

    public int getTotalBytesUsed() {
        return _totalBytesUsed;
    }

    public void setTotalBytesUsed(int totalBytesUsed) {
        _totalBytesUsed = totalBytesUsed;
    }

    public int getImageBytesUsed() {
        return _imageBytesUsed;
    }

    public void setImageBytesUsed(int imageBytesUsed) {
        _imageBytesUsed = imageBytesUsed;
    }

    public int getDocumentBytesUsed() {
        return _documentBytesUsed;
    }

    public void setDocumentBytesUsed(int documentBytesUsed) {
        _documentBytesUsed = documentBytesUsed;
    }

    public int getTotalBytesRemaining() {
        return _totalBytesRemaining;
    }

    public void setTotalBytesRemaining(int totalBytesRemaining) {
        _totalBytesRemaining = totalBytesRemaining;
    }

    public int getFreeFilesRemaining() {
        return _freeFilesRemaining;
    }

    public void setFreeFilesRemaining(int freeFilesRemaining) {
        _freeFilesRemaining = freeFilesRemaining;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof UsageSummary)) {
            return false;
        } else {
            UsageSummary rhs = (UsageSummary) obj;
            return new EqualsBuilder()
                    .append(_folderCount, rhs.getFolderCount())
                    .append(_fileCount, rhs.getFileCount())
                    .append(_imageCount, rhs.getImageCount())
                    .append(_documentCount, rhs.getDocumentCount())
                    .append(_totalBytesUsed, rhs.getTotalBytesUsed())
                    .append(_imageBytesUsed, rhs.getImageBytesUsed())
                    .append(_documentBytesUsed, rhs.getDocumentBytesUsed())
                    .append(_totalBytesRemaining, rhs.getTotalBytesRemaining())
                    .append(_freeFilesRemaining, rhs.getFreeFilesRemaining())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_folderCount)
                .append(_fileCount)
                .append(_imageCount)
                .append(_documentCount)
                .append(_totalBytesUsed)
                .append(_imageBytesUsed)
                .append(_documentBytesUsed)
                .append(_totalBytesRemaining)
                .append(_freeFilesRemaining)
                .hashCode();
    }
}
