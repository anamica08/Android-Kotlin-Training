package com.nagarro.smarthomeapplication.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.nagarro.smarthomeapplication.data.AC
import com.nagarro.smarthomeapplication.data.Light
import com.nagarro.smarthomeapplication.data.Refrigerator
import com.nagarro.smarthomeapplication.data.WashingMachine

import com.nagarro.smarthomeapplication.db.repo.ACRepository
import com.nagarro.smarthomeapplication.db.repo.LightRepository
import com.nagarro.smarthomeapplication.db.repo.RefrigeratorRepository
import com.nagarro.smarthomeapplication.db.repo.WashingMachineRepository

class ApplianceViewModel @ViewModelInject constructor(
    private val acRepo: ACRepository,
    private val refRepo: RefrigeratorRepository,
    private val lightRepo: LightRepository,
    private val wmRepo: WashingMachineRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(), LifecycleObserver {

    fun getListOfAllAcs(): LiveData<List<AC>> {
        return acRepo.getListofAcs()
    }
    fun getListOfAllRefrigerators(): LiveData<List<Refrigerator>> {
        return refRepo.getListofRefrigerators()
    }
    fun getListOfAllWashingMachines(): LiveData<List<WashingMachine>> {
        return wmRepo.getListofWashingMachines()
    }
    fun getListOfAllLights(): LiveData<List<Light>> {
        return lightRepo.getListofLights()
    }

}