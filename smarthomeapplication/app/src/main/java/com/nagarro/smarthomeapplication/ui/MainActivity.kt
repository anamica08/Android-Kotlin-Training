package com.nagarro.smarthomeapplication.ui

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.nagarro.smarthomeapplication.R
import com.nagarro.smarthomeapplication.data.AC
import com.nagarro.smarthomeapplication.data.Light
import com.nagarro.smarthomeapplication.data.Refrigerator
import com.nagarro.smarthomeapplication.data.WashingMachine
import com.nagarro.smarthomeapplication.db.repo.ACRepository
import com.nagarro.smarthomeapplication.db.repo.LightRepository
import com.nagarro.smarthomeapplication.db.repo.RefrigeratorRepository
import com.nagarro.smarthomeapplication.db.repo.WashingMachineRepository
import com.nagarro.smarthomeapplication.enums.AC_Mode
import com.nagarro.smarthomeapplication.enums.FanSpeed
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
    @Inject
    lateinit var dbRepository: RefrigeratorRepository
    @Inject
    lateinit var dbRepository1: LightRepository
    @Inject
    lateinit var dbRepository2: WashingMachineRepository
    @Inject
    lateinit var dbRepository3:ACRepository



    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportActionBar?.hide()

        setContentView(R.layout.activity_main)
//        dbRepository3.addAc(
//            AC("Whirlpool_splitAir","Hall Ground Floor",3.5,
//
//                Power_Status.ON,18, AC_Mode.COOL, FanSpeed.MEDIUM))
//        dbRepository3.addAc(AC("Voltas_WindowAC","First Floor Room1",3.0,
//            Power_Status.OFF,23, AC_Mode.COOL, FanSpeed.HIGH))
//        dbRepository2.addWashingMachine(WashingMachine("Whirlpool frontLoadWM","Bathroom Ground Floor",3.0,Power_Status.OFF,WashingProgram_Mode.SUPER_ECO_WASH,Power_Status.OFF,0))
//        dbRepository1.addlight(Light("Lamp 1","Hall [Ground Floor]",1.5,Power_Status.ON,5))
//        dbRepository1.addlight(Light("SyskaLED","Room1 [First Floor]",0.9,Power_Status.OFF))
//        dbRepository1.addlight(Light("Philips brighto","Passage-Area [Ground Floor]",2.0,Power_Status.ON,10))
//        dbRepository.addRefrigerator(Refrigerator("Whirlpool Doubledoor","Kitchen",2.0,Power_Status.ON,0,18))
//        dbRepository.addRefrigerator(Refrigerator("Godrej minifridge","room1 FirstFloor",1.8,Power_Status.ON,-2,20))


        val navController = Navigation.findNavController(this, R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.fragment), null
        )
    }
}