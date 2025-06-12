package com.example.ejercicios.kotlin.tareas.kotlin5
//clase con constructor primario y secundario
class Kotlin5 {
    class Superheroes(
        val nombre : String,
        val poder : String,
        val universo : String,
        val especie : String
    ){
        private var enemigos : String = ""
        constructor(
            nombre: String,
            poder: String,
            universo: String,
            especie: String,
            enemigos: String
        ) : this(nombre, poder, universo, especie){
            this.enemigos = enemigos
        }
        init{
            saludar()
        }

        fun saludar() : Unit = println("Bienvenidos!")

        fun showNames(): String = "Superheroe: $nombre"

        fun showData(): String {
            var data = "$nombre tiene como poder $poder, es de $universo y su especie es $especie."
            if (enemigos.isNotBlank()) {
                data += " Sus enemigos son: $enemigos."
            }
            return data
        }
    }

}

fun main(){
    val s1 = Kotlin5.Superheroes(
        nombre = "Deadpool",
        poder = "fuerza, velocidad y curacion regenerativa",
        universo = "Marvel",
        especie = "mutante humano"
    )
    val s2 = Kotlin5.Superheroes(
        nombre = "Wolverine",
        poder = "fuerza sobrehumana y huesos indestructibles",
        universo = "Marvel",
        especie = "mutante humano",
        enemigos = "Magneto, Deadpool"
    )
    println(s1.showNames() + ", " + s2.showNames())
    println(s1.showData())
    println(s2.showData())
}