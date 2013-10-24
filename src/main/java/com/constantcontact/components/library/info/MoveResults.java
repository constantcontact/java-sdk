package com.constantcontact.components.library.info;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MoveResults extends Component implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private String id;
    
    @JsonIgnore
    private String uri;
    
    @JsonProperty("id")
    public String getId(){
        return this.id;
    }
    
    @JsonProperty("uri")
    public String getUri(){
        return this.uri;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setUri(String uri){
        this.uri = uri;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("MoveResults [");

        builder.append("id=").append(id);
        builder.append(", uri=").append(uri);

        builder.append("]");

        return builder.toString();
    }
    
}
