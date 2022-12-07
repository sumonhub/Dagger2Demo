package com.app.dagger2demo.view.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.app.dagger2demo.databinding.ActivityMainBinding;
import com.app.dagger2demo.di.DaggerDataComponent;
import com.app.dagger2demo.di.DataComponent;
import com.app.dagger2demo.view.adapter.AdapterData;
import com.app.dagger2demo.viewmodel.DataViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Inject
    DataViewModel dataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AdapterData adapterData = new AdapterData(this);
        binding.rv.setLayoutManager(new LinearLayoutManager(this));
        binding.rv.setAdapter(adapterData);

        DataComponent component = DaggerDataComponent.builder().build();
        component.inject(this);

        dataViewModel.getUser().observe(this, dataModel -> {
            adapterData.setDatas(dataModel.getData());
        });

    }
}