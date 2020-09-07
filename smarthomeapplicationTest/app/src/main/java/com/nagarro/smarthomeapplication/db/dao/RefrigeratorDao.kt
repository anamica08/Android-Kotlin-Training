package com.nagarro.smarthomeapplication.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nagarro.smarthomeapplication.data.Light
import com.nagarro.smarthomeapplication.data.Refrigerator


@Dao
interface RefrigeratorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addApplianceRefrigerator(refrigerator: Refrigerator)

    @Query("SELECT * FROM Refrigerator")
    fun getAllRefrigerators(): LiveData<List<Refrigerator>>
}