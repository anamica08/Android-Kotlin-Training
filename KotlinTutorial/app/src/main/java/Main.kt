import inheritance.Cube
import inheritance.MathematicalShape
import inheritance.Rectangle
import inheritance.Square

fun main(args: Array<String>) {
    println("Hello World")
    var tim = Player("Timethy",5)
    var timWeapon = Weapon("fist",5)
    tim.weapon = timWeapon
    tim.show()



    /* Person Class*/
    var person1 = Person()
    //println("${person1.abc}")
    person1.printInfo()
//    println("""
//       FirstName: ${person1.firstName}
//        SecondName: ${person1.lastName}
//    """)
    person1.nickName = "Pikuu"
    person1.printInfo()
//    println("""
//        FirstName: ${person1.firstName}
//        SecondName: ${person1.lastName}
//        Nick Name: ${person1.nickName}
//    """)

println("***************************************Interfaces************************************************************")
    var infoProvider = BasicInfoProvider();
    infoProvider.getInfo()
    println("()()()()()()")
    infoProvider.message = "Setting the value of overrider"
    infoProvider.getMessage()

    println("____________Type checking and type casting____________")

    if(infoProvider !is PersonInfoProvider){
        println("infoProvider is instance of PersonInfoProvider")
    }else{
        println("infoProvider is not a instance of PersonInfoProvider")
        //(infoProvider as SessionInfoProvider).getSessionId()
        //kotlin can do automatic typecasting
        infoProvider.getSessionId()
        infoProvider.getMessage()
    }

    println("**********************************Inheritance**********************************************")
    println("Square")
    var figure1 = Square()
    figure1.displayInfo()
    println("***Adding color***")
    figure1.color = "Red"
    figure1.displayInfo()
    println("Rectangle")
    var figure2 = Rectangle("Yellow","Rectangle",5)
    figure2.breadth = 4
    figure2.displayInfo()


    println("Anonymous Objects")
    val obj = object:MathematicalShape{
        override val shapeName: String
            get() = "Anonymous"
        override val side: Int
            get() = 0
        fun displayInfo(){
            println("[Shape : $shapeName , Side : $side]")
        }
    }
    obj.displayInfo()

    val cube1 = Cube()
    cube1.displayInfo()

    println("Companion objects <simulate the behaviour of static objects and feild of Java>")
    var obj3  = CompanionObjectDemo.factory.create()
    println(obj3.id)


    println("Object Declarations")
    //used to create thread safe singleton object in kotlin - refer class Entity
    println("**************************************************************************************")

    //static java function call
    JavaService.`fun`()
    val object_javaService = JavaService()
    object_javaService.hopeQuotient = 3
    println(object_javaService.hopeQuotient)



}
