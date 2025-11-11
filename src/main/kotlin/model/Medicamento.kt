package model

@Promocionable(descuento = 0.20, descripcion = "Medicamento con 20% de descuento")
data class Medicamento(
    val nombre: String,
    val precio: Double,
    val stock: Int
) {
    // Sobrecarga del operador + para sumar stock
    operator fun plus(cantidad: Int): Medicamento {
        return this.copy(stock = this.stock + cantidad)
    }

    // Función para calcular precio con descuento si tiene la anotación
    fun calcularPrecioConDescuento(): Double {
        val anotacion = this::class.annotations.find { it is Promocionable } as? Promocionable
        return if (anotacion != null) {
            precio * (1 - anotacion.descuento)
        } else {
            precio
        }
    }
}
