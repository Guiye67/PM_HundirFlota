class Barco(val tipo:Char, val dir:Char, x:Int, y:Char) {
    val y:Int
    val x:Int
    init {
        this.x = x-1
        this.y = y.code-65
    }
}