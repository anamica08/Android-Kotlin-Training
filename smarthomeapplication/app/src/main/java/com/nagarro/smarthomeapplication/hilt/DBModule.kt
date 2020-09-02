package com.nagarro.smarthomeapplication.hilt

import android.content.Context
import com.nagarro.smarthomeapplication.db.ApplianceDao
import com.nagarro.smarthomeapplication.db.ApplianceDatabase
import com.nagarro.smarthomeapplication.db.ApplianceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext


@InstallIn(ApplicationComponent::class)
@Module
object DBModule {
    @Provides
    fun provideApplianceDao(@ApplicationContext applicationContext: Context) : ApplianceDao{
        return ApplianceDatabase.getInstance(applicationContext).applianceDao
    }

    @Provides
    fun provideAppliancedbRepository(applianceDao:ApplianceDao) = ApplianceRepository(applianceDao)
}