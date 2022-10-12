fun main(args: Array<String>) {
    var juego: Juego = Juego()
    juego.bienvenida()

    if (juego.preguntaColocacion())
        juego.tableroJugador.colocacionManual()
    else
        juego.tableroJugador.generarBarcoRandom()

    juego.tableroMaquina.generarBarcoRandom()

    println("***** Colocación de los barcos completada *****")
    println("*****    Empieza la ronda de disparos     *****")

    while (true) {
        juego.rondaDisparos()

        if (juego.tableroMaquina.vidas == 0) {
            println("¡¡¡HAS GANADO!!!!\n¡¡¡Felicidades!!!")
            break
        } else if (juego.tableroJugador.vidas == 0) {
            println("  HA GANADO LA MÁQUINA\n" +
                    "MEJOR SUERTE A LA PRÓXIMA")
            break
        }
        println("***  Fin del turno  ***\n" +
                "(Enter para continuar)")
        readln()
    }

    println("Gracias por jugar, espero que vuelvas pronto\n" +
            "Desarrollado por: Guillermo Baeza Muñoz")
}