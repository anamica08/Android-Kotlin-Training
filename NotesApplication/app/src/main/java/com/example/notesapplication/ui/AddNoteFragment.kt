package com.example.notesapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.notesapplication.BaseFragment
import com.example.notesapplication.R
import com.example.notesapplication.db.Note
import com.example.notesapplication.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.coroutines.launch


class AddNoteFragment : BaseFragment() {
    private val TAG = "AddNoteFragment"
    private var argNote:Note? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //obtain the argument passed by homescreen
        if(arguments == null  ){
            arguments?.let {
                argNote = AddNoteFragmentArgs.fromBundle(it).note
                editTextNote.setText(argNote!!.note)
                editTextTitle.setText(argNote!!.title)
            }
        }



        //attach click listener
        button_save.setOnClickListener {view ->
            val title = editTextTitle.text.toString()
            val note = editTextNote.text.toString()

            //validation
            if (title.isEmpty()) {
                editTextTitle.error = "Title Required"
                editTextTitle.requestFocus()
                return@setOnClickListener
            }
            if (note.isEmpty()) {
                editTextNote.error = "Note Required"
                editTextNote.requestFocus()
                return@setOnClickListener
            }

            launch {
                Log.d(TAG, "onActivityCreated: $context")
                context?.let {
                    val noteToAdd = Note(title, note)
                    if(argNote == null){
                        NoteDatabase(it).getNoteDao().addNote(noteToAdd)
                        Toast.makeText(it,"Note Added",Toast.LENGTH_SHORT).show()
                    }else{
                        noteToAdd.id = argNote!!.id
                        NoteDatabase(it).getNoteDao().updateNote(noteToAdd)
                        Toast.makeText(it,"Note Updated",Toast.LENGTH_SHORT).show()
                    }


                    val action = AddNoteFragmentDirections.actionSaveNote()
                    Navigation.findNavController(view).navigate(action)
                }
            }


        }

        //NoteDatabase(requireActivity()).getNoteDao()
    }

    /***
     * Now we will use Kotlin coroutines to replace this asynctask
     */
//    private fun saveNote(note: Note) {
//        class AddToDB : AsyncTask<Void, Void, Void>() {
//            override fun doInBackground(vararg p0: Void?): Void? {
//                NoteDatabase(activity!!).getNoteDao().addNote(note)
//                return null
//            }
//
//            override fun onPostExecute(result: Void?) {
//                super.onPostExecute(result)
//                Toast.makeText(activity,"Note Added",Toast.LENGTH_SHORT).show()
//            }
//
//
//        }
//
//        AddToDB().execute()
//    }
}