class Tablero {
    //private var tablero = mutableListOf<MutableList<Char>>()
    var tablero = mutableListOf<MutableList<Char>>()
    var vidas = 22

    init {
        for (i in 0..9) {
            val fila = mutableListOf<Char>()
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
        val str = "ABCDEFGHIJ"
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
        val str = "ABCDEFGHIJ"
        for (i in 0..9) {
            var fila = ""
            fila += "${str.get(i)}|"
            for (j in 0..9) {
                if (!(tablero[i][j].equals('@') || tablero[i][j].equals('X')))
                    fila += " |"
                else
                    fila += "${tablero[i][j]}|"
            }
            println(fila)
        }
    }

    fun comprobarSitio(barco: Barco):Boolean {
        try {
            var disponible = true
            if (barco.tipo.equals('A')) {
                if (!tablero[barco.y][barco.x].equals(' '))
                    disponible = false
            } else if (barco.tipo.equals('E') && barco.dir.equals('V')) {
                for (i in 0..1) {
                    if (!tablero[barco.y + i][barco.x].equals(' '))
                        disponible = false
                }
            } else if (barco.tipo.equals('E') && barco.dir.equals('H')) {
                for (i in 0..1) {
                    if (!tablero[barco.y][barco.x + i].equals(' '))
                        disponible = false
                }
            } else if (barco.tipo.equals('I') && barco.dir.equals('V')) {
                for (i in 0..2) {
                    if (!tablero[barco.y + i][barco.x].equals(' '))
                        disponible = false
                }
            } else if (barco.tipo.equals('I') && barco.dir.equals('H')) {
                for (i in 0..2) {
                    if (!tablero[barco.y][barco.x + i].equals(' '))
                        disponible = false
                }
            } else if (barco.tipo.equals('O') && barco.dir.equals('V')) {
                for (i in 0..3) {
                    if (!tablero[barco.y + i][barco.x].equals(' '))
                        disponible = false
                }
            } else if (barco.tipo.equals('O') && barco.dir.equals('H')) {
                for (i in 0..3) {
                    if (!tablero[barco.y][barco.x + i].equals(' '))
                        disponible = false
                }
            } else if (barco.tipo.equals('U') && barco.dir.equals('V')) {
                for (i in 0..4) {
                    if (!tablero[barco.y + i][barco.x].equals(' '))
                        disponible = false
                }
            } else if (barco.tipo.equals('U') && barco.dir.equals('H')) {
                for (i in 0..4) {
                    if (!tablero[barco.y][barco.x + i].equals(' '))
                        disponible = false
                }
            }
            return disponible
        } catch (e:java.lang.IndexOutOfBoundsException) {
            println("No se puede colocar el barco ahi porque se sale del mapa")
            return false
        }
    }

    fun generarBarcoRandom() {
        var barco:Barco
        var tipo:Char
        var cont = 0 // 1xA, 3xE, 2xI, 1xO, 1xU
        while (cont < 8) {
            while (true) {
                val aux = (1..2).random()
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

    fun colocacionManual() {
        var barco:Barco

        var cont = 1
        var tipo = 'A'
        while (cont < 9) {
            if (cont >= 2 && cont <= 4)
                tipo = 'E'
            else if (cont >= 5 && cont <= 6)
                tipo = 'I'
            else if (cont == 7)
                tipo = 'O'
            else if (cont == 8)
                tipo = 'U'

            println("Tablero:")
            revelarTablero()

            do {
                println("Colocación del barco $tipo:\nIntroduce la posición: (Ejemplo: 1A)")
                var posicion = readln().toCharArray()
                while (comprobarPosicionIntroducida(posicion)) {
                    println("Posición no disponible, introduce otra")
                    posicion = readln().toCharArray()
                }
                println("Introduce la orientavión del barco: (V/H)")
                var aux = readln()
                while (comprobarDireccionIntroducida(aux)) {
                    println("Dirección no disponible, introduce otra")
                    aux = readln()
                }
                val dir = aux.toCharArray()
                barco = Barco(tipo, dir[0], (posicion[0].code - 48), posicion[1])
                if (!comprobarSitio(barco))
                    println("No se puede colocar el barco ahi porque el sitio esta ocupado")
            } while (!comprobarSitio(barco))

            colocarBarco(barco)

            cont++
        }
    }

    fun comprobarPosicionIntroducida(posicion:CharArray):Boolean {
        if (posicion.size == 2 && ((posicion[0].code < 49 || posicion[0].code > 57) || (posicion[1].code < 65 || posicion[1].code > 74))) {
            return true
        }
        else if (posicion.size == 3 && (posicion[0].code != 49 || posicion[1].code != 48 || (posicion[2].code < 65 || posicion[2].code > 74))){
            return true
        }
        else if (posicion.size < 2 || posicion.size > 3) {
            return true
        }
        return false
    }

    fun comprobarDireccionIntroducida(dir: String):Boolean {
        if (dir.equals("V") || dir.equals("H")) {
            return false
        }
        return true
    }

    fun disparoAleatorio() {
        var x:Int
        var y:Int
        var result = 0
        var cont = 0
        while (result != 1) {
            x = (0..9).random()
            y = (0..9).random()
            result = procesarDisparo(x, y)
            if (result == 3) {
                println("¡ACIERTO! Disparando otra vez...")
                cont++
                if (vidas == 0)
                    break
            } else if (result == 1) {
                println("¡Fallo!")
            }
        }
        println("Resumen: $cont aciertos\n")
    }

    fun procesarDisparo(x:Int, y:Int):Int {
        if (tablero[y][x] == ' ') {
            tablero[y][x] = '@'
            return 1
        } else if (tablero[y][x] == '@' || tablero[y][x] == 'X') {
            return 2
        } else {
            tablero[y][x] = 'X'
            vidas--
            return 3
        }
    }
}