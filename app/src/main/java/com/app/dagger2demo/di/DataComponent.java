package com.app.dagger2demo.di;

import com.app.dagger2demo.view.view.MainActivity;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component
public interface DataComponent {
    void inject(MainActivity mainActivity);
}
