package com.example.nicolas.tripndrivecars;

import com.example.nicolas.tripndrivecars.model.Car;
import com.example.nicolas.tripndrivecars.model.Site;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;


/**
 * Created by Nicolas on 03/12/2015.
 */


public interface TripndriveService {

    @GET("/sites")
    Call<List<Site>> getListSites();

    @GET("/rent-results?")
    Call<List<Car>> getListCars(@Query("endDate") String endDate, @Query("endTime") String endTime,
                                @Query("max") int max, @Query("offset") int offset,
                                @Query("siteCode") String siteCode,
                                @Query("startDate") String startDate, @Query("startTime") String startTime);


}