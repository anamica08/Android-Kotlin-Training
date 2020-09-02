package com.nagarro.smarthomeapplication.db

import androidx.room.TypeConverter
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
    }




