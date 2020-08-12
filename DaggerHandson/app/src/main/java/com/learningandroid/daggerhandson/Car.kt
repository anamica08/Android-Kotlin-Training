package com.learningandroid.daggerhandson

import android.util.Log
import javax.inject.Inject

//constructor injection
class Car @Inject constructor(private val wheel: Wheel, private val engine: Engine) {
    private val TAG = "Car"

    //Method Injection
    @Inject
    fun enableRemote(remote:Remote){
        remote.setListener(this)
    }

    fun drive(){
        Log.d(TAG, "drive:  Driving................ ")
    }
}