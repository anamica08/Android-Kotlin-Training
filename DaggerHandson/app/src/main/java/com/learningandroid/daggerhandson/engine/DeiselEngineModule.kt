package com.learningandroid.daggerhandson.engine

import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
class DeiselEngineModule(private val horsepower:Int) {
        @Provides
        fun provideDeiselEngine():Engine{
            return DeiselEngine(horsepower = horsepower)
        }
}