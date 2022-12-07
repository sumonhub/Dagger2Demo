package com.app.dagger2demo.data;

import androidx.lifecycle.MutableLiveData;

import com.app.dagger2demo.data.model.DataModel;
import com.app.dagger2demo.data.remote.RetrofitService;
import com.app.dagger2demo.data.remote.RetrofitClient;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class DataRepo {
    private final String TAG = "DataRepo";

    RetrofitService retrofitService;

    @Inject
    public DataRepo() {
        this.retrofitService = new RetrofitClient().getRetrofitService();
    }

    public MutableLiveData<DataModel> getUser() {
        final MutableLiveData<DataModel> mutableLiveData = new MutableLiveData<>();
        retrofitService
                .getUser()
                .enqueue(new Callback<DataModel>() {
                    @Override
                    public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                        mutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<DataModel> call, Throwable t) {
                        mutableLiveData.setValue(null);
                    }
                });

        return mutableLiveData;
    }
}
