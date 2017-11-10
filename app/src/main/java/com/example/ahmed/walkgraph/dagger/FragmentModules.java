package com.example.ahmed.walkgraph.dagger;

import com.example.ahmed.walkgraph.presentation.list.GraphListImpl;
import com.example.ahmed.walkgraph.presentation.map.MapFragmentImpl;
import com.example.ahmed.walkgraph.presentation.settings.SettingsFragment;
import com.example.ahmed.walkgraph.presentation.splash.SplashFragmentImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ahmed on 8/9/17.
 */
@Module
class FragmentModules {
    @Provides
    @Singleton
    SplashFragmentImpl providesSplashFragment(){
        return new SplashFragmentImpl();
    }

    @Provides
    @Singleton
    MapFragmentImpl providesMapFragment(){
        return new MapFragmentImpl();
    }

    @Provides
    @Singleton
    GraphListImpl providesGraphList(){
        return new GraphListImpl();
    }

    @Provides
    @Singleton
    SettingsFragment providesSettingsFragment(){
        return new SettingsFragment();
    }
}
