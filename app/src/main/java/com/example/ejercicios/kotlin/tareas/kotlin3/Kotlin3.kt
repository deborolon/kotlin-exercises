package com.henryandroid.kotlin.tareas.kotlin3

import com.henryandroid.kotlin.tareas.kotlin3.Kotlin3.Dog

class Kotlin3 {
    
    // 1. Herencia y polimorfismo básicos
    open class Animal(val name: String) {
        open fun makeSound() {
            // TODO: Imprimir "El animal hace un sonido"
            println("El animal $name hace un sonido")
        }
    }

    class Dog(name: String) : Animal(name) {
        override fun makeSound() {
            // TODO: Imprimir "$name ladra"
            super.makeSound()
            println("$name ladra...")
        }
    }

    // 2. Colecciones en Kotlin
    fun collectionOperations() {
        val numbers = mutableListOf(1, 2, 3, 4, 5)
        // TODO: Agregar el número 6 a la lista
        // TODO: Remover el número 2 de la lista
        // TODO: Usar map para duplicar los valores
        // TODO: Usar filter para obtener solo los números impares
        numbers.add(6)
        numbers.remove(2)
        val duplicados = numbers.map { it * 2 }
        val impares = duplicados.filter { it % 2 != 0 }
        println(numbers)
        println(duplicados)
        println(impares)
    }

    // 3. Clases de datos y destructuración
    data class Person(val name: String, val age: Int)
    
    fun dataClassExample() {
        val person1 = Person("Juan", 30)
        // TODO: Crear una copia de person1 con otro nombre
        // TODO: Comparar person1 con su copia
        // TODO: Usar destructuración para obtener name y age
        val person2 = person1.copy(name = "Ana")
        val sonIguales = person1 == person2
        val (nombre, edad) = person1

        println("Persona 1: $person1")
        println("Persona 2: $person2")
        println("¿Son iguales?: $sonIguales")
        println("Nombre: $nombre, Edad: $edad")
    }

}

fun main() {
    // Herencia y polimorfismo
    val k3 = Kotlin3()
    val dog = Kotlin3.Dog("Firulais")
    dog.makeSound()

    // Colecciones
    k3.collectionOperations()

    // Clases de datos y destructuración
    k3.dataClassExample()
}