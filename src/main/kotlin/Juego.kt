class Juego {
    var tableroJugador = Tablero()
    var tableroMaquina = Tablero()

    init {

    }

    fun colocarBarcosRandom() { // A:1, E:3, I:2, O:1, U:1

    }

    fun generarBarcoRandom(tipo:Char):Barco {
        var barco:Barco
        var aux = (1..2).random()
        var dir:Char
        if(aux == 1) {
            dir = 'V'
        }else {
            dir = 'H'
        }
        if (tipo.equals('A')) {
            barco = Barco(tipo, dir, (0..9).random(), ((0..9).random()+65).toChar())
        }
        else if (tipo.equals('E') && dir.equals('V')) {
            barco = Barco(tipo, dir, (0..9).random(), ((0..8).random()+65).toChar())
        }
        else if (tipo.equals('E') && dir.equals('H')) {
            barco = Barco(tipo, dir, (0..8).random(), ((0..9).random()+65).toChar())
        }
        else if (tipo.equals('I') && dir.equals('V')) {
            barco = Barco(tipo, dir, (0..9).random(), ((0..7).random()+65).toChar())
        }
        else if (tipo.equals('I') && dir.equals('H')) {
            barco = Barco(tipo, dir, (0..7).random(), ((0..9).random()+65).toChar())
        }
        else if (tipo.equals('O') && dir.equals('V')) {
            barco = Barco(tipo, dir, (0..9).random(), ((0..6).random()+65).toChar())
        }
        else if (tipo.equals('O') && dir.equals('H')) {
            barco = Barco(tipo, dir, (0..6).random(), ((0..9).random()+65).toChar())
        }
        else if (tipo.equals('U') && dir.equals('V')) {
            barco = Barco(tipo, dir, (0..9).random(), ((0..5).random()+65).toChar())
        }
        else if (tipo.equals('U') && dir.equals('H')) {
            barco = Barco(tipo, dir, (0..5).random(), ((0..9).random()+65).toChar())
        }
        else {
            barco = Barco(tipo, dir, (0..0).random(), ((0..0).random()+65).toChar())
        }

        return barco
    }
}