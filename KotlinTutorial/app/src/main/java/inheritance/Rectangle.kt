package inheritance

//inheriting class
class Rectangle(override var color: String, override val shapeName: String, override val side: Int) : Color,MathematicalShape {
    var breadth :Int = 0
        get() = field
        set(value) {field = value}

    fun calculateArea() {
        println("Area of $shapeName is ${side*breadth}")
    }

    fun displayInfo(){
        println("[Length : $side , Breadth : $breadth , Color : $color]")
        calculateArea()
    }
}