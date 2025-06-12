package com.example.ejercicios.kotlin.tareas.kotlin7
//data class esta diseñada para almacenar datos, representa objetos de forma concisa y eficiente
//tiene sus propias funciones
//equals() -> sirve para comparar dos objetos por su contenido
//hashCode() -> genera un identificador unico basado en los valores de un objeto
//toString() -> facilita la representacion de un objeto mediante una cadena de texto
//copy() -> permite duplicar un objeto y modificar algunos valores
//componentN() -> permite desestructurar objetos de un data class en variables individuales

data class AmongUs(val color: String, val impostor : Boolean)

fun esSospechoso(player: AmongUs) = player.impostor || player.color == "rojo"

fun saludar(nombre: String) = "Hola, $nombre"

fun cuadrado(x: Int) = x * x

fun main(){
    val lugares = setOf("Museo", "Parque ecologico", "Cine", "Teatro", "Plaza", "Parque de diversiones", "Reserva natural")
    //println(lugares)
    val lugaresMayus = lugares.map { it.uppercase() }
    //println(lugaresMayus)
    val lugaresLargo = lugares.filter { it.length > 10 }
    //println(lugaresLargo)
    val lugaresOrdenados = lugares.sortedBy { it }
    //println(lugaresOrdenados)
    val lugaresOrdenadosDesc = lugares.sortedByDescending { it }
    //println(lugaresOrdenadosDesc)
    val lugaresQueTienen = lugares.any{"Parque" in it}
    //println(lugaresQueTienen)
    val lugaresTodosMayorA = lugares.all { it.length > 5 }
    //println(lugaresTodosMayorA)
    val lugaresNingunoEsIgualA = lugares.none{it == "Cine"}
    //println(lugaresNingunoEsIgualA)
    val lugaresPrimeroCon = lugares.find { it.startsWith("P") }
    //println(lugaresPrimeroCon)

    //reduce
    val totalLetras = lugares.reduce { acc, lugar -> acc + lugar }.length
    println("Cantidad total de letras sumadas: $totalLetras")

    //do while
    var i = 0
    val listaLugares = lugares.toList()
    do {
        println("Visitando: ${listaLugares[i]}")
        i++
    } while (i < listaLugares.size && !listaLugares[i - 1].contains("Parque"))

    val figuras = mutableMapOf(
        1001 to "Triangulo",
        1002 to "Cuadrado",
        1003 to "Rectangulo",
        1004 to "Circulo"
    )
    //println(figuras)
    figuras.forEach { (codigo, nombre) ->
        println("Código $codigo -> ${nombre.uppercase()}")
    }
    //println(figuras.mapValues { it.value.uppercase() })
    //println(figuras.mapValues { it.value.uppercase() })
    //println(figuras.filter { it.key > 1002 })
    //println(figuras.toSortedMap())
    //println(figuras.any {"Circulo" in it.value})
    //println(figuras.entries.find { "Hexagono" in it.value })
    //println(figuras.entries.find { "Cuadrado" in it.value })

    //data class
    val player1 = AmongUs("rojo", true)
    val player2 = AmongUs("verde", false)
    val player3 = player2.copy()
    val player4 = player2.copy(color = "violeta")
    val players = listOf(player1, player2, player3, player4)
    //println(players)
    val a = AmongUs("azul", false)
    val b = AmongUs("azul", false)
    val c = AmongUs("verde", false)
    //println(a == b)
    //println(a.equals(b)) -> menos recomendada
    //se ve el mismo resultado, pero con una clase que no sea data class no funcionaria
    //println(a.toString())
    //println(a)
    //println(a.hashCode() == b.hashCode())
    //println(a.hashCode() == c.hashCode())
    //desestructuracion
    val (col, esImpostor) = AmongUs("rosa", true)
    //println("$col $esImpostor")
    //println(esSospechoso(player1))
    //println(esSospechoso(player2))
    for (p in players) {
        if (p.impostor) {
            println("¡Encontramos un impostor! -> $p")
            break
        }
    }

    for (p in players) {
        if (p.impostor) continue
        println("Jugador seguro: $p")
    }

    //funciones de una sola expresion
    //println(saludar("Debs"))
    //println(cuadrado(2))
}