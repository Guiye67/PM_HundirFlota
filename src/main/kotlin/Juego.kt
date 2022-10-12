class Juego {
    var tableroJugador = Tablero()
    var tableroMaquina = Tablero()

    fun bienvenida() {
        println("\n********************* BIENVENIDO A HUNDIR LA FLOTA ********************\n" +
                "* El juego consiste en colocar barcos en el tablero, después deberás  *\n" +
                "* disparar intentando adivinar la posición de los barcos enemigos.    *\n" +
                "* Si aciertas un disparo recibes otra oportunidad para disprar.       *\n" +
                "* El objetivo es hundir todos los barcos del enemigo.                 *\n" +
                "* Barcos: A (long=1, cant=1), E (long=2, cant=3), I (long=3, cant=2), *\n" +
                "* O (long=4, cant=1), U (long=5, cant=1).                             *\n" +
                "* Jugarás contra la máquina, y todos sus movimientos son aleatorios.  *\n" +
                "***********************************************************************\n")
    }

    fun preguntaColocacion():Boolean {
        println("¿Cómo quieres realizar la colocación de los barcos?\n" +
                "(1) Manualmente / (2) De forma aleatoria")
        var elec = readln().toInt()
        while (elec < 1 || elec > 2) {
            println("Opción no disponible, prueba otra")
            elec = readln().toInt()
        }
        return elec == 1
    }

    fun rondaDisparos() {
        println("\n**Tu turno**\nTablero de la máquina:")
        tableroMaquina.mostrarTablero()
        println("¿Deseas disparar de forma aleatoria o manualmente? (A/M)")
        var elec = readln()
        while (!(elec =="A" || elec == "M")) {
            println("Elección no disponible, introduce otra")
            elec = readln()
        }

        if (elec == "M") {
            var result = 0
            while (result != 1) {
                println("Introduce la casilla a la que disprar: (Ejemplo: 1A)")
                var casilla = readln().toCharArray()
                while (tableroJugador.comprobarPosicionIntroducida(casilla)) {
                    println("Posición no disponible, introduce otra")
                    casilla = readln().toCharArray()
                }
                if (casilla.size == 2)
                    result = tableroMaquina.procesarDisparo((casilla[0].code - 49), (casilla[1].code - 65))
                else
                    result = tableroMaquina.procesarDisparo(9, (casilla[2].code - 65))

                if (result == 2)
                    println("Ya has disparado en esa posición anteriormente, prueba otra vez")
                else if (result == 3) {
                    if (tableroMaquina.vidas == 0)
                        break
                    else {
                        println("¡ACIERTO! Tienes otra oportunidad")
                        tableroMaquina.mostrarTablero()
                    }
                }
            }
            if (tableroMaquina.vidas != 0)
                println("Has fallado, turno de la máquina")
        } else {
            tableroMaquina.disparoAleatorio()
            if (tableroMaquina.vidas != 0)
                println("**Turno de la máquina**")
        }

        if (tableroMaquina.vidas != 0) {
            tableroJugador.disparoAleatorio()
            println("Tu tablero:")
            tableroJugador.revelarTablero()
        }
    }
}