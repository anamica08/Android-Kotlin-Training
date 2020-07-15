package inheritance

class Cube : Square() {
    override fun displayInfo() {
        super.displayInfo()
    }

    override val side: Int
        get() = 4

    override val shapeName: String
        get() = "Cube"

    override var color: String = "Red as Default"
        get() = field
        set(value) {
            field = value
        }

    override  fun calculateArea() {
        println("Area of $shapeName is ${6*side*side}")
    }
}