package inheritance

interface MathematicalShape {
    //variable to override
     val shapeName:String
     val side:Int
    //default method of interface
    fun getShapeName(){
        println("Shape is $shapeName")
    }



}