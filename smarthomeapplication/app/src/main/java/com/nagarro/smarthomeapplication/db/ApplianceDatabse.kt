package com.nagarro.smarthomeapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nagarro.smarthomeapplication.data.*
import com.nagarro.smarthomeapplication.db.dao.ACDao
import com.nagarro.smarthomeapplication.db.dao.LightDao
import com.nagarro.smarthomeapplication.db.dao.RefrigeratorDao
import com.nagarro.smarthomeapplication.db.dao.WashingMachineDao

@Database(
    entities = [Appliance::class,AC::class, Light::class,Refrigerator::class,WashingMachine::class],
    version = 4,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ApplianceDatabase() : RoomDatabase() {
    /**
     * Connects database to DAO
     */
    abstract val acDao: ACDao
    abstract val refrigeratorDao:RefrigeratorDao
    abstract val lightDao:LightDao
    abstract val wmDao:WashingMachineDao



    //build room database
    companion object {
        @Volatile
        private var INSTANCE: ApplianceDatabase? = null
        //volatile will make this instance available for all the other threads immediately.

        fun getInstance(context: Context):ApplianceDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ApplianceDatabase::class.java,
                        "appliancesdb"

                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}