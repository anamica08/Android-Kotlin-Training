package com.learningandroid.daggerhandson

import com.learningandroid.daggerhandson.Engine.PetrolEngine
import com.learningandroid.daggerhandson.Engine.PetrolEngineModule
import com.learningandroid.daggerhandson.wheels.WheelsModule
import dagger.Component


//this class is responsible for creating and supply injectons to classes which require them.
@Component(modules = arrayOf(WheelsModule::class,PetrolEngineModule::class))
interface CarComponent {

    fun getCarInstance():Car

    fun inject(mainActivity: MainActivity)

}