fun main(args: Array<String>) {
    var juego: Juego = Juego()
    juego.bienvenida()

    if (juego.preguntaColocacion())
        println("colocacion a mano")
    else
        juego.tableroJugador.generarBarcoRandom()

    juego.tableroMaquina.generarBarcoRandom()
    juego.tableroMaquina.revelarTablero()

    juego.tableroJugador.revelarTablero()
}