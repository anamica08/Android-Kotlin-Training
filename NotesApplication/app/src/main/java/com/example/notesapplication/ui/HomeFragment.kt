package com.example.notesapplication.ui

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.notesapplication.BaseFragment
import com.example.notesapplication.R
import com.example.notesapplication.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment() {
    private val TAG = "HomeFragment"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Custom back button behaviour
         */
        requireActivity().onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.moveTaskToBack(true)
                activity?.finish();
            }
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)



        launch {
            context?.let {
                val noteList = NoteDatabase(it).getNoteDao().getAllNotes()
                Log.d(TAG, "onActivityCreated: notes_fetched : $noteList")
                recyclerView.adapter = NotesAdapter(noteList)
            }
        }
        button_add.setOnClickListener {
            val action = HomeFragmentDirections.actionAddNote()
            action.note = null
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun openDialog() {
      //  Log.d(TAG, "openDialog: $activity")
        context?.let {
            AlertDialog.Builder(it).apply {
                setTitle("Are you sure?")
                setMessage("You cannot undo this operation.")
                setPositiveButton("Yes"){_,_ ->
                    //Toast.makeText(this.context,"clicked",Toast.LENGTH_SHORT).show()
                }
            }.create().show()
        }

    }

}