package com.greencode.sampleapplicationsecond.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.greencode.sampleapplicationsecond.model.Products;

import java.util.List;

public class ServiceResponse
{
    @SerializedName("TotalCount")
    @Expose
    private Integer message;

    @SerializedName("Page")
    @Expose
    private Integer response;

    @SerializedName("PageSize")
    @Expose
    private Integer PageSize;

    @SerializedName("List")
    @Expose
    private List<Products> latestList = null;

    public List<Products> getLatestList() {
        return latestList;
    }

    public void setLatestList(List<Products> latestList) {
        this.latestList = latestList;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

}

