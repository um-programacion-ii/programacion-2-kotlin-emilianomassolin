
package org.example

class Coche(private var _marca: String = "Ford", private var _modelo: Int = 2020) {
    var marca: String
        get() = _marca
        set(value) {
            _marca = value
        }
    var modelo: Int
        get() = _modelo
        set(value) {
            _modelo = value
        }
}
interface Perimetrable {
    fun calcularPerimetro(): Double
}
class Rectangulo(val ancho: Double, val alto: Double) : Perimetrable {
    var area: Double

    // El bloque init se usa para inicializar propiedades o ejecutar código en la creación.
    init {
        // 'area' se calcula una vez cuando se crea el objeto.
        area = ancho * alto
        println("Se ha creado un rectángulo de $ancho x $alto con un área de $area")
    }

    // Un método de la clase
    fun describir() {
        println("Este es un rectángulo.")
    }

    // Un método que realiza un cálculo
    override fun calcularPerimetro(): Double {
        return 2 * (ancho + alto)
    }
}
class Circulo(val radio: Double) : Perimetrable {
    override fun calcularPerimetro(): Double {
        return 2 * Math.PI * radio
    }
}

fun main() {
    val coche = Coche("Chevrolet", 2025)
    println("Marca ${coche.marca}")
    println("Modelo ${coche.modelo}")

    val rectangulo = Rectangulo(5.0, 3.0)
    rectangulo.describir()
    println("Área: ${rectangulo.area}")
    println("Perímetro: ${rectangulo.calcularPerimetro()}")

    // Crear una lista de Perimetrable con un Rectangulo y un Circulo
    val figuras: List<Perimetrable> = listOf(
        Rectangulo(4.0, 2.0),
        Circulo(1.5)
    )
    figuras.forEach { figura ->
        println("Perímetro: ${figura.calcularPerimetro()}")
    }
}
