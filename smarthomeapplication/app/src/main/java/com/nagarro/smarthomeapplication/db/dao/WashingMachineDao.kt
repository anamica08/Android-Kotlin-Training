package com.nagarro.smarthomeapplication.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nagarro.smarthomeapplication.data.Light
import com.nagarro.smarthomeapplication.data.WashingMachine

@Dao
interface WashingMachineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addApplianceWashingMachine(washingMachine: WashingMachine)

    @Query("SELECT * FROM WashingMachine")
    fun getAllWashingMachines(): LiveData<List<WashingMachine>>
}