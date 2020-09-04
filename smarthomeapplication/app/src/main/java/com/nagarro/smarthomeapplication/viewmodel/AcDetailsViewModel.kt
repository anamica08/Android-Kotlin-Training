package com.nagarro.smarthomeapplication.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.nagarro.smarthomeapplication.data.AC
import com.nagarro.smarthomeapplication.db.repo.ACRepository
import com.nagarro.smarthomeapplication.db.repo.LightRepository
import com.nagarro.smarthomeapplication.db.repo.RefrigeratorRepository
import com.nagarro.smarthomeapplication.db.repo.WashingMachineRepository
import com.nagarro.smarthomeapplication.enums.AC_Mode
import com.nagarro.smarthomeapplication.enums.FanSpeed
import com.nagarro.smarthomeapplication.enums.Power_Status
import javax.inject.Inject

class AcDetailsViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    lateinit var data: AC

    private var speedButtonClickCount = data.fanSpeed.ordinal + 1
    private var modeButtonClickCount = data.mode.ordinal + 1
    private var powerButtonClickCount = data.powerStatus.ordinal + 1

    private var powerStatus = MutableLiveData<String>()
    val livePower_Status: LiveData<String>
        get() {
            return powerStatus
        }
    private var temp = MutableLiveData<Int>()
    val liveTemp: LiveData<Int>
        get() {
            return temp
        }
    private var mode = MutableLiveData<String>()
    val liveMode: LiveData<String>
        get() {
            return mode
        }
    private var fanSpeed = MutableLiveData<String>()
    val liveSpeed: LiveData<String>
        get() {
            return fanSpeed
        }

    init {
        powerStatus.value = data.powerStatus.name
        temp.value = data.operatingTemperature
        mode.value = data.mode.name
        fanSpeed.value = data.fanSpeed.name
    }

    fun changePowerStatus() {
        when (powerButtonClickCount) {
            1 -> {
                powerStatus.value = Power_Status.ON.name
                powerButtonClickCount++ //2
            }
            2 -> {
                powerStatus.value = Power_Status.OFF.name
                powerButtonClickCount = 1
            }
            else -> {
                powerStatus.value = Power_Status.OFF.name
                powerButtonClickCount = 1
            }
        }
    }

    fun changeMode() {
        when (modeButtonClickCount) {
            1 -> {
                mode.value = AC_Mode.FAN.name
                modeButtonClickCount++ //2
            }
            2 -> {
                mode.value = AC_Mode.DRY.name
                modeButtonClickCount++ //3
            }
            3 -> {
                mode.value = AC_Mode.AUTO.name
                modeButtonClickCount++ //4
            }
            4 -> {
                mode.value = AC_Mode.TURBO.name
                modeButtonClickCount++ //5
            }
            5 -> {
                mode.value = AC_Mode.COOL.name
                modeButtonClickCount = 1
            }
            else -> {
                mode.value = AC_Mode.COOL.name
                modeButtonClickCount = 1
            }
        }
    }

    fun changeFanSpeed() {
        when (speedButtonClickCount) {
            1 -> {
                fanSpeed.value = FanSpeed.MEDIUM.name
                speedButtonClickCount++ //2
            }
            2 -> {
                fanSpeed.value = FanSpeed.HIGH.name
                speedButtonClickCount++ //3
            }
            3 -> {
                fanSpeed.value = FanSpeed.LOW.name
                speedButtonClickCount = 1
            }
            else -> {
                fanSpeed.value = FanSpeed.LOW.name
                speedButtonClickCount = 1
            }
        }
    }
}