interface PersonInfoProvider {
    fun getInfo()
    val message:String
    var person:Person
    fun getMessage(){
        println("Message is : $message")
        //println("Person is ${person.firstName}")
        person.printInfo()
    }
}

