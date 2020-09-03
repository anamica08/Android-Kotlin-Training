package com.nagarro.smarthomeapplication.db


import androidx.lifecycle.LiveData
import com.nagarro.smarthomeapplication.data.Appliance
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

    fun fetchAppliance(category: String): LiveData<List<Appliance>> {
        return applianceDao.loadAllAppliancesByCategory(category)
    }



private suspend fun addAppliance(appliance: Appliance) {
    withContext(Dispatchers.IO) {
        applianceDao.addAppliance(appliance)
    }
}
}