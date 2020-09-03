package com.nagarro.smarthomeapplication.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nagarro.smarthomeapplication.data.AC
import com.nagarro.smarthomeapplication.data.Light


@Dao
interface LightDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addApplianceLight(light: Light)

    @Query("SELECT * FROM Light")
    fun getAllLights(): LiveData<List<Light>>
}