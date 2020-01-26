package com.example.projectapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonFile {
    @SerializedName("search_found")
    @Expose
    private Integer searchFound;
    @SerializedName("error")
    @Expose
    private Integer error;
    @SerializedName("error_report")
    @Expose
    private String errorReport;
    @SerializedName("search_result")
    @Expose
    private List<SearchResult> searchResult = null;

    public Integer getSearchFound() {
        return searchFound;
    }

    public void setSearchFound(Integer searchFound) {
        this.searchFound = searchFound;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getErrorReport() {
        return errorReport;
    }

    public void setErrorReport(String errorReport) {
        this.errorReport = errorReport;
    }

    public List<SearchResult> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<SearchResult> searchResult) {
        this.searchResult = searchResult;
    }
}
