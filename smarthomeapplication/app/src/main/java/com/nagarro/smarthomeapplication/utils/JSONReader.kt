package com.nagarro.smarthomeapplication.utils

import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nagarro.smarthomeapplication.constants.Constants
import com.nagarro.smarthomeapplication.sensordata.ACData
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.FileNotFoundException
import java.io.IOException
import javax.inject.Inject

private const val TAG = "JSONReader"

class JSONReader @Inject constructor(@ApplicationContext val context: Context,private val jsonParser: JsonParser) {


     private fun getJsonDataFromAsset(fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        Log.d(TAG, "getJsonDataFromAsset: $jsonString")
        return jsonString
    }



    fun getLiveStatusOfAppliance(category: String){
        when(category) {
            Constants.APPLIANCE_CATEGORY_AC -> {
                val jsonFileString = getJsonDataFromAsset(Constants.AC_STATUS_FILE)
                Log.d(TAG, "getLiveStatusOfAppliance: $jsonFileString")
                if (jsonFileString != null) {
                    jsonParser.parseACJsonToKotlinObject(
                        Constants.APPLIANCE_CATEGORY_AC,
                        jsonFileString
                    )
                } else {
                    throw FileNotFoundException("Data File not found")
                }
            }
//            Constants.APPLIANCE_CATEGORY_LIGHT -> parseJsonToKotlinObject(Constants.APPLIANCE_CATEGORY_LIGHT)
//            Constants.APPLIANCE_CATEGORY_WASHINGMACHINE-> parseJsonToKotlinObject(Constants.APPLIANCE_CATEGORY_WASHINGMACHINE)
//            Constants.APPLIANCE_CATEGORY_REFRIGERATOR -> parseJsonToKotlinObject(Constants.APPLIANCE_CATEGORY_REFRIGERATOR)

        }
    }

}