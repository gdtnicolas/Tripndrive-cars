package com.example.nicolas.tripndrivecars.model;

/**
 * Created by Nicolas on 03/12/2015.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CarImage {

    @SerializedName("smallUrl")
    @Expose
    private String smallUrl;
    @SerializedName("mediumUrl")
    @Expose
    private String mediumUrl;
    @SerializedName("largeUrl")
    @Expose
    private String largeUrl;
    @SerializedName("key")
    @Expose
    private String key;

    public CarImage() {
    }

    public CarImage(String smallUrl, String mediumUrl, String largeUrl, String key) {
        this.smallUrl = smallUrl;
        this.mediumUrl = mediumUrl;
        this.largeUrl = largeUrl;
        this.key = key;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
