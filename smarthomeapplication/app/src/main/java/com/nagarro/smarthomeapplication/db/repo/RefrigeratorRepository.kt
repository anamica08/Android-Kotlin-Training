package com.nagarro.smarthomeapplication.db.repo

import androidx.lifecycle.LiveData
import com.nagarro.smarthomeapplication.data.Light
import com.nagarro.smarthomeapplication.data.Refrigerator
import com.nagarro.smarthomeapplication.db.dao.LightDao
import com.nagarro.smarthomeapplication.db.dao.RefrigeratorDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class RefrigeratorRepository @Inject constructor(private val refrigeratorDao: RefrigeratorDao) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    fun addRefrigerator(appliance: Refrigerator) {
        launch {
            insertRefrigeratorToDB(appliance)
        }

    }

    fun getListofRefrigerators(): LiveData<List<Refrigerator>> {
        return refrigeratorDao.getAllRefrigerators()
    }


    private suspend fun insertRefrigeratorToDB(appliance: Refrigerator) {
        withContext(Dispatchers.IO) {
            refrigeratorDao.addApplianceRefrigerator(appliance)
        }
    }
}


