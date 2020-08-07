package com.example.notesapplication.db

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class NoteRepository(application: Application) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var noteDao: NoteDao? = null

    init {
        val db = NoteDatabase.invoke(application)
        noteDao = db.getNoteDao()
    }

    fun getAllNotes(): LiveData<List<Note>>? {
         return   noteDao?.getAllNotes()
    }

    fun addNote(vararg notes:Note) {
        launch {
            addMultipleNote(*notes)
        }
    }

    fun updateThisNote(note: Note) {
        launch {
            updateNote(note)
        }
    }

    fun deleteThisNote(note:Note){
        launch {
            deleteNote(note)
        }
    }

    private suspend fun addMultipleNote(vararg note: Note) {
        withContext(Dispatchers.IO) {
            noteDao?.addMultipleNotes(*note)
            Log.d("Thread add",Thread.currentThread().name)
        }
    }

    private suspend fun updateNote(note:Note){
        withContext(Dispatchers.IO) {
            noteDao?.updateNote(note)
            Log.d("Thread update",Thread.currentThread().name)
        }
    }
    private suspend fun deleteNote(note:Note){
        withContext(Dispatchers.IO) {
            noteDao?.deleteNote(note)
            Log.d("Thread delete",Thread.currentThread().name)
        }
    }

}