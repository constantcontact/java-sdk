package com.constantcontact.v2.library;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public final class File implements Serializable {
    @JsonProperty("name")
    protected String _name;

    @JsonProperty("id")
    protected String _id;

    @JsonProperty("description")
    protected String _description = "";

    @JsonProperty("folder")
    protected String _folder;

    @JsonProperty("height")
    protected int _height;

    @JsonProperty("width")
    protected int _width;

    @JsonProperty("size")
    protected int _size;

    @JsonProperty("url")
    protected String _url;

    @JsonProperty("source")
    protected FileSource _source = FileSource.MOBILE;

    @JsonProperty("file_type")
    protected FileType _fileType;

    @JsonProperty("status")
    protected FileStatus _status = FileStatus.ACTIVE;

    @JsonProperty("thumbnail")
    protected Thumbnail _thumbnail;

    @JsonProperty("folder_id")
    protected String _folderId = "0";

    @JsonProperty("is_image")
    protected boolean _isImage;

    @JsonProperty("modified_date")
    protected Date _modifiedDate;

    @JsonProperty("created_date")
    protected Date _createdDate;

    public File() {
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getFolder() {
        return _folder;
    }

    public void setFolder(String folder) {
        _folder = folder;
    }

    public int getHeight() {
        return _height;
    }

    public void setHeight(int height) {
        _height = height;
    }

    public int getWidth() {
        return _width;
    }

    public void setWidth(int width) {
        _width = width;
    }

    public int getSize() {
        return _size;
    }

    public void setSize(int size) {
        _size = size;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String url) {
        _url = url;
    }

    public FileSource getSource() {
        return _source;
    }

    public void setSource(FileSource source) {
        _source = source;
    }

    public FileType getFileType() {
        return _fileType;
    }

    public void setFileType(FileType fileType) {
        _fileType = fileType;
    }

    public FileStatus getStatus() {
        return _status;
    }

    public void setStatus(FileStatus status) {
        _status = status;
    }

    public Thumbnail getThumbnail() {
        return _thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        _thumbnail = thumbnail;
    }

    public String getFolderId() {
        return _folderId;
    }

    public void setFolderId(String folderId) {
        _folderId = folderId;
    }

    public boolean isImage() {
        return _isImage;
    }

    public void setImage(boolean image) {
        _isImage = image;
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
}
