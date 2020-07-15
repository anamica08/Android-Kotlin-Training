
class Player(val name:String, var lives:Int = 3 ,var score:Int = 0,var level:Int = 1){
    lateinit var weapon:Weapon
    fun show() {
        println("""
    	name = $name 
        lives = $lives
        score = $score
        level = $level
    """
    )

        weapon.show()
    }
}