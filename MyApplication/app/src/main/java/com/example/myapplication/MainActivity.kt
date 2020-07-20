package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val REQUEST_CODE = 101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next_button.setOnClickListener {
            var intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("username", username!!.text)
            intent.putExtra("password", password!!.text)

            if (username.text.toString().trim().length == 0 || password.text!!.toString()
                    .trim().length == 0
            ) {
                Snackbar.make(
                    findViewById(android.R.id.content),
                    "Please Fill in All Details",
                    Snackbar.LENGTH_LONG
                )
                    .setAction("Action") {

                    }
                    .show()
            } else {

                //startActivity(intent)
                startActivityForResult(intent, REQUEST_CODE)

            }


        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                username.setText("")
                password.setText("")
                var result = data!!.extras!!.get("message").toString()
                Snackbar.make(
                    findViewById(android.R.id.content),"$result" ,Snackbar.LENGTH_LONG
                ).show()

            }
        }
    }




//    private fun closeKeyBoard() {
//        val view = this.currentFocus
//        if (view != null) {
//            val imm: InputMethodManager =
//                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            imm.hideSoftInputFromWindow(view.windowToken, 0)
//        }
//    }
}