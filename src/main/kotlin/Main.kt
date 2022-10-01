fun main(args: Array<String>) {
    var juego: Juego = Juego()
    juego.tableroMaquina.generarBarcoRandom()
    juego.tableroMaquina.revelarTablero()

    juego.tableroJugador.generarBarcoRandom()
    juego.tableroJugador.revelarTablero()
}