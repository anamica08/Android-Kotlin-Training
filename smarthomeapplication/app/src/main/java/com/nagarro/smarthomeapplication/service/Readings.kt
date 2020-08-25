package com.nagarro.smarthomeapplication.service//package com.nagarro.smarthomeapplication.service
//
//import android.app.Application
//import android.content.Context
//import android.util.Log
//import com.nagarro.smarthomeapplication.readingdataset.ChartDataSet
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//import javax.inject.Inject
//import kotlin.coroutines.CoroutineContext
//
//private const val TAG = "Readings"
//
//class Readings() : CoroutineScope {
//
//
//    override val coroutineContext: CoroutineContext
//        get() = Dispatchers.Main
//
//    fun getdata(context: Context):String? {
//        var readings: String? = null
//        launch {
//            readings = getReadings(context)
//            Log.d(TAG, "getReadings: $readings")
//
//        }
//        return readings
//    }
//
//
//    private suspend fun getReadings(context: Context): String? {
//        val dataSet =  ChartDataSet()
//        Log.d(TAG, "getReadings: $dataSet")
//        var string: String?
//        withContext(Dispatchers.IO) {
//            string = dataSet.readJSONDataFromAssets(context, "reading.json")
//        }
//        return string
//    }
//}