package com.nagarro.smarthomeapplication.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.github.mikephil.charting.data.PieEntry
import com.nagarro.smarthomeapplication.db.ApplianceRepository
import com.nagarro.smarthomeapplication.model.Appliance

class ApplianceViewModel @ViewModelInject constructor(
    private val repo: ApplianceRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {


    fun getAllAppliance(category: String): LiveData<List<Appliance>> {
         return repo.fetchAppliance(category)

    }

}