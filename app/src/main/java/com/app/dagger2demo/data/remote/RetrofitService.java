package com.app.dagger2demo.data.remote;

import com.app.dagger2demo.data.model.DataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("users")
    Call<DataModel> getUser();
}
