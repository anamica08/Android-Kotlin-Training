package com.nagarro.smarthomeapplication.dataholders

import com.nagarro.smarthomeapplication.data.AC
import javax.inject.Inject

class AcObjectHolder @Inject constructor() {

    private var  acArgument: AC? = null

    fun getArgument(): AC? {
        return acArgument
    }

    fun setArgument(value:AC){
        acArgument = value

    }
}