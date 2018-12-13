package com.example.abdazizs.go_loundry.Rest;

import com.example.abdazizs.go_loundry.Models.ResultUser;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by alhamdulillah on 10/23/16.
 */
public interface ApiInterface {
//    @GET("pembelian/user")
//    Call<GetPembelian> getPembelian();
//
//    @FormUrlEncoded
//    @POST("pembelian/user")
//    Call<PostPutDelPembelian> postPembelian(@Field("id_pembelian") String idPembelian,
//                                            @Field("id_pembeli") String idPembeli,
//                                            @Field("tanggal_beli") String tanggalBeli,
//                                            @Field("total_harga") String totalHarga,
//                                            @Field("id_tiket") String idTiket);
//    @FormUrlEncoded
//    @PUT("pembelian/user")
//    Call<PostPutDelPembelian> putPembelian(@Field("id_pembelian") String idPembelian,
//                                           @Field("id_pembeli") String idPembeli,
//                                           @Field("tanggal_beli") String tanggalBeli,
//                                           @Field("total_harga") String totalHarga,
//                                           @Field("id_tiket") String idTiket);
//    @FormUrlEncoded
//    @HTTP(method = "DELETE", path = "pembelian/user", hasBody = true)
//    Call<PostPutDelPembelian> deletePembelian(@Field("id_pembelian") String idPembelian);

    /************************************/
    @GET("user")
    Call<ResultUser> getUser();

    @Multipart
    @POST("user")
    Call<ResultUser> postUser(@Part MultipartBody.Part file,
                                 @Part("nama") RequestBody nama,
                                 @Part("alamat") RequestBody alamat,
                                 @Part("telpn") RequestBody telpn,
                                 @Part("password") RequestBody password,
                                 @Part("level") RequestBody level,
                                 @Part("action") RequestBody action);
    @Multipart
    @POST("user")
    Call<ResultUser> putUser(@Part MultipartBody.Part file,
                                @Part("id_user") RequestBody idUser,
                                @Part("nama") RequestBody nama,
                                @Part("alamat") RequestBody alamat,
                                @Part("telpn") RequestBody telpn,
                                @Part("password") RequestBody password,
                                @Part("level") RequestBody level,
                                @Part("action") RequestBody action);
    @Multipart
    @POST("user")
    Call<ResultUser> deleteUser(@Part("id_user") RequestBody idUser,
                                   @Part("action") RequestBody action);

}