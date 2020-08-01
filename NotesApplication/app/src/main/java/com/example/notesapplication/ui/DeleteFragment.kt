package com.example.notesapplication.ui

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.notesapplication.BaseFragment
import com.example.notesapplication.R
import com.example.notesapplication.db.Note
import com.example.notesapplication.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_delete.*
import kotlinx.coroutines.launch


class DeleteFragment : BaseFragment() {

    private val TAG = "DeleteFragment"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        arguments?.let {
            val note = DeleteFragmentArgs.fromBundle(it).noteToDelete

            yes.setOnClickListener {
                launch {
                    context?.let { it1 -> NoteDatabase(it1).getNoteDao().deleteNote(note) }
                    Toast.makeText(context, "Note Deleted", Toast.LENGTH_SHORT).show()

                }
                val action = DeleteFragmentDirections.actionDeleteNote()
                view?.let { it1 -> Navigation.findNavController(it1).navigate(action) }
            }
            no.setOnClickListener {
                val action = DeleteFragmentDirections.actionDeleteNote()
                view?.let { it1 -> Navigation.findNavController(it1).navigate(action) }
            }



        }



    }
}
