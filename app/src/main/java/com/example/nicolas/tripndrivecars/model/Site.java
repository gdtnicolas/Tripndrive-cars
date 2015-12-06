package com.example.nicolas.tripndrivecars.model;

/**
 * Created by Nicolas on 03/12/2015.
 */
public class Site {

    private String code;
    private String label;
    private String type;
    private float lat;
    private float lng;
    private String htmlParkLandingUrl;
    private int parkMinDurationHours;
    private int parkMaxDurationDays;
    private int rentDelayHours;
    private int parkDelayHours;
    private String  agencyStart;
    private String agencyEnd;

    public Site() {
    }

    public Site(String code, String label, String type, int lat, int lng, String htmlParkLandingUrl, int parkMinDurationHours, int parkMaxDurationDays, int rentDelayHours, int parkDelayHours, String agencyStart, String agencyEnd) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.lat = lat;
        this.lng = lng;
        this.htmlParkLandingUrl = htmlParkLandingUrl;
        this.parkMinDurationHours = parkMinDurationHours;
        this.parkMaxDurationDays = parkMaxDurationDays;
        this.rentDelayHours = rentDelayHours;
        this.parkDelayHours = parkDelayHours;
        this.agencyStart = agencyStart;
        this.agencyEnd = agencyEnd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getHtmlParkLandingUrl() {
        return htmlParkLandingUrl;
    }

    public void setHtmlParkLandingUrl(String htmlParkLandingUrl) {
        this.htmlParkLandingUrl = htmlParkLandingUrl;
    }

    public int getParkMinDurationHours() {
        return parkMinDurationHours;
    }

    public void setParkMinDurationHours(int parkMinDurationHours) {
        this.parkMinDurationHours = parkMinDurationHours;
    }

    public int getParkMaxDurationDays() {
        return parkMaxDurationDays;
    }

    public void setParkMaxDurationDays(int parkMaxDurationDays) {
        this.parkMaxDurationDays = parkMaxDurationDays;
    }

    public int getRentDelayHours() {
        return rentDelayHours;
    }

    public void setRentDelayHours(int rentDelayHours) {
        this.rentDelayHours = rentDelayHours;
    }

    public int getParkDelayHours() {
        return parkDelayHours;
    }

    public void setParkDelayHours(int parkDelayHours) {
        this.parkDelayHours = parkDelayHours;
    }

    public String getAgencyStart() {
        return agencyStart;
    }

    public void setAgencyStart(String agencyStart) {
        this.agencyStart = agencyStart;
    }

    public String getAgencyEnd() {
        return agencyEnd;
    }

    public void setAgencyEnd(String agencyEnd) {
        this.agencyEnd = agencyEnd;
    }

    public String toString(){
        return this.label + " : " + this.code;
    }
}
