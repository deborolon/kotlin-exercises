package com.henryandroid.kotlin.tareas.kotlin2

import com.henryandroid.kotlin.tareas.kotlin2.Kotlin2.Car
import com.henryandroid.kotlin.tareas.kotlin2.Kotlin2.Person

class Kotlin2 {
    
    // 1. Declaración y uso de funciones básicas
    fun greet(name: String) {
        // TODO: Imprimir "Hola, {name}!" usando println
        println("Hola, $name !")
    }

    fun add(a: Int, b: Int): Int {
        // TODO: Retornar la suma de a y b
        return a + b
    }

    // 2. Funciones inline y de una sola expresión
    inline fun multiply(a: Int, b: Int) = a * b
    
    inline fun square(n: Int) = n * n // TODO: Convertir esta función a una expresión de una sola línea
    
    // 3. Introducción a lambdas y funciones de orden superior
    fun lambdaExample() {
        val numbers = listOf(1, 2, 3, 4, 5)
        val duplicate = numbers.map{it * 2}
        val evenNumbers = duplicate.filter { it % 2 == 0 }
        println(numbers)
        println(duplicate)
        println(evenNumbers)
        // TODO: Usar map para duplicar los valores de numbers y almacenarlo en una nueva lista
        // TODO: Usar filter para obtener solo los números pares
    }

    // 4. Clases y objetos
    class Person(private val name: String, private var age: Int) {
        // TODO: Agregar un método que imprima "Soy {name} y tengo {age} años"
        fun saludar(){
            println("Hola soy $name y tengo $age años :)")
        }
    }

    // 5. Constructores y datos encapsulados
    class Car(val brand: String, val model: String, val year: Int) {
        init {
            // TODO: Imprimir "Auto creado: {brand} {model} del año {year}"
            println("Auto creado: $brand $model del año $year")
        }
    }
}

fun main() {
    // Llamar a las funciones de prueba
    val k2 = Kotlin2()
    k2.greet("Gaston")
    println("Suma: ${k2.add(3, 5)}")
    println("Multiplicación: ${k2.multiply(4, 2)}")
    println("Cuadrado: ${k2.square(6)}")
    k2.lambdaExample()

    // Creación de objetos y uso de clases
    val person = Person("Juan", 30)
    println(person.saludar())
    // TODO: Llamar al método que imprime la información de la persona
    val car = Car("Toyota", "Corolla", 2022)
    println(car)
}