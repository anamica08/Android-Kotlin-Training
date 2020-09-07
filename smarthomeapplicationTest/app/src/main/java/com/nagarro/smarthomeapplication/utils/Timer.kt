package com.nagarro.smarthomeapplication.utils

import com.nagarro.smarthomeapplication.enums.WashingProgram_Mode
import javax.inject.Inject

//This class is responsible for updating and setting timer for the various modes of washing machine.
class Timer @Inject constructor() {

    fun getTimer(program:WashingProgram_Mode):Int{
        when(program){
            WashingProgram_Mode.AUTO_OPTIMAL_WASH -> return 50
            WashingProgram_Mode.COTTON_DRY -> return 30
            WashingProgram_Mode.DAILY_WASH -> return 60
            WashingProgram_Mode.QUICK_WASH -> return 30
            WashingProgram_Mode.RINSEandSPIN -> return 40
            WashingProgram_Mode.SUPER_ECO_WASH -> return 50
            WashingProgram_Mode.WARM_WASH -> return 40
            WashingProgram_Mode.WOOLEN -> return 60
        }
    }





}