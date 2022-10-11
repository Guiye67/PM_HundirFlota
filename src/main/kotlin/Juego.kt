class Juego {
    var tableroJugador = Tablero()
    var tableroMaquina = Tablero()

    init {

    }

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
        var elec = readln().toInt();
        while (elec < 1 || elec > 2) {
            println("Opción no disponible, prueba otra")
            elec = readln().toInt()
        }
        return elec == 1
    }

    // preguntar colocacion aleatoria
    // desarrollar colocacion a mano
    // funcion disparo manual y aleatorio
    // funcion comprobar disparo
}