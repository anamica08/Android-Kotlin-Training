package com.learningandroid.daggerhandson.engine

import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
abstract class DeiselEngineModule() {
    

    companion object{
        @Provides
        fun providePetrolEngine(engine:DeiselEngine):Engine{
            return engine
        }
    }


}