package com.learningandroid.daggerhandson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learningandroid.daggerhandson.engine.DeiselEngineModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var  car :Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)


        val component:CarComponent = DaggerCarComponent.builder()
            .deiselEngineModule(DeiselEngineModule(100))
            .build()
        //component.getCarInstance().drive()
        //now lets inject car instance (feild injection)
        /***
         * we have done field injection for car because main activity is a class created and instantiated
         * by android and thus we cannot create constructor of this class and do constructor injection.
         * that's why we do field injection to achieve it .
         *
         * ## avoid doing method injection in main activity.....##
         */
        component.inject(this)

        car.drive()




    }
}