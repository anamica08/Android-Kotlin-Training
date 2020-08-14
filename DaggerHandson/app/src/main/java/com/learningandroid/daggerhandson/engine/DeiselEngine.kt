package com.learningandroid.daggerhandson.engine

import android.util.Log
import javax.inject.Inject

class DeiselEngine @Inject constructor():Engine {
    private  val TAG = "DeiselEngine"
    override fun start() {
        Log.d(TAG, "start: Deisel Engine Started.................")
    }
}