class Person(val firstName: String = "Peter", val lastName: String = "Parker", var gender: Gender = Gender.Male){
//     var abc  = 1
//        private set

    var nickName: String? = null
        set(value) {
        println("Setter is called.")
        field = value
        }
        get(){
       // println("Getter is called on $field.")
            return field
        }

    fun printInfo(){
        var nickNameToPrint = nickName ?: "<No Nickname Supplied>" /*if(nickName != null) nickName else "<No Nickname Supplied>"*/
        println("""
            Full Name: $firstName $nickNameToPrint $lastName
            Gender : ${gender}
        """)
    }
}