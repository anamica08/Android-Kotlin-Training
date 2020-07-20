package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var data = intent.extras

        var name = data!!.get("username")
        var password = data.get("password")

        Snackbar.make(findViewById(android.R.id.content),"Username: $name , Password: $password",Snackbar.LENGTH_LONG).show()

        //reply back to the activity that sent the intent
        reply_back.setOnClickListener{
            var returnIntent = this.intent
            returnIntent.putExtra("message","You are succesfully Logged In.")
            setResult(Activity.RESULT_OK,returnIntent)
            finish()
        }


    }
}