package com.nagarro.smarthomeapplication.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nagarro.smarthomeapplication.data.AC


@Dao
interface ACDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAppliance(ac: AC)

    @Query("SELECT * FROM AC")
    fun getAllAcs():LiveData<List<AC>>
}