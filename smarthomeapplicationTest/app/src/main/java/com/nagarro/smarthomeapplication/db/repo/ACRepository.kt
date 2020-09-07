package com.nagarro.smarthomeapplication.db.repo

import androidx.lifecycle.LiveData
import com.nagarro.smarthomeapplication.data.AC
import com.nagarro.smarthomeapplication.db.dao.ACDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ACRepository @Inject constructor(private val acDao: ACDao) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    fun addAc(appliance: AC) {
        launch {
            insertACToDB(appliance)
        }

    }

    fun getListofAcs(): LiveData<List<AC>> {
        return acDao.getAllAcs()
    }

    private suspend fun insertACToDB(appliance: AC) {
        withContext(Dispatchers.IO) {
            acDao.addAppliance(appliance)
        }
    }


}

