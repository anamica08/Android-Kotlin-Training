package com.nagarro.smarthomeapplication.db

import androidx.room.TypeConverter
import com.nagarro.smarthomeapplication.enums.AC_Mode
import com.nagarro.smarthomeapplication.enums.Power_Status

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

    }




