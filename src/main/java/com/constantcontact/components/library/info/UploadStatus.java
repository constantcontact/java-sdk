package com.constantcontact.components.library.info;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadStatus extends Component implements Serializable {

    private static final long serialVersionUID = -8206195775845950976L;

    public enum StatusName{Active,Processing,Uploaded,VirusFound,Failed,Deleted};
    
    @JsonIgnore
    private StatusName status;
    
    @JsonIgnore
    private String description;
    
    @JsonIgnore
    private String fileId;
    
    @JsonProperty("status")
    public StatusName getStatus() {
        return status;
    }
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("file_id")
    public String getFileId() {
        return fileId;
    }

    public void setStatus(StatusName status) {
        this.status = status;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("UploadStatus [");

        builder.append("status=").append(status);
        builder.append(", description=").append(description);
        builder.append(", fileId=").append(fileId);

        builder.append("]");

        return builder.toString();
    }
    
}
