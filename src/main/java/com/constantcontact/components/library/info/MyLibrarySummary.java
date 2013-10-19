package com.constantcontact.components.library.info;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyLibrarySummary extends Component implements Serializable {

    private static final long serialVersionUID = 453336924148839306L;

    @JsonIgnore
    private Long maxPremiumSpaceLimit;
    
    @JsonIgnore
    private Integer maxFreeFileNum;
    
    @JsonIgnore
    private Integer maxUploadSizeLimit;
    
    @JsonIgnore
    private String imageRoot;
    
    @JsonIgnore
    private UsageSummary usageSummary;

    @JsonProperty("max_premium_space_limit")
    public Long getMaxPremiumSpaceLimit() {
        return maxPremiumSpaceLimit;
    }
    @JsonProperty("max_free_file_num")
    public Integer getMaxFreeFileNum() {
        return maxFreeFileNum;
    }

    @JsonProperty("max_upload_size_limit")
    public Integer getMaxUploadSizeLimit() {
        return maxUploadSizeLimit;
    }

    @JsonProperty("image_root")
    public String getImageRoot() {
        return imageRoot;
    }

    @JsonProperty("usage_summary")
    public UsageSummary getUsageSummary() {
        return usageSummary;
    }

    public void setMaxPremiumSpaceLimit(Long maxPremiumSpaceLimit) {
        this.maxPremiumSpaceLimit = maxPremiumSpaceLimit;
    }

    public void setMaxFreeFileNum(Integer maxFreeFileNum) {
        this.maxFreeFileNum = maxFreeFileNum;
    }

    public void setMaxUploadSizeLimit(Integer maxUploadSizeLimit) {
        this.maxUploadSizeLimit = maxUploadSizeLimit;
    }

    public void setImageRoot(String imageRoot) {
        this.imageRoot = imageRoot;
    }

    public void setUsageSummary(UsageSummary usageSummary) {
        this.usageSummary = usageSummary;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("MyLibrarySummary [");

        builder.append("maxPremiumSpaceLimit=").append(maxPremiumSpaceLimit);
        builder.append(", maxFreeFileNum=").append(maxFreeFileNum);
        builder.append(", maxUploadSizeLimit=").append(maxUploadSizeLimit);
        builder.append(", imageRoot=").append(imageRoot);
        builder.append(", usageSummary=").append(usageSummary);

        builder.append("]");

        return builder.toString();
    }
    
}
