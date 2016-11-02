package com.constantcontact.v2.library;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
}
