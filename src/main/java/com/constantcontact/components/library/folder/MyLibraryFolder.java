package com.constantcontact.components.library.folder;

import java.io.Serializable;
import java.util.List;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyLibraryFolder extends Component implements Serializable {

    private static final long serialVersionUID = 7090588308819168942L;

    public enum FolderSortOptions{ADDED_DATE, ADDED_DATE_DESC, MODIFIED_DATE, MODIFIED_DATE_DESC, NAME, NAME_DESC};
    
    @JsonIgnore
    private String createdDate;
    
    @JsonIgnore
    private String id;
    
    @JsonIgnore
    private Integer level;
    
    @JsonIgnore
    private String modifiedDate;
    
    @JsonIgnore
    private String name;
    
    @JsonIgnore
    private List<MyLibraryFolder> children;
    
    @JsonIgnore
    private Integer itemCount;
    
    @JsonIgnore
    private String parentId;

    @JsonProperty("created_date")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("level")
    public Integer getLevel() {
        return level;
    }

    @JsonProperty("modified_date")
    public String getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("children")
    public List<MyLibraryFolder> getChildren() {
        return children;
    }

    @JsonProperty("item_count")
    public Integer getItemCount() {
        return itemCount;
    }

    @JsonProperty("parent_id")
    public String getParentId() {
        return parentId;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildren(List<MyLibraryFolder> children) {
        this.children = children;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("MyLibraryFoler [");

        builder.append("createdDate=").append(createdDate);
        builder.append(", id=").append(id);
        builder.append(", level=").append(level);
        builder.append(", modifiedDate=").append(modifiedDate);
        builder.append(", name=").append(name);
        builder.append(", children=").append(children);
        builder.append(", itemCount=").append(itemCount);
        builder.append(", parentId=").append(parentId);

        builder.append("]");

        return builder.toString();
    }

}
