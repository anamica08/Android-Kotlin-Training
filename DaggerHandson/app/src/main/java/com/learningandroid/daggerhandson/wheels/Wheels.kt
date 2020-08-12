package com.learningandroid.daggerhandson.wheels

//class Wheel @Inject constructor() {

class Wheels(private val rims: Rims, private val tires: Tires) {
    //now lets suppose wheel is a third party software and we dont own it ,
    // and thus cannot annotate it with @Inject


}