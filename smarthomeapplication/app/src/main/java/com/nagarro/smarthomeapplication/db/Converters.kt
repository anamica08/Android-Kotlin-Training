package com.nagarro.smarthomeapplication.db

import androidx.room.TypeConverter
import com.nagarro.smarthomeapplication.enums.AC_Mode
import com.nagarro.smarthomeapplication.enums.FanSpeed
import com.nagarro.smarthomeapplication.enums.Power_Status
import com.nagarro.smarthomeapplication.enums.WashingProgram_Mode

class Converters {
    @TypeConverter
    fun toPowerStatus(value:String?): Power_Status? {
        return value?.let { Power_Status.valueOf(it) }
    }

    @TypeConverter
    fun fromPower_Status(value:Power_Status): String? {
        return value.name
    }
    @TypeConverter
    fun toAC_Mode(value:String?): AC_Mode? {
        return value?.let { AC_Mode.valueOf(it) }
    }

    @TypeConverter
    fun fromAC_Mode(value:AC_Mode): String? {
        return value.name
    }

    @TypeConverter
    fun toFanSpeed(value:String?): FanSpeed? {
        return value?.let { FanSpeed.valueOf(it) }
    }

    @TypeConverter
    fun fromFanSpeed(value:FanSpeed): String? {
        return value.name
    }
    @TypeConverter
    fun toWashingProgramMode(value:String?): WashingProgram_Mode? {
        return value?.let { WashingProgram_Mode.valueOf(it) }
    }

    @TypeConverter
    fun fromWashingProgramMode(value:WashingProgram_Mode): String? {
        return value.name
    }

    }




