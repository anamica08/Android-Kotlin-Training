package com.nagarro.smarthomeapplication.db


import android.util.Log
import androidx.lifecycle.LiveData
import com.nagarro.smarthomeapplication.model.Appliance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

private const val TAG = "ApplianceRepository"

class ApplianceRepository @Inject constructor(private val applianceDao: ApplianceDao) :
    CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    fun insertApplianceData(appliance: Appliance) {
        launch {
            addAppliance(appliance)
        }

    }

    suspend fun getCount(): Int {
        val count: Int
        withContext(Dispatchers.IO) {
            count = applianceDao.getCount()
            Log.d(TAG, "getCount: ${applianceDao.getCount()}")
        }
        return count
    }


    fun fetchAppliance(category: String): LiveData<List<Appliance>> {
//        val list:List<Appliance>
//        withContext(Dispatchers.IO) {
//            list = applianceDao.loadAllAppliancesByCategory(category)
//            Log.d(TAG, "getCount: ${applianceDao.getCount()}")
//        }
//        return  list
        return applianceDao.loadAllAppliancesByCategory(category)
    }



private suspend fun addAppliance(appliance: Appliance) {
    withContext(Dispatchers.IO) {
        applianceDao.addAppliance(appliance)
    }
}
}