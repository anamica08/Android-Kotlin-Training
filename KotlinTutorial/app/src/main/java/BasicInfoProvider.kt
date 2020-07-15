class BasicInfoProvider() : PersonInfoProvider,SessionInfoProvider{

    override fun getInfo() {
        println("Implementation Class")
    }
    override var person: Person = Person()

//    override var message: String
//        get() {
//            TODO()
//        }
//        set(value) {}
    override var message: String = ""
    get() {
            return "Only getter is allowed when val is overrided as val"
        }


    override fun getMessage() {
        super.getMessage()
    }

    override fun getSessionId() {
        print("Session ID is 434nk34nkh54")
    }
}