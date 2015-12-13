package com.example.nicolas.tripndrivecars.model;

/**
 * Created by Nicolas on 12/12/2015.
 */
public class CustomDate {
    private int year;
    private int month;
    private int day;

    public CustomDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public CustomDate() {
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAfter(CustomDate date) {
        boolean result = false;
        if (this.year > date.year) {
            result = true;
        } else if (this.year == date.year) {
            if (this.month > date.month) {
                result = true;
            } else if (this.month == date.month) {
                if (this.day >= date.day) {
                    result = true;
                }
            }
        }
        return result;
    }

}
