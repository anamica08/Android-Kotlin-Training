package com.example.broadcastreceiverdemo

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val receiver: MyReceiver = MyReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filter = IntentFilter()
        filter.addAction("android.provider.Telephony.SMS_RECEIVED")
        filter.addCategory(Intent.CATEGORY_DEFAULT)
        registerReceiver(receiver, filter)
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter()
        filter.addAction("android.provider.Telephony.SMS_RECEIVED")
        filter.addCategory(Intent.CATEGORY_DEFAULT)
        //val receiver: MyReceiver = MyReceiver()
        registerReceiver(receiver, filter)
    }

    override fun onPause() {
        super.onPause()
//        val filter = IntentFilter()
//        filter.addAction("android.provider.Telephony.SMS_RECEIVED")
//        filter.addCategory(Intent.CATEGORY_DEFAULT)
//       // val receiver: MyReceiver = MyReceiver()
//        registerReceiver(receiver, filter)
    }
}