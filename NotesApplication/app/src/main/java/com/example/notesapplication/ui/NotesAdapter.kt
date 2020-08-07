package com.example.notesapplication.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapplication.R
import com.example.notesapplication.db.Note
import kotlinx.android.synthetic.main.list_item.view.*

class NotesAdapter(val notes: List<Note>?): RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
    private val TAG = "NotesAdapter"
    class NoteViewHolder(val view:View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return if (notes != null) notes.size else throw NullPointerException("Expression 'notes' must not be null")
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.view.tv_title.text = notes!![position].title
        holder.view.tv_note.text = notes[position].note

        holder.view.delete_actionbutton.setOnClickListener {
            //delete the note from database
            //HomeFragment().openDialog()

            val action = HomeFragmentDirections.deleteNoteAction(notes[position])
            Navigation.findNavController(it).navigate(action)
        }

        holder.view.setOnClickListener{
            Log.d(TAG, "onBindViewHolder: List item clicked")
            val action = HomeFragmentDirections.actionAddNote()
            action.note = notes[position]
            Navigation.findNavController(it).navigate(action)
        }
    }
}