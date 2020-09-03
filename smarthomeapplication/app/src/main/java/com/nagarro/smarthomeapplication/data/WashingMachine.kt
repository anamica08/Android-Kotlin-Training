package com.nagarro.smarthomeapplication.data

import com.nagarro.smarthomeapplication.constants.Constants
import com.nagarro.smarthomeapplication.enums.Power_Status
import com.nagarro.smarthomeapplication.enums.WashingProgram_Mode
import com.nagarro.smarthomeapplication.utils.Timer
import javax.inject.Inject
import kotlin.concurrent.fixedRateTimer

class WashingMachine(
    appliance_name: String, location: String,
    average_consumption_per_hour: Double
) : Appliance(
    appliance_name, location, average_consumption_per_hour,
    category = Constants.APPLIANCE_CATEGORY_WASHINGMACHINE
) {
    //dependency
    @Inject
    lateinit var timerService: Timer

    var power_status: Power_Status = Power_Status.OFF
        private set(value) {
            field = value
        }

    var programMode: WashingProgram_Mode = WashingProgram_Mode.AUTO_OPTIMAL_WASH
        private set(value) {
            field = value
        }


    //this will show the time left in finishing washing.
    var timer: Int = 0
        private set(value) {
            field = value
        }


    var washing: Power_Status = Power_Status.OFF
        private set(value) {
            field = value
        }


    /*it will keep on decreasing timer
    ** and will stop only when washing is set to OFF
    **or machine is power off
     */
    fun updateTimer(machine: WashingMachine) {
        if (machine.washing == Power_Status.ON) {
            //machine is started for the first time.
            if (machine.timer == 0) {
                //set a timer of x minutes on the basis of program selected.
                machine.timer = timerService.getTimer(this.programMode)
            }
            //else fetch the current timer and decrease it with time.
            val fixedRateTimer = fixedRateTimer(
                name = "washing-timer",
                initialDelay = 2000, period = 60000
            ) {
                if(machine.power_status == Power_Status.OFF || machine.washing == Power_Status.OFF){
                    //stop timer
                    Thread.currentThread().suspend() // this is deprecated
                    //?? How to Stop timer here.??
                }
                --machine.timer
            }
            try {
                Thread.sleep(1000)
            } finally {
                fixedRateTimer.cancel();
            }

        } else
            throw error("Selected Program has not been started.")
    }


    fun setWashingMode(mode:WashingProgram_Mode){
        // washing program mode can only be selected if power is on and washing isnot in process.
        if(washing == Power_Status.OFF && power_status == Power_Status.ON)
            programMode = mode

    }

    fun updateWashingStatus(status:Power_Status){
        if(power_status == Power_Status.ON)
            washing = status
    }

    override fun toString(): String {
        return "ac(Power: ${power_status.name}," +
                "Name: $appliance_name.," +
                "Location: $location," +
                " Average_Consumption: $average_consumption_per_hour," +
                "Washing: ${washing.name}," +
                "Timer: $timer,"+
                "Program: $programMode"
    }

}