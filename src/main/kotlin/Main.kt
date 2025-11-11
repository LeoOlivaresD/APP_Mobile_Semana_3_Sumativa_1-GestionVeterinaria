import model.*
import kotlin.reflect.full.findAnnotation

fun main() {
    println("=".repeat(60))
    println("SISTEMA DE VETERINARIA - DEMOSTRACIÓN DE FUNCIONALIDADES")
    println("=".repeat(60))

    // ========== PASO 1: REGEX Y RANGES ==========
    println("\n--- PASO 1: VALIDACIONES CON REGEX Y RANGES ---")

    print("Ingrese email del cliente: ")
    val emailInput = readlnOrNull() ?: "cliente@veterinaria.cl"

    if (Validaciones.validarEmail(emailInput)) {
        println("✓ Email válido: $emailInput")
    } else {
        println("✗ Email inválido. Usando email por defecto.")
    }

    print("Ingrese teléfono (ej: 912345678): ")
    val telefonoInput = readlnOrNull() ?: "912345678"
    val telefonoFormateado = Validaciones.formatearTelefono(telefonoInput)
    println("✓ Teléfono formateado: $telefonoFormateado")

    print("Ingrese día de consulta (1-31): ")
    val diaConsulta = readlnOrNull() ?: "15"
    val diaValido = Validaciones.validarRangoFecha("$diaConsulta-10", 1, 31)
    println("✓ Fecha ${if (diaValido) "válida" else "inválida"}")

    // ========== PASO 2: ANOTACIONES Y REFLECTION ==========
    println("\n--- PASO 2: ANOTACIONES Y REFLECTION ---")

    val medicamento1 = Medicamento("Antiparasitario", 15000.0, 50)
    val anotacion = Medicamento::class.findAnnotation<Promocionable>()

    if (anotacion != null) {
        println("✓ Clase Medicamento tiene anotación @Promocionable")
        println("  - Descuento: ${anotacion.descuento * 100}%")
        println("  - Descripción: ${anotacion.descripcion}")
        println("  - Precio original: $${medicamento1.precio}")
        println("  - Precio con descuento: $${medicamento1.calcularPrecioConDescuento()}")
    }

    // ========== PASO 3: OPERATOR OVERLOADING ==========
    println("\n--- PASO 3: SOBRECARGA DE OPERADORES ---")

    val medicamento2 = Medicamento("Vacuna Rabia", 8000.0, 30)
    println("Stock inicial medicamento1: ${medicamento1.stock}")

    val medicamentoConMasStock = medicamento1 + 20
    println("✓ Después de sumar 20 unidades: ${medicamentoConMasStock.stock}")

    // Crear cliente y pedidos
    val cliente1 = Cliente("Juan Pérez", emailInput, telefonoFormateado)
    val pedido1 = Pedido(1, cliente1, listOf(medicamento1), medicamento1.precio)
    val pedido2 = Pedido(2, cliente1, listOf(medicamento2), medicamento2.precio)

    println("\nTotal pedido 1: $${pedido1.total}")
    println("Total pedido 2: $${pedido2.total}")

    val pedidoCombinado = pedido1 + pedido2
    println("✓ Pedidos combinados - Total: $${pedidoCombinado.total}")
    println("  Medicamentos en pedido combinado: ${pedidoCombinado.medicamentos.size}")

    // ========== PASO 4: DESESTRUCTURACIÓN ==========
    println("\n--- PASO 4: DESESTRUCTURACIÓN ---")

    val (nombreCliente, emailCliente, telefonoCliente) = cliente1
    println("✓ Cliente desestructurado:")
    println("  - Nombre: $nombreCliente")
    println("  - Email: $emailCliente")
    println("  - Teléfono: $telefonoCliente")

    val (idPedido, clientePedido, medicamentosPedido, totalPedido) = pedido1
    println("\n✓ Pedido desestructurado:")
    println("  - ID: $idPedido")
    println("  - Cliente: ${clientePedido.nombre}")
    println("  - Cantidad de medicamentos: ${medicamentosPedido.size}")
    println("  - Total: $$totalPedido")

    // ========== PASO 5: EQUALS Y HASHCODE ==========
    println("\n--- PASO 5: COMPARACIÓN CON EQUALS Y HASHCODE ---")

    val cliente2 = Cliente("Juan Pérez", emailInput, telefonoFormateado)
    val cliente3 = Cliente("María González", "maria@gmail.com", "+56 9 8765 4321")

    println("¿cliente1 == cliente2? ${cliente1 == cliente2}")
    println("✓ Explicación: Mismo contenido, data class compara por valor")

    println("¿cliente1 == cliente3? ${cliente1 == cliente3}")
    println("✓ Explicación: Diferente contenido")

    println("\nHashCode cliente1: ${cliente1.hashCode()}")
    println("HashCode cliente2: ${cliente2.hashCode()}")
    println("✓ HashCodes iguales porque tienen el mismo contenido")

    val med1 = Medicamento("Antibiótico", 12000.0, 25)
    val med2 = Medicamento("Antibiótico", 12000.0, 25)
    val med3 = Medicamento("Antiinflamatorio", 9000.0, 15)

    println("\n¿medicamento 'Antibiótico' == otro 'Antibiótico'? ${med1 == med2}")
    println("¿medicamento 'Antibiótico' == 'Antiinflamatorio'? ${med1 == med3}")

    // ========== PASO 6: RESUMEN FINAL ==========
    println("\n" + "=".repeat(60))
    println("RESUMEN DE FUNCIONALIDADES IMPLEMENTADAS")
    println("=".repeat(60))
    println("✓ 1. Regex para validación de email")
    println("✓ 2. Regex para formateo de teléfono")
    println("✓ 3. Ranges para validación de fechas")
    println("✓ 4. Anotación @Promocionable")
    println("✓ 5. Reflection para leer anotaciones")
    println("✓ 6. Sobrecarga de operador + en Medicamento")
    println("✓ 7. Sobrecarga de operador + en Pedido")
    println("✓ 8. Desestructuración de Cliente")
    println("✓ 9. Desestructuración de Pedido")
    println("✓ 10. Equals y HashCode automáticos (data class)")
    println("=".repeat(60))
}
