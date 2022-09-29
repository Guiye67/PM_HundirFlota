class Tablero {
    private var tablero = mutableListOf<MutableList<Char>>()

    init {
        for (i in 0..9) {
            var fila = mutableListOf<Char>()
            for (j in 0..9) {
                fila.add(' ')
            }
            tablero.add(fila)
        }
    }

    fun colocarBarco(barco: Barco):Boolean {
        var cont = 0
        when (barco.tipo) {
            'E' -> cont = 1
            'I' -> cont = 2
            'O' -> cont = 3
            'U' -> cont = 4
        }
        println(cont)
        if (barco.dir.equals('V',true)) {
            for (i in 0..cont) {
                tablero[barco.y + i][barco.x] = barco.tipo
            }
            return true
        } else if (barco.dir.equals('H',true)) {
            for (i in 0..cont) {
                tablero[barco.y][barco.x + i] = barco.tipo
            }
            return true
        }
        return false
    }

    fun revelarTablero() {
        println(" |1|2|3|4|5|6|7|8|9|10|")
        var str = "ABCDEFGHIJ"
        for (i in 0..9) {
            var fila = ""
            fila += "${str.get(i)}|"
            for (j in 0..9) {
                fila += "${tablero[i][j]}|"
            }
            println(fila)
        }
    }

    fun mostrarTablero() {
        println(" |1|2|3|4|5|6|7|8|9|10|")
        var str = "ABCDEFGHIJ"
        for (i in 0..9) {
            var fila = ""
            fila += "${str.get(i)}|"
            for (j in 0..9) {
                if (!tablero[i][j].equals('@') || !tablero[i][j].equals('X'))
                    fila += " |"
                else
                    fila += "${tablero[i][j]}|"
            }
            println(fila)
        }
    }
}