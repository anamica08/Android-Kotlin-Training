package inheritance

//open keyword is required to allow inheritance of this class.
open class Square: MathematicalShape,Color {
    //override val varible of interface
    override val side: Int
        get() = 3
    //override var variable of interface
    override var color: String = "default"
        get() {
            return field
        }
        set(value) {
            field = value
        }


    override val shapeName: String
        get() = "Square"

    //override function calculateArea
    open fun calculateArea() {
        println("Area of $shapeName is ${side*side}")
    }

    open fun displayInfo(){
        println("[Side : $side , Color : $color]")
        calculateArea()
    }

}