package com.nagarro.smarthomeapplication.hilt

import android.content.Context
import com.nagarro.smarthomeapplication.data.Refrigerator
import com.nagarro.smarthomeapplication.db.*
import com.nagarro.smarthomeapplication.db.dao.ACDao
import com.nagarro.smarthomeapplication.db.dao.LightDao
import com.nagarro.smarthomeapplication.db.dao.RefrigeratorDao
import com.nagarro.smarthomeapplication.db.dao.WashingMachineDao
import com.nagarro.smarthomeapplication.db.repo.ACRepository
import com.nagarro.smarthomeapplication.db.repo.LightRepository
import com.nagarro.smarthomeapplication.db.repo.RefrigeratorRepository
import com.nagarro.smarthomeapplication.db.repo.WashingMachineRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext


@InstallIn(ApplicationComponent::class)
@Module
object DBModule {

    @Provides
    fun provideACDao(@ApplicationContext applicationContext: Context) : ACDao {
        return ApplianceDatabase.getInstance(applicationContext).acDao
    }

    @Provides
    fun provideACdbRepository(acDao: ACDao) = ACRepository(acDao)

    @Provides
    fun provideRefrigeratorDao(@ApplicationContext applicationContext: Context) : RefrigeratorDao {
        return ApplianceDatabase.getInstance(applicationContext).refrigeratorDao
    }

    @Provides
    fun provideRefrigeratordbRepository(refrigeratorDao:RefrigeratorDao) = RefrigeratorRepository(refrigeratorDao)

    @Provides
    fun provideWashingMachineDao(@ApplicationContext applicationContext: Context) : WashingMachineDao {
        return ApplianceDatabase.getInstance(applicationContext).wmDao
    }

    @Provides
    fun provideWashingMachinedbRepository(wmDao:WashingMachineDao) = WashingMachineRepository(wmDao)

    @Provides
    fun provideLightDao(@ApplicationContext applicationContext: Context) : LightDao {
        return ApplianceDatabase.getInstance(applicationContext).lightDao
    }

    @Provides
    fun provideLightdbRepository(lightDao: LightDao) = LightRepository(lightDao)

}