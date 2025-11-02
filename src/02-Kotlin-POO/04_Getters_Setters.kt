class Rectangulo(var ancho: Double, var alto: Double) {
    val area: Double get() = ancho * alto
    val perimetro: Double get() = 2 * (ancho + alto)
    fun mostrarInfo() {
        println("Rectángulo: ${ancho}m x ${alto}m. Área: ${area}m2. Perímetro: ${perimetro}m")
    }
}

class Persona4(nombre: String, edadInicial: Int) {
    var nombre: String = nombre
        set(value) {
            if (value.isNotBlank()) {
                field = value
            } else {
                println("Nombre no puede estar vacio")
            }
        }
    var edad: Int = edadInicial
        set(value) {
            if (value >= 0 && value <= 120) {
                field = value
            } else {
                println("Edad no valida")
            }
        }

    fun mostrarInfo() {
        println("Persona: $nombre, $edad años")
    }
}

class Temperatura {
    var celsius: Double = 0.0
        set(value) {
            field = value
            println("")
        }

    var fahrenheit: Double
        get() = celsius * 9 / 5 + 32
        set(value) {
            celsius = (value - 32) * 5 / 9
            println("Temperatura establecida: ${value} Fº")
        }

    fun mostrarTemperatur() {
        println("    ${celsius}ºC = ${fahrenheit}ºF")
    }
}

class Usuario4(nombreInicial: String, emailInicial: String) {
    var nombre: String = nombreInicial
    var email: String = emailInicial
        set(value) {
            field = value.lowercase().trim()
            println("Email configurado: $email")
        }

    fun mostrarInfo() {
        println("usuario: $nombre. Email $email")
    }
}

class CuentaBancaria4(var titular: String, saldoInicial: Double) {
    var saldo: Double = saldoInicial
        private set
        get() {
            println("Consultando saldo...")
            return field
        }

    fun depositar(cantidad: Double) {
        if (cantidad > 0) {
            saldo += cantidad
            println("   Deposistado: ${"%.2f".format(cantidad)}")
            println("   Saldo actual: ${"%.2f".format(saldo)}")
        } else {
            println("Canidad inválida")
        }
    }

    fun retirar(cantidad: Double) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad
            println("   Retirado: ${"%.2f".format(cantidad)}")
            println("   Saldo actual: ${"%.2f".format(saldo)}")
        }
    }
}

class PersonaCompleta(var nombre: String, var apellido: String) {
    val nombreCompleto: String
        get() = "$nombre $apellido"
    val iniciales: String
        get() = "${nombre.firstOrNull()?.uppercase() ?: ""}${apellido.firstOrNull()?.uppercase()}"

    fun mostrarInfo() {
        println("Nombre completo: $nombreCompleto")
        println("Iniciales: $iniciales")
    }
}

class Producto4(val nombre: String, val precioInicial: Double) {
    var precio: Double = precioInicial
        set(value) {
            if (value > 0) {
                field = value
                println("   Precio actualizado: $${"%2f".format(value)}")
            } else {
                println("   Precio debe ser mayor a 0")
            }
        }
    var descuento: Double = 0.0
        set(value) {
            if (value in 0.0..100.0) {
                field = value
                println("   Descuento aplicado: ${value}%")
            } else {
                println("   Descuento debe estar entre 0 y 100")
            }
        }

    val precioFinal: Double
        get() = precio * (1 - descuento / 100)

    fun mostrarInfo() {
        println("📦 Producto: $nombre")
        println("   Precio original: $${"%.2f".format(precio)}")
        println("   Descuento: $descuento%")
        println("   Precio final: $${"%.2f".format(precioFinal)}")
    }
}

class UsuarioSeguro(val username: String) {
    var password: String = ""
        set(value) {
            when {
                value.length < 6 -> println("Contraseña corta. Min 6 caracteres");
                !value.any { it.isDigit() } -> println("Contraseña tiene que tener almenos un número");
                !value.any { it.isUpperCase() } -> println("Contraseña tiene que tener almenos una mayuscula")
                else -> {
                    field = value;
                    println("OK: Contraseña es correcta")
                }
            }
        }

    val passwordSegura: Boolean
        get() = password.length >= 8 && password.any { it.isDigit() } && password.any { it.isUpperCase() } && password.any { !it.isLetterOrDigit() }

    fun mostrarInfo() {
        println("   Usuario: $username")
        println("   Contraseña configurada: ${if (password.isNotEmpty()) "Sí" else "No"}")
        println("   Es segura: ${if (passwordSegura) "OK" else "ERROR"}")
    }
}

fun main() {
    println("=== EJERCICO GETTERS Y SETTERS EN KOTLIN ===")
    println("--- Ejemplo 1: Propiedades Calculadas ---\n")
    var rectangulo = Rectangulo(5.0, 3.0)
    rectangulo.mostrarInfo()
    println()
    rectangulo.ancho = 10.0
    rectangulo.alto = 5.0
    println("Despues de cambiar dimensiones: ")
    rectangulo.mostrarInfo()
    println()
    println("--- Ejemplo 2: Setter con Validación ---\n")
    val persona = Persona4("Carlos", 25)
    persona.mostrarInfo()
    println()
    persona.nombre = ""
    persona.edad = 150
    persona.edad = -5
    println()
    persona.nombre = "Pedro"
    persona.edad = 30
    persona.mostrarInfo()
    println()
    println("--- Ejemplo 3: Temperatura ---\n")
    val temp = Temperatura()
    temp.celsius = 25.0
    temp.mostrarTemperatur()
    println()
    temp.fahrenheit = 86.0
    temp.mostrarTemperatur()
    println()
    println("--- Ejemplo 4: Email con Formato ---\n")
    val usuario = Usuario4(
        "Juan", "Juan@Mail.com"
    )
    usuario.mostrarInfo()
    println()
    println("--- Ejemplo 5: Cuenta Bancaria ---\n")
    val cuenta = CuentaBancaria4("María García", 1000.0)
    println("Saldo inicial:  ${cuenta.saldo}")
    println()
    cuenta.depositar(500.0)
    cuenta.retirar(300.0)
    println()
    println("--- Ejemplo 6: Nombre Completo ---\n")
    val personaCompleta = PersonaCompleta("Ana", "Martinez")
    personaCompleta.mostrarInfo()
    println()
    personaCompleta.nombre = "María"
    personaCompleta.apellido = "López"
    personaCompleta.mostrarInfo()
    println()
    println("--- Ejemplo 7: Producto con Descuento ---\n")
    val usuarioSeguro = UsuarioSeguro("admin")
    usuarioSeguro.password = "123"
    usuarioSeguro.password = "password"
    usuarioSeguro.password = "password123"
    usuarioSeguro.password = "Password.123"
    println()
    usuarioSeguro.mostrarInfo()
}