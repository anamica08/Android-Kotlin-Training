package com.nagarro.smarthomeapplication.db.repo

import androidx.lifecycle.LiveData
import com.nagarro.smarthomeapplication.data.AC
import com.nagarro.smarthomeapplication.data.Light
import com.nagarro.smarthomeapplication.db.dao.ACDao
import com.nagarro.smarthomeapplication.db.dao.LightDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class LightRepository @Inject constructor(private val lightDao: LightDao) : CoroutineScope {
        override val coroutineContext: CoroutineContext
            get() = Dispatchers.Main

        fun addlight(appliance: Light) {
            launch {
                insertLightToDB(appliance)
            }

        }
        fun getListofLights(): LiveData<List<Light>> {
            return lightDao.getAllLights()
        }
//    suspend fun fetchListofACs(): LiveData<List<AC>> {
//        var list: List<AC> = mutableListOf()
//        withContext(Dispatchers.IO) {
//            list = acDao.getAllAcs()
//        }
//        return list
//    }

        private suspend fun insertLightToDB(appliance: Light) {
            withContext(Dispatchers.IO) {
                lightDao.addApplianceLight(appliance)
            }
        }



}