package com.learningandroid.daggerhandson

import android.util.Log
import javax.inject.Inject

class Remote @Inject constructor() {
    private  val TAG = "Remote"
    public fun setListener(car: Car) {
        Log.d(TAG, "setListener: Remote enabled............")
    }
}