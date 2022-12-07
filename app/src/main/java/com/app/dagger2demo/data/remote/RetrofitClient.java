package com.app.dagger2demo.data.remote;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class RetrofitClient {
    private final String BASE_URL = "https://reqres.in/api/";

    @Singleton
    @Provides
    public Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public RetrofitService getRetrofitService() {
        return getRetrofitInstance().create(RetrofitService.class);
    }
}
