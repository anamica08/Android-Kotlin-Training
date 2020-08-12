package com.learningandroid.daggerhandson.wheels

import dagger.Module
import dagger.Provides


@Module
class WheelsModule {

    companion object{
        @Provides
        fun provideRims():Rims{
            return Rims()
        }

        @Provides
        fun provideTires():Tires{
            val tire = Tires()
            tire.inflate(tire)
            return tire
        }
        @Provides
        fun provideWheels(rims:Rims, tires:Tires):Wheels{
            return Wheels(rims,tires)
        }
    }

}