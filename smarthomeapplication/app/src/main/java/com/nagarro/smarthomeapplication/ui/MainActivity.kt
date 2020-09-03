package com.nagarro.smarthomeapplication.ui

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.nagarro.smarthomeapplication.R
import com.nagarro.smarthomeapplication.constants.Constants
import com.nagarro.smarthomeapplication.utils.JSONReader
import com.nagarro.smarthomeapplication.utils.JsonParser
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    @Inject
    lateinit var jsonReader: JSONReader

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            jsonReader.getLiveStatusOfAppliance(Constants.APPLIANCE_CATEGORY_AC)
//        Log.d(TAG, "onCreate: ${jsonReader.getJsonDataFromAsset("appliancedetails.json")}")
        val navController = Navigation.findNavController(this,R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this,navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this,R.id.fragment),null
        )
    }
}