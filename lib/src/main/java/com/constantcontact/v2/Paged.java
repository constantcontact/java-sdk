package com.constantcontact.v2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author woogienoogie
 */
public class Paged<T> {
    @JsonProperty("meta")
    private Meta _meta;

    @JsonProperty("results")
    private List<T> _results;

    public Paged() {
    }

    public Meta getMeta() {
        return _meta;
    }

    public void setMeta(Meta meta) {
        _meta = meta;
    }

    public void setResults(List<T> results) {
        _results = results;
    }

    public List<T> getResults() {
        return _results;
    }

    public String getNextLink() {
        if (_meta != null && _meta.pagination != null && _meta.pagination.nextLink != null) {
            // Format this returns in is a full path, with a leading slash, which we don't want.
            return _meta.pagination.nextLink.substring(1);
        }
        return null;
    }

    private static class Meta {
        @JsonProperty("pagination")
        public Pagination pagination;

        public Meta() {
        }
    }

    private static class Pagination {
        @JsonProperty("next_link")
        public String nextLink;

        public Pagination() {
        }
    }
}
