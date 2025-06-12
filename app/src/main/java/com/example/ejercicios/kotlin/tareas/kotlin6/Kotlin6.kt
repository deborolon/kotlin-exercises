package com.example.ejercicios.kotlin.tareas.kotlin6

// ==, ||, do while, break, continue, funciones de una sola expresion (realizan una accion específica y devuelven un resultado)
//sortedBy, sortedByDescending, any, all, find, filter, map, none, reduce, foreach

class Kotlin6 {
    //clase heredada
    open class Music(
        val band: String,
        val genre: String
    ){
        open fun showBand(){
            println("La banda $band toca $genre.")
        }
    }

    class Musicians(
        val nombre : String,
        band : String,
        genre: String
    ) : Music(band, genre){
    //se deben pasar todos los valores al constructor porque la clase Music lo requiere
    //podrían ser opcionales, si se declararan valores por default en el constructor de Music
    //ejemplo: val genre: String = "Genero Desconocido"
            override fun showBand(){
                println("$nombre toca en $band de genero $genre.")
            }
    }

    //declaración de clase abreviada con constructor primario y propiedades públicas
    class Persona(val nombre: String, val edad: Int)

}

//extension functions: forma de agregar funciones a clases existentes, sin tener que heredarlas o modificarlas
fun Kotlin6.Persona.esMayor(): Boolean {
    return this.edad >= 18
}

//infix functions
//se llaman sin paréntesis ni punto entre dos objetos
//para que sea infix debe ser una funcion miembro (que opera sobre una instancia de clase)
//o debe ser una extensión (definida fuera de la clase pero actúa como si fuera parte)
//tambien debe tener un solo parametro y llevar la palabra clave infix
infix fun Kotlin6.Persona.mismaEdadQue(otra: Kotlin6.Persona): Boolean {
    return this.edad == otra.edad
}

fun main(){
    val m1 = Kotlin6.Music("Green Day", "Pop Punk")
    val m2 = Kotlin6.Music("Linkin Park", "Nu Metal")
    val m3 = Kotlin6.Music("Garbage", "Rock Alternativo")
    //polimorfismo
    val bandList: List<Kotlin6.Music> = listOf(m1, m2, m3)
    for (band in bandList){
        println(band.showBand())
    }

    val persona1 = Kotlin6.Persona("Leo", 17)
    val persona2 = Kotlin6.Persona("Mica", 17)
    //invocacion de extension function
    println("${persona1.esMayor()}")
    println("Es mayor? ${persona1 mismaEdadQue persona2}")

    //colecciones: estructura que permite almacenar varios elementos dentro de un solo objeto
    //listas, listas inmutables, listas mutables, sets, maps

    //listOf puede contener distintos tipos de datos, pero no es recomendable hacerlo
    //puede ser mutable o inmutable, tambien permite duplicados y se accede por indice
    val planetas = listOf("Marte", "Jupiter", "Tierra")
    println(planetas)
    println(planetas.get(0))
    println(planetas[0])

    //mutableListOf permite añadir, modificar o eliminar elementos una vez que se inicializó la lista
    val profesiones = mutableListOf("Electricista", "Doctor", "Abogada")
    profesiones.add("Desarrollador")
    profesiones.add(0, "Gerente")
    println(profesiones)
    profesiones.removeAt(3)
    profesiones.remove("Desarrollador")
    profesiones[2] = "Doctora"
    println(profesiones)

    //set es una coleccion desordenada de elementos no duplicados
    //hay sets mutables e inmutables
    val objetos = setOf("termo", "mate", "vela", "mesa")
    //objetos.add("silla") -> error, no se puede modificar la lista
    val colores = mutableSetOf("verde", "rojo", "violeta")
    colores.add("amarillo")
    println(colores)

    //maps o hashmaps es una coleccion de clave-valor y se usa para asociar elementos con esas claves
    //puede ser mutable o inmutable
    val personajes = mapOf(1 to "Bugs Bunny", 2 to "Pato Lucas", 3 to "Silvestre")
    println(personajes)
    //se busca por clave
    println(personajes[1])
    val superheroes = mutableMapOf(1 to "Superman", 2 to "Iron Man", 3 to "Capitan America")
    //para añadir al map
    superheroes[4] = "Batman"
    superheroes.remove(1)
    println(superheroes)
}