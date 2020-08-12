package com.example.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    private val TAG = "MyReceiver"
    override fun onReceive(context: Context, intent: Intent) {

        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Log.d(TAG, "onReceive: ")
        Toast.makeText(context,"Broadcast Reciever activated", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onReceive: Triggered Broadcast receiver")
    }
}
