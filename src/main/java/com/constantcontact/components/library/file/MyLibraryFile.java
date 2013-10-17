package com.constantcontact.components.library.file;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyLibraryFile extends Component implements Serializable {

    private static final long serialVersionUID = 5426997354430660543L;
    
    public enum Type {ALL, IMAGES, DOCUMENTS};
    
    public enum Source {ALL, MyComputer, StockImage, Facebook, Instagram, Shutterstock, Mobile};

    public enum SortBy {ADDED_DATE, ADDED_DATE_DESC, MODIFIED_DATE, MODIFIED_DATE_DESC,
        NAME, NAME_DESC, SIZE, SIZE_DESC, DIMENSION, DIMENSION_DESC};
    
    @JsonIgnore
    private String createdDate;
    
    @JsonIgnore
    private String status;
    
    @JsonIgnore
    private String modifiedDate;

    @JsonIgnore
    private Integer width;
    
    @JsonIgnore
    private String fileName;
    
    @JsonIgnore
    private String url;
    
    @JsonIgnore
    private String fileType;
    
    @JsonIgnore
    private Integer size;
    
    @JsonIgnore
    private String id;
    
    @JsonIgnore
    private String folder;
    
    @JsonIgnore
    private String folderId;
    
    @JsonIgnore
    private Integer height;
    
    @JsonIgnore
    private Source source;
    
    @JsonIgnore
    private String description;
    
    @JsonIgnore
    private Boolean isImage;
    
    @JsonIgnore
    private MyLibraryThumbnail thumbnail;

    @JsonProperty("created_date")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("modified_date")
    public String getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("file_name")
    public String getFileName() {
        return fileName;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("file_type")
    public String getFileType() {
        return fileType;
    }

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("folder")
    public String getFolder() {
        return folder;
    }

    @JsonProperty("folder_id")
    public String getFolderId() {
        return folderId;
    }

    @JsonProperty("height")
    public Integer getHeight(){
        return height;
    }
    
    @JsonProperty("source")
    public Source getSource(){
        return source;
    }
    
    @JsonProperty("description")
    public String getDescription(){
        return description;
    }
    
    @JsonProperty("is_image")
    public Boolean getIsImage(){
        return isImage;
    }

    @JsonProperty("thumbnail")
    public MyLibraryThumbnail getThumbnail() {
        return thumbnail;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }
    
    public void setHeight(Integer height){
        this.height = height;
    }
    
    public void setSource(Source source){
        this.source = source;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public void setIsImage(Boolean isImage){
        this.isImage = isImage;
    }

    public void setThumbnail(MyLibraryThumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("MyLibraryFile [");

        builder.append("createdDate=").append(createdDate);
        builder.append(", status=").append(status);
        builder.append(", modifiedDate=").append(modifiedDate);
        builder.append(", width=").append(width);
        builder.append(", fileName=").append(fileName);
        builder.append(", url=").append(url);
        builder.append(", fileType=").append(fileType);
        builder.append(", size=").append(size);
        builder.append(", id=").append(id);
        builder.append(", folder=").append(folder);
        builder.append(", folderId=").append(folderId);
        builder.append(", height=").append(height);
        builder.append(", source=").append(source);
        builder.append(", description=").append(description);
        builder.append(", thumbnail=").append(thumbnail);

        builder.append("]");

        return builder.toString();
    }

}
