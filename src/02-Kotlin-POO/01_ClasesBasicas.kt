class Persona(var nombre: String, var edad: Int) {
}

class Perro(var nombre: String, var raza: String, var edad: Int) {
    fun saludo() {
        println("¡Guau guay! Soy $nombre")
    }

    fun presentarse() {
        println("Hola, soy $nombre, un $raza de $edad años")
    }

    fun cumpleaños() {
        edad++
        println("¡$nombre cumplió $edad años!")
    }
}

class CuentaBancaria(var titular: String, var saldo: Double) {


    fun depositar(cantidad: Double) {
        if (cantidad > 0) {
            saldo += cantidad
            println("DESPOSITED: $cantidad")
            println("NUEVO SALDO: $saldo")
        } else {
            println("Cantidad invalida")
        }
    }

    fun retirar(cantidad: Double) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad
            println("RETIRADO: $cantidad")
            println("NUEVO SALDO: $saldo")
        } else if (cantidad > saldo) {
            println("SALDO INSUFICIENTE")
        } else {
            println("Cantidad invalida")
        }
    }

    fun consultarSaldo() {
        println("Saldo del $titular: es de $saldo €")
    }
}

fun main() {

    println("=== CLASES BÁSICAS EN KOTLIN ===\n")
    println("---Ejemplo 1: Clase pesona ---")
    val persona1 = Persona("Carlos", 25)
    println("Nombre: ${persona1.nombre}. Edad: ${persona1.edad}")
    val persona2 = Persona("Ana", 26)
    println("Nombre: ${persona2.nombre}. Edad: ${persona2.edad}")
    println()

    println("---Ejemplo 2: Clase perro ---\n")
    val myPerro = Perro("Max", "Labrador", 3)
    val otroPerro = Perro("Luna", "Pastor Alemán", 2)
    myPerro.saludo()
    otroPerro.presentarse()
    myPerro.cumpleaños()
    println()

    println("--- EJEMPLO 3: Cuenta Bancaria ---\n")
    val miCuenta = CuentaBancaria("Juan Pérez", 1000.0)
    miCuenta.consultarSaldo();
    miCuenta.depositar(500.0)
    miCuenta.retirar(100.0)
    miCuenta.consultarSaldo()

}
