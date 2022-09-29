fun main(args: Array<String>) {
    var tablero: Tablero = Tablero()
    var barco: Barco = Barco('U', 'H', 3, 'D')
    tablero.colocarBarco(barco)
    tablero.mostrarTablero()
    tablero.revelarTablero()
}