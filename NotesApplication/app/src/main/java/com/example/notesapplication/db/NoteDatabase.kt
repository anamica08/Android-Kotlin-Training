package com.example.notesapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class],
    version = 1
)

//functions to get dao
abstract class NoteDatabase: RoomDatabase() {
    //here only 1 dao so
    abstract fun getNoteDao():NoteDao
    //above fun will give us a dao and with dao we get entity and with entity we do CRUD

    //build room database
    companion object{
        @Volatile private var instance : NoteDatabase? = null
        //volatile will make this instance available for all the other threads immediately.

        private val LOCK = Any()
        //this will check if the instance is null and if it is not null it will immediately return instance.
        //but if instance is null we will wite a synchronized block
        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            "notesdb"
        ).build()
    }
}