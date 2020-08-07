package com.example.notesapplication.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notesapplication.db.Note
import com.example.notesapplication.db.NoteRepository

class NoteViewModel(application: Application) : ViewModel() {
    private val TAG = "NoteViewModel"

    private var repository:NoteRepository = NoteRepository(application)

    fun getNotes() = repository.getAllNotes()

    fun addNotes(note:Note) = repository.addNote(note)

    fun deleteNote(note:Note) = repository.deleteThisNote(note)

    fun updateNote(note:Note) = repository.updateThisNote(note)

}