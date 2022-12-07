package com.app.dagger2demo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.dagger2demo.data.DataRepo;
import com.app.dagger2demo.data.model.DataModel;
import javax.inject.Inject;

public class DataViewModel extends ViewModel {

    @Inject
    DataRepo dataRepo;

    @Inject
    public DataViewModel() {
    }

    // User
    public MutableLiveData<DataModel> getUser() {
        return dataRepo.getUser();
    }
}
