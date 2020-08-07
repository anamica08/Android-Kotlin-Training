package com.example.notesapplication.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notesapplication.db.Note

class NoteViewModel : ViewModel() {
    private val TAG = "NoteViewModel"

    private var noteToDelete = MutableLiveData<Note>()
    val note: LiveData<Note>
        get() = noteToDelete



    fun setValue (note:Note){
        noteToDelete.value = note
        Log.d(TAG, "setValue: Updated Note to delete ${noteToDelete.value}")
    }


}