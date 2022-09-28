fun main(args: Array<String>) {
    var tablero: Tablero = Tablero()
    var barco: Barco = Barco('E', 'V', 2, 'A')
    tablero.colocarBarco(barco)
    tablero.mostrarTablero()
}