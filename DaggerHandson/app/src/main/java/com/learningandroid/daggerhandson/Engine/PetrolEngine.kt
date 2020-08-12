package com.learningandroid.daggerhandson.Engine

import android.util.Log
import javax.inject.Inject

class PetrolEngine @Inject constructor():Engine  {
    private val TAG = "PertolEngine"
    override fun start() {
        Log.d(TAG, "start: Petrol Engine started..........")
    }
}