package com.learningandroid.daggerhandson.engine

import android.util.Log
import javax.inject.Inject

class PetrolEngine :Engine  {
    private val TAG = "PertolEngine"
    override fun start() {
        Log.d(TAG, "start: Petrol Engine started..........")
    }
}