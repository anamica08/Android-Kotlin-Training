class CompanionObjectDemo private constructor(val id:Int) {

    companion object factory : ObjectProviderCompanionPbjectDemo{
        override fun getEntityId(): Int {
            return  56
        }
        //fun create() = CompanionObjectDemo(5)
        fun create() = CompanionObjectDemo(getEntityId())
    }



}