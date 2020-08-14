package com.learningandroid.daggerhandson


import com.learningandroid.daggerhandson.engine.DeiselEngine
import com.learningandroid.daggerhandson.engine.DeiselEngineModule
import com.learningandroid.daggerhandson.engine.PetrolEngineModule
import com.learningandroid.daggerhandson.wheels.WheelsModule
import dagger.Component


//this class is responsible for creating and supply injectons to classes which require them.
@Component(modules = arrayOf(WheelsModule::class, DeiselEngineModule::class))
interface CarComponent {

    fun getCarInstance():Car

    fun inject(mainActivity: MainActivity)

}