package com.constantcontact.v2.campaigns;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class ClickThroughDetail implements Serializable {
    public static Comparator<ClickThroughDetail> AscendingClickCountComparator = new Comparator<ClickThroughDetail>() {
        @Override
        public int compare(ClickThroughDetail lhs, ClickThroughDetail rhs) {
            if (lhs.getClickCount() < rhs.getClickCount()) {
                return -1;
            }
            if (lhs.getClickCount() > rhs.getClickCount()) {
                return 1;
            }
            return 0;
        }
    };

    public static Comparator<ClickThroughDetail> DescendingClickCountComparator = new Comparator<ClickThroughDetail>() {
        @Override
        public int compare(ClickThroughDetail lhs, ClickThroughDetail rhs) {
            if (lhs.getClickCount() < rhs.getClickCount()) {
                return 1;
            }
            if (lhs.getClickCount() > rhs.getClickCount()) {
                return -1;
            }
            return 0;
        }
    };

    @JsonProperty("click_count")
    protected int _clickCount;

    @JsonProperty("url")
    protected String _url;

    @JsonProperty("url_uid")
    protected String _urlUid;

    public ClickThroughDetail() {
    }

    public int getClickCount() {
        return _clickCount;
    }

    public void setClickCount(int clickCount) {
        _clickCount = clickCount;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String url) {
        _url = url;
    }

    public String getUrlUid() {
        return _urlUid;
    }

    public void setUrlUid(String urlUid) {
        _urlUid = urlUid;
    }
}
