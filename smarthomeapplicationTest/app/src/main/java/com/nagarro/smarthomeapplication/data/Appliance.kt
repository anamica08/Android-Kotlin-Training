package com.nagarro.smarthomeapplication.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity
open class Appliance(

    @PrimaryKey
     var appliance_name: String,
    var location: String,
     var average_consumption_per_hour: Double,
     var category:String
)  {
    override fun toString(): String {
        return "[$appliance_name,$location,$average_consumption_per_hour]"
    }
}
