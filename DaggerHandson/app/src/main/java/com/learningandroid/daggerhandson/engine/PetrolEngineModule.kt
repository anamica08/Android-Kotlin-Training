package com.learningandroid.daggerhandson.engine

import dagger.Binds
import dagger.Module


@Module
abstract class PetrolEngineModule() {

//    companion object{
//        @Provides
//        fun providePetrolEngine(engine:PetrolEngine):Engine{
//            return engine
//        }
//    }

    /***
     * since we have a variable to instantiate at run time , so we cannot rely on dagger to to provide us
     * an instance of PetrolEngine , we have to instantiate and return it
     */

    @Binds
    abstract fun bindEngine(engine: PetrolEngine):Engine
}