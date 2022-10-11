fun main(args: Array<String>) {
    var juego: Juego = Juego()
    juego.bienvenida()

    if (juego.preguntaColocacion())
        juego.tableroJugador.colocacionManual()
    else
        juego.tableroJugador.generarBarcoRandom()

    juego.tableroMaquina.generarBarcoRandom()
    juego.tableroMaquina.mostrarTablero()

    juego.tableroJugador.revelarTablero()
}