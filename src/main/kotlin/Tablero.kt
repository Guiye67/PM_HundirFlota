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
        if (barco.dir.equals('V')) {
            for (i in 0..cont) {
                tablero[barco.y + i][barco.x] = barco.tipo
            }
            return true
        } else if (barco.dir.equals('H')) {
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
        println("-----------------------")
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

    fun comprobarSitio(barco: Barco):Boolean {
        var disponible = true
        if (barco.tipo.equals('A')) {
            if (!tablero[barco.y][barco.x].equals(' '))
                disponible = false
        }
        else if (barco.tipo.equals('E') && barco.dir.equals('V')) {
            for (i in 0..1) {
                if (!tablero[barco.y+i][barco.x].equals(' '))
                    disponible = false
            }
        }
        else if (barco.tipo.equals('E') && barco.dir.equals('H')) {
            for (i in 0..1) {
                if (!tablero[barco.y][barco.x+i].equals(' '))
                    disponible = false
            }
        }
        else if (barco.tipo.equals('I') && barco.dir.equals('V')) {
            for (i in 0..2) {
                if (!tablero[barco.y+i][barco.x].equals(' '))
                    disponible = false
            }
        }
        else if (barco.tipo.equals('I') && barco.dir.equals('H')) {
            for (i in 0..2) {
                if (!tablero[barco.y][barco.x+i].equals(' '))
                    disponible = false
            }
        }
        else if (barco.tipo.equals('O') && barco.dir.equals('V')) {
            for (i in 0..3) {
                if (!tablero[barco.y+i][barco.x].equals(' '))
                    disponible = false
            }
        }
        else if (barco.tipo.equals('O') && barco.dir.equals('H')) {
            for (i in 0..3) {
                if (!tablero[barco.y][barco.x+i].equals(' '))
                    disponible = false
            }
        }
        else if (barco.tipo.equals('U') && barco.dir.equals('V')) {
            for (i in 0..4) {
                if (!tablero[barco.y+i][barco.x].equals(' '))
                    disponible = false
            }
        }
        else if (barco.tipo.equals('U') && barco.dir.equals('H')) {
            for (i in 0..4) {
                if (!tablero[barco.y][barco.x+i].equals(' '))
                    disponible = false
            }
        }
        return disponible
    }

    fun generarBarcoRandom() {
        var barco:Barco
        var tipo:Char
        var cont:Int = 0
        while (cont < 8) {
            while (true) {
                var aux = (1..2).random()
                var dir:Char
                if(aux == 1) {
                    dir = 'V'
                }else {
                    dir = 'H'
                }

                if (cont == 0) {
                    tipo = 'A'
                    barco = Barco(tipo, dir, (1..10).random(), ((0..9).random() + 65).toChar())
                } else if (cont >= 1 && cont <= 3) {
                    tipo = 'E'
                    if (dir.equals('V')) {
                        barco = Barco(tipo, dir, (1..10).random(), ((0..8).random() + 65).toChar())
                    } else {
                        barco = Barco(tipo, dir, (1..9).random(), ((0..9).random() + 65).toChar())
                    }
                } else if (cont <= 5) {
                    tipo = 'I'
                    if (dir.equals('V')) {
                        barco = Barco(tipo, dir, (1..10).random(), ((0..7).random() + 65).toChar())
                    } else {
                        barco = Barco(tipo, dir, (1..8).random(), ((0..9).random() + 65).toChar())
                    }
                } else if (cont == 6) {
                    tipo = 'O'
                    if (dir.equals('V')) {
                        barco = Barco(tipo, dir, (1..10).random(), ((0..6).random() + 65).toChar())
                    } else {
                        barco = Barco(tipo, dir, (1..7).random(), ((0..9).random() + 65).toChar())
                    }
                } else {
                    tipo = 'U'
                    if (dir.equals('V')) {
                        barco = Barco(tipo, dir, (1..10).random(), ((0..5).random() + 65).toChar())
                    } else {
                        barco = Barco(tipo, dir, (1..6).random(), ((0..9).random() + 65).toChar())
                    }
                }
                if (comprobarSitio(barco)) {
                    colocarBarco(barco)
                    cont++
                    break
                }
            }
        }
    }
}