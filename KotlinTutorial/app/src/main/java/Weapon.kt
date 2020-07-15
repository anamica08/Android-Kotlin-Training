class Weapon(val name:String , var damageInflicted:Int = 0){
    fun show(){
        println(""" 
            WeaponName : $name
            DamageInflicted : $damageInflicted
        """)
    }
}