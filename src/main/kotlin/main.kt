import kotlinx.coroutines.*

const val tiempo1 = 1000L
const val tiempo2 = 1500L
const val MAXDADO = 6
const val MINDADO = 1
const val N = 10

fun main(args: Array<String>) {
    val result1 = mutableListOf<Int>()
    val result2 = mutableListOf<Int>()

    runBlocking {
        //Jugador1
        this.launch {
            nTiradas(result1, tiempo1, 1)
        }
        //Jugador2
        this.launch {
            nTiradas(result2, tiempo2, 2)
        }
    }
    sumaResultados(result1,1)
    sumaResultados(result2,2)
}

suspend fun nTiradas(lista : MutableList<Int>, tiempoTirada : Long, numeroJugador : Int){
    var auxDado = 0
    repeat(N){
        auxDado = (MINDADO..MAXDADO).random()
        println("Tirada ${it+1} del Jugador $numeroJugador: $auxDado")
        lista.add(auxDado)
        delay(tiempoTirada)
    }
    println("J$numeroJugador ha terminado")
}

fun sumaResultados(lista : MutableList<Int>, numeroJugador: Int){
    var suma = 0
    lista.forEach {
        suma += it
    }
    println("J$numeroJugador ha sacado un $suma")
}