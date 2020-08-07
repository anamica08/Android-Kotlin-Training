package com.example.notesapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.notesapplication.R
import com.example.notesapplication.db.Note
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private val TAG = "HomeFragment"

    //we have created a view model factory class which will provide me an instance of view model with parameter.
    //by default it only creates a instace with no parameter
    private val model:NoteViewModel by viewModels{NoteViewModelFactory(requireActivity().application)}


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

        //adding notes
        model.getNotes()?.observe(viewLifecycleOwner,Observer<List<Note>>{
            recyclerView.adapter = activity?.applicationContext?.let { it1 -> NotesAdapter(it) }
        })

        //deleting notes




        button_add.setOnClickListener {
            val action = HomeFragmentDirections.actionAddNote()
            action.note = null
            Navigation.findNavController(it).navigate(action)
        }

//        launch {
//            context?.let {
//                val noteList = NoteDatabase(it).getNoteDao().getAllNotes()
//                Log.d(TAG, "onActivityCreated: notes_fetched : $noteList")
//               // recyclerView.adapter = NotesAdapter(noteList)
//            }
//        }

    }

//    fun openDialog() {
//      //  Log.d(TAG, "openDialog: $activity")
//        context?.let {
//            AlertDialog.Builder(it).apply {
//                setTitle("Are you sure?")
//                setMessage("You cannot undo this operation.")
//                setPositiveButton("Yes"){_,_ ->
//                    //Toast.makeText(this.context,"clicked",Toast.LENGTH_SHORT).show()
//                }
//            }.create().show()
//        }
//
//    }

}