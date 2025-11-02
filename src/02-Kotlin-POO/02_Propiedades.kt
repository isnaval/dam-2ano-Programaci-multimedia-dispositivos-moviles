class Libro(
    val titulo: String,
    val autor: String,
    val isbn: String,
    var prestado: Boolean,
    var paginas: Int
) {
    fun prestas() {
        if (!prestado) {
            prestado = true
            println("$titulo ha sido prestado")
        } else {
            println("$titulo ya esta prestado")
        }
    }

    fun devolver() {
        if (prestado) {
            prestado = false
            println("$titulo ha sido devuelto")
        } else {
            println("$titulo ha sido devuelto")
        }
    }

    fun monstrarInfo() {
        val estado = if (prestado) "Prestado" else "Disponbile"
        println("Título: $titulo de $autor con ISBN: $isbn tiene $paginas páginas ")
    }
}

class CuentaBancaria2 {
    var titular: String = ""
    var saldo: Double = 0.0
    fun inicializar(titular: String, saldo: Double) {
        this.titular = titular
        this.saldo = saldo
        println("Cuenta inicializada: $titular con $saldo")
    }

    fun depositar(cantidad: Double) {
        if (cantidad > 0) {
            this.saldo += cantidad
            println("Depositado: $cantidad")
            this.mostrarInfo()
        } else {
            println("Cantidad inválida")
        }
    }

    fun retirar(cantidad: Double) {
        if (cantidad > 0 && cantidad <= this.saldo) {
            this.saldo -= cantidad
            println("RETIRADO: $cantidad")
        } else if (cantidad > this.saldo) {
            println("Saldo insuficiente")
        } else {
            println("Cantidad inválida")
        }
    }

    fun mostrarInfo() {
        println("SALDO ACTUAL: ${this.saldo}")
    }
}

class Jugador(var nombre: String, var nivel: Int = 1, var vida: Int = 100, var puntos: Int = 0) {
    fun subirNivel() {
        nivel++
        vida = 100
        println("$nombre subió al nivel $nivel")
        println("Vida restaurada a $vida")
    }

    fun recibirDanio(danio: Int) {
        vida -= danio
        if (vida < 0) vida = 0
        println("$nombre recibió $danio de daño. Puntos totales: $vida")

        if (vida == 0) {
            println("$nombre ha muerto")
        }
    }

    fun ganarPuntos(cantidad: Int) {
        vida += cantidad
        println("$nombre gano $cantidad de puntos. Puntos totales: $vida")
        if (puntos >= nivel * 100) {
            subirNivel()
        }
    }

    fun monstrarEstado() {
        println("Jugador: $nombre")
        println("     - Nivel: $nivel")
        println("     - Vida: $vida")
        println("     - Puntos: $puntos")
    }
}

fun main() {
    println("=== PROPIEDAD DE KOTLIN ===\n")
    println("--- Ejemplo 1: Libro (val vs var) ---\n")
    var libro = Libro("1984", "George Orwell", "978-0451524935", false, 328)
    libro.monstrarInfo()
    libro.devolver()
    println()

    println("--- Ejemplo 2: Cuenta Bancaria ---\n")
    val cuenta = CuentaBancaria2()
    cuenta.inicializar("Maria", 500.0)
    cuenta.depositar(500.0)
    cuenta.retirar(200.0)
    cuenta.mostrarInfo()
    println()

    println("--- Ejemplo 3: Contador ---\n")
    val jugador = Jugador("Hero", 1, 100, 0)
    jugador.monstrarEstado()
    jugador.ganarPuntos(50)
    jugador.recibirDanio(30)
    jugador.monstrarEstado()
}