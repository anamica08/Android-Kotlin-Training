package com.example.buttonapp

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContents"

class MainActivity : AppCompatActivity() {

    private var numTimes = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate()")
        super.onCreate(savedInstanceState)

        //got to layout folder and find activity_main file .
        setContentView(R.layout.activity_main)
        val userInput: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)
        val textView: TextView = findViewById(R.id.textView)

        textView.text = ""
        textView.movementMethod = ScrollingMovementMethod()



        button.setOnClickListener(object : View.OnClickListener {

            override fun onClick(p0: View?) {
                Log.d(TAG, "onClick()")
//                numTimes += 1
//                textView?.append("Clicked for the $numTimes time")
//                if(numTimes != 1){
//                    textView?.append("s.\n")
//                }else{
//                    textView?.append("\n")
//                }
                val input = userInput.text.toString()
                if (input.isBlank()) {
                    textView.append("Nothing Entered\n")
                } else {
                    textView.append("You have entered $input in the above textbox.\n**********************************\n")
                    userInput.text.clear()
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart()")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //storing state data
        outState.putString(TEXT_CONTENTS,textView.text.toString())
        Log.d(TAG, "onSaveInstanceState()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop()")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        //retreiving it back
        val savedString = savedInstanceState.getString(TEXT_CONTENTS,"")
        textView.text = savedString
        Log.d(TAG, "onRestoreInstanceState()")
    }
}