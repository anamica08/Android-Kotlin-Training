package com.learningandroid.daggerhandson.Engine

import dagger.Module
import dagger.Provides

@Module
class PetrolEngineModule {

    companion object{
        @Provides
        fun providePetrolEngine(engine:PetrolEngine):Engine{
            return engine
        }
    }
}