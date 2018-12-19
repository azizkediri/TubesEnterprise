package com.example.abdazizs.go_loundry.Rest;

import com.example.abdazizs.go_loundry.Models.ListResultUser;
import com.example.abdazizs.go_loundry.Models.ResultTranksaksi;
import com.example.abdazizs.go_loundry.Models.ResultUser;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by alhamdulillah on 10/23/16.
 */
public interface ApiInterface {

    @GET("user")
    Call<ListResultUser> getUser();

    @Multipart
    @POST("user")
    Call<ResultUser> postUser(@Part MultipartBody.Part file,
                              @Part("nama") RequestBody nama,
                              @Part("alamat") RequestBody alamat,
                              @Part("telpn") RequestBody jenis_kelamin,
                              @Part("password") RequestBody password,
                              @Part("level") int level,
                              @Part("action") RequestBody action);
    @Multipart
    @POST("user")
    Call<ResultUser> putUser(@Part MultipartBody.Part file,
                                     @Part("nama") RequestBody nama,
                                     @Part("alamat") RequestBody alamat,
                                     @Part("telpn") RequestBody jenis_kelamin,
                                     @Part("password") RequestBody password,
                                     @Part("action") RequestBody action);

    @POST("user")
    Call<ResultUser> deleteUser(@Part("id") RequestBody idCust,
                                        @Part("action") RequestBody action);

    //tranksaksi
    @GET("tranksaksi")
    Call<ResultTranksaksi> getTranksaksi();

    @FormUrlEncoded
    @POST("tranksaksi")
    Call<ResultTranksaksi> postTransaksi(@Field("nama_user") String nama_user,
                                         @Field("cuci") int cuci,
                                         @Field("setrika") int setrika,
                                         @Field("express") int express,
                                         @Field("antar") int antar,
                                         @Field("total") int total,
                                         @Field("status") int status,
                                         @Field("action") String action);
    @FormUrlEncoded
    @POST("tranksaksi")
    Call<ResultTranksaksi> putTranksaksi(@Field("id_tranksaksi") int idTranksaksi,
                                        @Field("antar") int antar,
                                        @Field("status") int status,
                                        @Field("action") String action);

    //login
    @FormUrlEncoded
    @POST("login")
    Call<ResultUser> getLogin(@Field("nama") String nama,
                              @Field("password") String password);


}