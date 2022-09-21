package com.greencode.sampleapplicationsecond.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Products implements Serializable {

    @SerializedName("ListingId")
    @Expose
    private Long listingId;

    @SerializedName("Title")
    @Expose
    private String title;

    @SerializedName("Category")
    @Expose
    private String category;
    @SerializedName("Region")
    @Expose
    private String region;
    @SerializedName("IsClassified")
    @Expose
    private Boolean isClassified = false;

    @SerializedName("PriceDisplay")
    @Expose
    private String priceDisplay;

    @SerializedName("BuyNowPrice")
    @Expose
    private Double buyNowPrice;

    @SerializedName("IsNew")
    @Expose
    private Boolean isNew;
    @SerializedName("HasReserve")
    @Expose
    private Boolean hasReserve;
    @SerializedName("HasBuyNow")
    @Expose
    private Boolean hasBuyNow;
    @SerializedName("PictureHref")
    @Expose
    private String pictureHref;

    public String getPictureHref() {
        return pictureHref;
    }

    public void setPictureHref(String pictureHref) {
        this.pictureHref = pictureHref;
    }

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Boolean getClassified() {
        return isClassified;
    }

    public void setClassified(Boolean classified) {
        isClassified = classified;
    }

    public String getPriceDisplay() {
        return priceDisplay;
    }

    public void setPriceDisplay(String priceDisplay) {
        this.priceDisplay = priceDisplay;
    }

    public Double getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(Double buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public Boolean getHasReserve() {
        return hasReserve;
    }

    public void setHasReserve(Boolean hasReserve) {
        this.hasReserve = hasReserve;
    }

    public Boolean getHasBuyNow() {
        return hasBuyNow;
    }

    public void setHasBuyNow(Boolean hasBuyNow) {
        this.hasBuyNow = hasBuyNow;
    }
}
