package com.example.nicolas.tripndrivecars;

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

    public static final String ENDPOINT = "https://api.tripndrive.com";
    @GET("/sites")
    Call<List<Site>> getListSites();

}
