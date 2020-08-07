package com.example.notesapplication.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note:Note)


    //note here is the table name same as the entity name
    @Query("SELECT * FROM note ORDER BY id DESC")
     fun getAllNotes():LiveData<List<Note>>

    @Insert
     fun addMultipleNotes(vararg note:Note)

    @Update
     fun updateNote(note:Note)

    @Delete
     fun deleteNote(note: Note)

    /***
     * suspend functions can only be called from coroutine scope
     */

}