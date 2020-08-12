package com.learningandroid.daggerhandson

import dagger.Component


//this class is responsible for creating and supply injectons to classes which require them.
@Component
interface CarComponent {

    fun getCarInstance():Car;
}