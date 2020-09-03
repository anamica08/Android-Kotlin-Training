package com.nagarro.smarthomeapplication.db.repo

import androidx.lifecycle.LiveData
import com.nagarro.smarthomeapplication.data.Refrigerator
import com.nagarro.smarthomeapplication.data.WashingMachine
import com.nagarro.smarthomeapplication.db.dao.RefrigeratorDao
import com.nagarro.smarthomeapplication.db.dao.WashingMachineDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class WashingMachineRepository@Inject constructor(private val washingMachineDao: WashingMachineDao) :
    CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    fun addWashingMachine(appliance: WashingMachine) {
        launch {
            insertWashingMachineToDB(appliance)
        }

    }

    fun getListofWashingMachines(): LiveData<List<WashingMachine>> {
        return washingMachineDao.getAllWashingMachines()
    }


    private suspend fun insertWashingMachineToDB(appliance: WashingMachine) {
        withContext(Dispatchers.IO) {
           washingMachineDao.addApplianceWashingMachine(appliance)
        }
    }
}


