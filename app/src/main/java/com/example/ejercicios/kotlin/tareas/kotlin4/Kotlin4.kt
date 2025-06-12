package com.example.ejercicios.kotlin.tareas.kotlin4

class Kotlin4 {
    //funciones básicas
    fun operation(a: Int, b: Int): Unit {
        println(a*b)
    }

    //funciones en línea
    fun suma(a: Int, b: Int) = a + b

    fun bienvenida(esBienvenida: Boolean) = if(esBienvenida) "Bienvenidos!" else "No son bienvenidos aca..."

    //funciones de orden superior (reciben otra funcion como parámetro)
    fun textConverter(text: String,  process: (String) -> String): String{
        return process(text)
    }

    //funciones inline
    inline fun textConverterInline(text: String, process: (String) -> String): String {
        return process(text)
    }

    //una función lambda es una función anónima que puede tratarse como un valor: se puede asignar a variables,
    //pasar como argumento a funciones y retornar desde funciones y se describe con las llaves { }
    val helloFriend = { nombre: String -> "Hola, $nombre" }

    //objetos
    class CreateUsers(
        val name: String,
        val age: Int,
        val role: String
    ){
        fun showAllUserInfo(): String{
            return "Usuario nombre: $name, usuario edad: $age, usuario rol: $role"
        }

        fun showUserName(): String{
            return "Usuario nombre: $name"
        }
    }

    //métodos public, private, protectec
    class CreateAnimals(
        public val animal : String,
        private val habitat: String,
        private val color : String
    ){
        //private fun showData (): String {... solo accesible dentro de la clase
        fun showData (): String {
            return "El animal $animal, es de color $color y vive en $habitat"
        }
        //es public por default
        public fun showName (): String = "El animal es: $animal"

        //protected -> solo tiene sentido dentro de las clases que se pueden heredar
        //open, abstract, sealed
    }

    open class CreateSoloLecturaAnimals(
        animalName: String,
        // solo accesible dentro del paquete/módulo
        internal val type: String,
        // usado internamente por la clase y sus subclases
        protected val habitat: String
    ) {
        // getter público (por defecto) - valor inmutable
        val animal: String = animalName

        // propiedad totalmente privada (invisible fuera de la clase)
        private val color: String = "Desconocido"

        // metodo visible en subclases, no fuera
        protected fun habitatInfo(): String = "Habitat: $habitat"

        // metodo completamente privado
        private fun internalLogic(): String = "Log interno del animal $animal"

        // metodo público que expone información de forma segura
        fun showData(): String {
            return "El animal $animal vive en $habitat"
        }

        // metodo público que usa lógica interna sin exponerla
        fun getInternalReport(): String {
            return internalLogic()
        }
    }

}

fun main(){
    val x = Kotlin4()
    x.operation(2, 3)
    println(x.suma(5, 6))
    println(x.bienvenida(true))
    println(x.bienvenida(false))
    println(x.textConverter("Holis") {it.uppercase() })
    println(x.textConverterInline("Holis") {it.reversed() })
    println(x.helloFriend("Debo"))
    //creacion de objetos
    val usr1 = Kotlin4.CreateUsers("Debs",32,"dev")
    //invocacion de métodos
    println(usr1.showUserName())
    println(usr1.showAllUserInfo())
    //creación de objetos
    //add names to call arguments -> Alt + Enter
    val animal1 = Kotlin4.CreateAnimals(animal = "oso", habitat = "bosque", color = "pardo")
    val animal2 = Kotlin4.CreateAnimals(animal = "tigre", habitat = "selva", color = "naranja")
    println(animal1.showData())
    //CreateSoloLecturaAnimals
    val animal3 = Kotlin4.CreateSoloLecturaAnimals("nutria", "acuática", "mar")
    println(animal3.animal)
}