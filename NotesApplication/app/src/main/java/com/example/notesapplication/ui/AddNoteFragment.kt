package com.example.notesapplication.ui

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.loader.content.AsyncTaskLoader
import com.example.notesapplication.R
import com.example.notesapplication.db.Note
import com.example.notesapplication.db.NoteDatabase
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_add_note.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddNoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddNoteFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //attach click listener
        button_save.setOnClickListener {
            val title = editTextTitle.text.toString()
            val note = editTextNote.text.toString()

            //validation
            if (title.isEmpty()) {
                editTextTitle.error = "Title Required"
                editTextTitle.requestFocus()
                return@setOnClickListener
            }
            if (title.isEmpty()) {
                editTextNote.error = "Title Required"
                editTextNote.requestFocus()
                return@setOnClickListener
            }

            val noteToAdd = Note(title, note)
            saveNote(noteToAdd)

        }

        //NoteDatabase(requireActivity()).getNoteDao()
    }

    private fun saveNote(note: Note) {
        class AddToDB : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg p0: Void?): Void? {
                NoteDatabase(activity!!).getNoteDao().addNote(note)
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                Toast.makeText(activity,"Note Added",Toast.LENGTH_SHORT).show()
            }


        }

        AddToDB().execute()
    }
}