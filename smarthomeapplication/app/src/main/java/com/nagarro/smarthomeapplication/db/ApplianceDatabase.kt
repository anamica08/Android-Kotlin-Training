package com.nagarro.smarthomeapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nagarro.smarthomeapplication.model.Appliance

@Database(
    entities = [Appliance::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ApplianceDatabase() : RoomDatabase() {
    /**
     * Connects database to DAO
     */
    abstract val applianceDao: ApplianceDao

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