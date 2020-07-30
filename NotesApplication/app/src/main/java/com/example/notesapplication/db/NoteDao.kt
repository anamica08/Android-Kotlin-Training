package com.example.notesapplication.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note:Note)


    //note here is the table name same as the entity name
    @Query("SELECT * FROM note")
    suspend fun getAllNotes():List<Note>

    @Insert
    suspend fun addMultipleNotes(vararg note:Note)

    /***
     * suspend functions can only be called from coroutine scope
     */

}