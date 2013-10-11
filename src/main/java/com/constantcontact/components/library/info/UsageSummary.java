package com.constantcontact.components.library.info;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsageSummary extends Component implements Serializable {

    private static final long serialVersionUID = -7031145972582977849L;

    @JsonIgnore
    private Integer folderCount;

    @JsonIgnore
    private Integer documentBytesUsed;

    @JsonIgnore
    private Integer imageBytesUsed;

    @JsonIgnore
    private Integer totalBytesRemaining;

    @JsonIgnore
    private Integer totalBytesUsed;

    @JsonIgnore
    private Integer imageCount;

    @JsonIgnore
    private Integer fileCount;

    @JsonIgnore
    private Integer freeFilesRemaining;

    @JsonIgnore
    private Integer documentCount;

    @JsonProperty("folder_count")
    public Integer getFolderCount() {
        return folderCount;
    }

    @JsonProperty("document_bytes_used")
    public Integer getDocumentBytesUsed() {
        return documentBytesUsed;
    }

    @JsonProperty("image_bytes_used")
    public Integer getImageBytesUsed() {
        return imageBytesUsed;
    }

    @JsonProperty("total_bytes_remaining")
    public Integer getTotalBytesRemaining() {
        return totalBytesRemaining;
    }

    @JsonProperty("total_byte_used")
    public Integer getTotalBytesUsed() {
        return totalBytesUsed;
    }

    @JsonProperty("image_count")
    public Integer getImageCount() {
        return imageCount;
    }

    @JsonProperty("file_count")
    public Integer getFileCount() {
        return fileCount;
    }

    @JsonProperty("free_files_remaining")
    public Integer getFreeFilesRemaining() {
        return freeFilesRemaining;
    }

    @JsonProperty("document_count")
    public Integer getDocumentCount() {
        return documentCount;
    }

    public void setFolderCount(Integer folderCount) {
        this.folderCount = folderCount;
    }

    public void setDocumentBytesUsed(Integer documentBytesUsed) {
        this.documentBytesUsed = documentBytesUsed;
    }

    public void setImageBytesUsed(Integer imageBytesUsed) {
        this.imageBytesUsed = imageBytesUsed;
    }

    public void setTotalBytesRemaining(Integer totalBytesRemaining) {
        this.totalBytesRemaining = totalBytesRemaining;
    }

    public void setTotalBytesUsed(Integer totalBytesUsed) {
        this.totalBytesUsed = totalBytesUsed;
    }

    public void setImageCount(Integer imageCount) {
        this.imageCount = imageCount;
    }

    public void setFileCount(Integer fileCount) {
        this.fileCount = fileCount;
    }

    public void setFreeFilesRemaining(Integer freeFilesRemaining) {
        this.freeFilesRemaining = freeFilesRemaining;
    }

    public void setDocumentCount(Integer documentCount) {
        this.documentCount = documentCount;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("UsageSummary [");

        builder.append("folderCount=").append(folderCount);
        builder.append(", documentBytesUsed=").append(documentBytesUsed);
        builder.append(", imageBytesUsed=").append(imageBytesUsed);
        builder.append(", totalBytesRemaining=").append(totalBytesRemaining);
        builder.append(", totalBytesUsed=").append(totalBytesUsed);
        builder.append(", imageCount=").append(imageCount);
        builder.append(", fileCount=").append(fileCount);
        builder.append(", freeFilesRemaining=").append(freeFilesRemaining);
        builder.append(", documentCount=").append(documentCount);

        builder.append("]");

        return builder.toString();
    }

}
