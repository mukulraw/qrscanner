package com.example.qrscanner;

import com.example.qrscanner.getDataPOJO.getDataBean;

import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AllApiIneterface {


    @Multipart
    @POST("qrapp/api/getData.php")
    Call<getDataBean> getData(
            @Part("RegNo") String RegNo
    );

}
