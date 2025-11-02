class Persona3(
    val nombre: String,
    val edad: Int
) {
    fun saludar() {
        println("Hola, soy $nombre y tengo $edad años")
    }
}

class Producto(val nombre: String, val precio: Double, var stock: Int = 0, var disponible: Boolean = true) {
    fun mostrarInfo() {
        val estado = if (disponible) "Disponible" else "No disponible"
        println("$nombre - tiene un precio de $precio -  Stock: $stock en almacen")
    }
}

class Usuario(val nombre: String, var email: String, var edad: Int) {
    init {
        println("Iniciado usuario...")
        if (edad < 0) {
            println("Edad negativa detectada, ajustado a 0")
            edad = 0
        }

        email = email.lowercase()
        println("Usuario creado: $nombre. Email: $email")
    }

    fun mostrarInfo() {
        println("Usuario: $nombre, Email: $email, Edad: $edad")
    }
}

class Empleado(val nombre: String, var salario: Double, val departamento: String) {
    var id: String = ""
    var activo: Boolean = true

    init {
        println("Generando ID del empleado ...")
        id = generarID()
    }

    init {
        println("Validando salario...")
        if (salario < 0) {
            println("Salario negativo, ajustandolo a 0")
            salario = 0.0
        }
    }

    init {
        println("Empleado $nombre registrado en $departamento")
    }

    private fun generarID(): String {
        val random = (1000..9999).random()
        return "EMP-$random"
    }

    fun mostrarInfo() {
        val estadoTexto = if (activo) "ACTIVO" else "INACTIVO"
        println("Empleado: $nombre, con ID: $id, departamento: $departamento y salario: $salario se encuentra $estadoTexto")
    }
}

fun main() {
    println("=== CONSTRUCTORES ===")
    println("--- Ejemplo 1: Persona ---\n")
    var persona = Persona3("Carlos", 25)
    persona.saludar()
    println()

    println("--- Ejemplo 2: Producto ---\n")
    val prod1 = Producto("Laptop", 999.99)
    val prod2 = Producto("Mouse", 29.99, 50)
    val prod3 = Producto("Teclado", 79.99, 0, false)
    prod1.mostrarInfo()
    prod2.mostrarInfo()
    prod3.mostrarInfo()
    println()

    println("--- Ejemplo 3: Usuario ---\n")
    val usuario1 = Usuario("Juan", "JUAN@EMAIL.COM", 25)
    usuario1.mostrarInfo()
    println()
    val usuario2 = Usuario("María", "maria@email.com", -5)
    println()
    usuario2.mostrarInfo()
    println()
    usuario1.mostrarInfo()
    usuario2.mostrarInfo()

    println("--- Ejemplo 4: Empleado ---\n")
    val empleado01 = Empleado("Pedro", 3000.0, "IT")
    empleado01.mostrarInfo()


}
