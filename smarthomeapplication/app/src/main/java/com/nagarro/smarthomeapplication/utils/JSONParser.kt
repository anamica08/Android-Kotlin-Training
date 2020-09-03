package com.nagarro.smarthomeapplication.utils

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nagarro.smarthomeapplication.constants.Constants
import com.nagarro.smarthomeapplication.sensordata.ACData
import javax.inject.Inject

private const val TAG = "JsonParser"
class JsonParser @Inject constructor(){

     fun parseACJsonToKotlinObject(category:String,jsonString:String): List<ACData> {
                Log.d(TAG, "parseJsonToKotlinObject: $jsonString")
                val listAcType = object : TypeToken<List<ACData>>() {}.type
                var listOfACData: List<ACData> = listOf()
                    listOfACData = Gson().fromJson(jsonString, listAcType)
                listOfACData.forEachIndexed { index, acData ->
                    Log.i(
                        TAG,
                        "parseJsonToKotlinObject: ${index} => ${acData} ${acData.javaClass} is object"
                    )
                }
                return listOfACData
            }
        }

//light
//refrigerator
//washingmachine

