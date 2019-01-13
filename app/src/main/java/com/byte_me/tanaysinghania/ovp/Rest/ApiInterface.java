package com.byte_me.tanaysinghania.ovp.Rest;


import com.byte_me.tanaysinghania.ovp.LeaderHolder;
import com.byte_me.tanaysinghania.ovp.LeaderRecyclerView.LeaderObject;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.POST;



public interface ApiInterface {

//    @GET("driver/detail/{id}")
//    Call<Driver> getDriver(@Path("id") String id);
//
//    @GET("driver/{id}/location")
//    Call<Driver_Location> getDriverLocation(@Path("id") String id);
//
//    @PUT("driver/location/update/{id}/")
//    Call<HashMap<String ,String>> updateDriverLocation(@Path("id") String id,@Body DriverLocationONLY driverLocationONLY);
//
//    @POST("api-token-auth/")
//    Call<HashMap<String,Object>> login(@Body Login login);
//
//    @POST("driver/register/")
//    Call<Driver> registerDriver(@Body Driver driver);
//
//    @PATCH("driver/{id}/update")
//    Call<Driver> updateDriver(@Path("id") String id,@Body Driver driver);
//
    //@PATCH("trip/complete/{id}/")
    //Call<HashMap<String,Object>> setRating(@Path("id") String id, @Body Rating rating);
//
    @POST("login.json/")
    Call<com.byte_me.tanaysinghania.ovp.loginHolder> getCustomer(@Body com.byte_me.tanaysinghania.ovp.loginHolder login);

    @GET("leaders/{id}/")
    Call<LeaderHolder> getLeader(@Path("id") String id);


    @POST("register.json/")
    Call<com.byte_me.tanaysinghania.ovp.user> registerCustomer(@Body com.byte_me.tanaysinghania.ovp.user USER);
//
//    @GET("user/history/{id}")
//    Call<History> getCustomerHistory(@Path("id") String id);
//
//    @PUT("user/update/{id}/")
//    Call<Customer> updateCustomer(@Body Customer customer,@Path("id") String id);
//
//    //TODO: Showing all the Drivers feature
//    @GET("available_drivers")
//    Call<ArrayList<AvailableDriverHolder>> getAllAvailableDrivers();
//
//    @POST("trip/nearby-cab/")
//    Call<Trip> createTrip(@Body Trip Request);


//    @GET("users/customer/{id}/request")
//    Call<CabRequest> getCabRequest(@Path("id") String id);

//    @POST("user/driver/update/customer_request")
//    Call<DriverResponse> postCustomerRequest(@Body CustomerRequest customerRequest);

//    @GET("user/driver/{id}/customer_request")
//    Call<CustomerRequest> getCustomerRequest(@Path("id") String id);

//    @DELETE("user/driver/{id}/customer_request")
//    Call<DriverResponse> emptyCustomerRequest(@Path("id") String id);
//
//    @POST("history")
//    Call<DriverResponse> enterNewHistory(@Body History history);
//
//    @DELETE("available_drivers/{id}")
//    Call<DriverResponse> removeAvailableDriver(@Path("id") String id);
//
//    @GET("trip/complete/{id}/")
//    Call<CompleteTrip> getTrip(@Path("id") String id);
    //@Header("Authorization") String auth , @Header("Accept-Language") String len, @Header("Content-Type") String type, @Query("start_latitude") double start_lat, @Query("start_longitude") double start_lon, @Query("end_latitude") double end_lat, @Query("end_longitude") double end_lon

}