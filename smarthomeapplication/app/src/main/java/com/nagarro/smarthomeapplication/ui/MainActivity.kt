package com.nagarro.smarthomeapplication.ui

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.nagarro.smarthomeapplication.R
import com.nagarro.smarthomeapplication.data.Light
import com.nagarro.smarthomeapplication.data.Refrigerator
import com.nagarro.smarthomeapplication.data.WashingMachine
import com.nagarro.smarthomeapplication.db.repo.LightRepository
import com.nagarro.smarthomeapplication.db.repo.RefrigeratorRepository
import com.nagarro.smarthomeapplication.db.repo.WashingMachineRepository
import com.nagarro.smarthomeapplication.enums.Power_Status
import com.nagarro.smarthomeapplication.enums.WashingProgram_Mode
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.sql.Ref
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navController = Navigation.findNavController(this, R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.fragment), null
        )
    }
}