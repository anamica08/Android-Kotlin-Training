package com.nagarro.smarthomeapplication.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nagarro.smarthomeapplication.data.Appliance

@Dao
interface ApplianceDao {

    @Query("SELECT * from appliancedata where category = :category ")
    fun loadAllAppliancesByCategory(category:String):LiveData<List<Appliance>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAppliance(appliance: Appliance)

    @Query("SELECT COUNT(appliance_name) FROM appliancedata ")
    fun getCount():Int
}