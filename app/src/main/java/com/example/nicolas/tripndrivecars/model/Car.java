package com.example.nicolas.tripndrivecars.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Nicolas on 03/12/2015.
 */
public class Car {

    private int kmIncluded;
    private int pid;
    private String modelBrand;
    private String modelName;
    private String modelCategory;
    private int carYear;
    private int doorNumber;
    private int placeNumber;
    private String transmission;
    private String gaz;
    private boolean airconditionning;
    private boolean sunroof;
    private boolean jackPlug;
    private boolean gps;
    private int babyChair;
    private int boosterSeat;
    private int childSeat;
    private List<CarImage>images = new ArrayList<>();
    private String start;
    private String end;
    private int days;
    private int price;
    private int extraKmPrice;
    private String kilometerLabel;
    private String gazLabel;
    private String transmissionLabel;
    private String modelCategoryLabel;
    private int dailyPrice;


    public Car() {
    }

    public String getFormatedExtraPrice(){
        String price = String.valueOf(getDailyPrice());
        if(!price.isEmpty() && price.length()>=2){
            price=price.substring(0,price.length()-2)+","
                    +price.substring(price.length()-2,price.length())+"€";
        }
        return price;
    }

    public String getExtraKmFormatedPrice() {
        String price = String.valueOf(getExtraKmPrice());
        if(!price.isEmpty() && price.length()>2){
            price=price.substring(0,price.length()-2)+","
                    +price.substring(price.length()-2,price.length())+"€";
        }else if (!price.isEmpty() && price.length()==2){
            price="0,"+price+"€";
        }else if (!price.isEmpty() && price.length()==1){
            price="0,à"+price+"€";
        }
        return price;
    }

    public String getFormatedDailyPrice(){
        String price = String.valueOf(getDailyPrice());
        if(!price.isEmpty() && price.length()>=2){
            price=price.substring(0,price.length()-2)+","
                    +price.substring(price.length()-2,price.length())+"€";
        }
        return price;
    }

    public String getFormatedPrice(){
        String price = String.valueOf(getPrice());
        if(!price.isEmpty() && price.length()>=2){
            price=price.substring(0,price.length()-2)+","
                    +price.substring(price.length()-2,price.length())+"€";
        }
        return price;
    }

    public String getCarName(){
        return modelBrand + " " + modelName + " - " + carYear;
    }

    public int getKmIncluded() {
        return kmIncluded;
    }

    public void setKmIncluded(int kmIncluded) {
        this.kmIncluded = kmIncluded;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getModelBrand() {
        return modelBrand;
    }

    public void setModelBrand(String modelBrand) {
        this.modelBrand = modelBrand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelCategory() {
        return modelCategory;
    }

    public void setModelCategory(String modelCategory) {
        this.modelCategory = modelCategory;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getGaz() {
        return gaz;
    }

    public void setGaz(String gaz) {
        this.gaz = gaz;
    }

    public boolean isAirconditionning() {
        return airconditionning;
    }

    public void setAirconditionning(boolean airconditionning) {
        this.airconditionning = airconditionning;
    }

    public boolean isSunroof() {
        return sunroof;
    }

    public void setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
    }

    public boolean isJackPlug() {
        return jackPlug;
    }

    public void setJackPlug(boolean jackPlug) {
        this.jackPlug = jackPlug;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public int getBabyChair() {
        return babyChair;
    }

    public void setBabyChair(int babyChair) {
        this.babyChair = babyChair;
    }

    public int getBoosterSeat() {
        return boosterSeat;
    }

    public void setBoosterSeat(int boosterSeat) {
        this.boosterSeat = boosterSeat;
    }

    public int getChildSeat() {
        return childSeat;
    }

    public void setChildSeat(int childSeat) {
        this.childSeat = childSeat;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getExtraKmPrice() {
        return extraKmPrice;
    }

    public void setExtraKmPrice(int extraKmPrice) {
        this.extraKmPrice = extraKmPrice;
    }

    public String getGazLabel() {
        return gazLabel;
    }

    public void setGazLabel(String gazLabel) {
        this.gazLabel = gazLabel;
    }

    public String getTransmissionLabel() {
        return transmissionLabel;
    }

    public void setTransmissionLabel(String transmissionLabel) {
        this.transmissionLabel = transmissionLabel;
    }

    public String getKilometerLabel() {
        return kilometerLabel;
    }

    public void setKilometerLabel(String kilometerLabel) {
        this.kilometerLabel = kilometerLabel;
    }

    public String getModelCategoryLabel() {
        return modelCategoryLabel;
    }

    public void setModelCategoryLabel(String modelCategoryLabel) {
        this.modelCategoryLabel = modelCategoryLabel;
    }

    public int getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(int dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public List<CarImage> getImages() {
        return images;
    }

    public void setImages(List<CarImage> images) {
        this.images = images;
    }


    public String toString(){
        return this.modelBrand + " " +this.modelName;
    }



}

