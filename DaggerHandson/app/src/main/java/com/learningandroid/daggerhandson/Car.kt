package com.learningandroid.daggerhandson

import android.util.Log
import com.learningandroid.daggerhandson.engine.Engine
import com.learningandroid.daggerhandson.wheels.Wheels
import javax.inject.Inject

//constructor injection
class Car @Inject constructor(private val wheel: Wheels, private val engine: Engine) {
    private val TAG = "Car"

    //Method Injection
    @Inject
    fun enableRemote(remote:Remote){
        remote.setListener(this)
    }

    fun drive(){
        engine.start()
        Log.d(TAG, "drive:  Driving................ ")
    }
}