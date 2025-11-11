# Sistema de Gestión de Veterinaria

Sistema desarrollado en Kotlin para digitalizar el flujo de trabajo de una veterinaria, permitiendo gestionar pacientes (mascotas), registrar consultas, gestionar agendas de veterinarios y aplicar promociones en medicamentos.

## 📋 Descripción

Esta aplicación permite a una veterinaria:
- Registrar información de dueños y mascotas
- Agendar consultas veterinarias
- Gestionar medicamentos con promociones
- Aplicar descuentos automáticos en períodos promocionales
- Prevenir duplicados de clientes
- Generar resúmenes completos de atenciones

## 🚀 Características Principales

### 1. **Validaciones con Regex y Ranges**
- Validación de correos electrónicos (formato: nombre@dominio.com)
- Formateo automático de teléfonos chilenos (+56 9 XXXX XXXX)
- Validación de cantidades (rango 1-100)
- Verificación de períodos promocionales (días 10-20 del mes)

### 2. **Anotaciones y Reflection**
- Anotación personalizada `@Promocionable` para medicamentos
- Cálculo dinámico de descuentos (20%)
- Análisis de clases mediante reflection (propiedades y métodos)

### 3. **Sobrecarga de Operadores**
- Operador `+` para combinar pedidos
- Operador `==` para comparar medicamentos
- Operador `+` para agregar stock a medicamentos

### 4. **Desestructuración**
- Extracción de datos de Cliente (nombre, email, teléfono)
- Extracción de datos de Pedido (id, cliente, medicamentos, total)

### 5. **Prevención de Duplicados**
- Sobrescritura de `equals()` y `hashCode()`
- Comparación personalizada de clientes por nombre y email
- Uso de Sets para evitar registros duplicados

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Kotlin
- **IDE**: IntelliJ IDEA
- **Build Tool**: Gradle
- **JDK**: Compatible con Java 8+

## 📦 Estructura del Proyecto

```
GestionVeterinaria/
├── src/
│   └── main/
│       └── kotlin/
│           ├── Main.kt
│           └── model/
│               ├── Agenda.kt
│               ├── Cliente.kt
│               ├── Consulta.kt
│               ├── Dueno.kt
│               ├── Mascota.kt
│               ├── Medicamento.kt
│               ├── Pedido.kt
│               ├── Promocionable.kt
│               ├── Validaciones.kt
│               ├── Veterinaria.kt
│               └── Veterinario.kt
└── build.gradle.kts
```

## Cómo Ejecutar

### Opción 1: Desde IntelliJ IDEA
1. Abre el proyecto en IntelliJ IDEA
2. Espera a que Gradle sincronice las dependencias
3. Ejecuta el archivo `Main.kt`
4. Sigue las instrucciones en la consola

### Opción 2: Desde Terminal
```bash
# Compilar el proyecto
./gradlew build

# Ejecutar la aplicación
./gradlew run
```

## 📖 Guía de Uso

### 1. **Registro de Dueño**
```
Nombre: Juan Pérez
Email: juan@email.com
Teléfono: 912345678
```
- El email debe tener formato válido
- El teléfono debe tener 9 dígitos y comenzar con 9
- Se formateará automáticamente a: +56 9 1234 5678

### 2. **Registro de Mascota**
```
Nombre: Rocky
Especie: Perro
Edad: 5 (rango 0-50)
Peso: 15.5 (rango 0.1-200 kg)
```

### 3. **Registro de Consulta**
```
Cantidad de productos: 2 (rango 1-100)
Tipo de atención:
  1. Consulta general ($15,000)
  2. Urgencia ($20,000)
  3. Vacunación ($10,000)
  4. Control ($12,000)
```

### 4. **Selección de Medicamento**
```
Medicamentos disponibles:
  1. Vacuna Rabia - $8,000
  2. Antiparasitario - $15,000
  3. Antiinflamatorio - $9,000
```
- Si estás entre los días 10-20 del mes, se aplica 20% de descuento automáticamente

### 5. **Resumen Final**
Al finalizar, verás:
- Resumen de todas las atenciones registradas
- Demostración de desestructuración de objetos
- Combinación de pedidos
- Prevención de duplicados

## 📊 Ejemplo de Salida

```
============================================================
SISTEMA DE VETERINARIA - FLUJO INTERACTIVO
============================================================

--- REGISTRO DE DUEÑO ---
✓ Dueño registrado: Juan Pérez, juan@email.com, +56 9 1234 5678

--- REGISTRO DE MASCOTA ---
✓ Mascota registrada: Rocky, Perro, 5 años, 15.5 kg

--- PROMOCIÓN DE MEDICAMENTO ---
✓ Medicamento promocionable: Antiinflamatorio
  - Descuento: 20.0%
  - Precio con descuento: $7200.0

============================================================
DEMOSTRACIÓN DE COMBINACIÓN DE PEDIDOS
============================================================
✓ Pedido Combinado: 2 medicamentos, total: $23000.0
```

## Funcionalidades Destacadas

### Validación Inteligente
```kotlin
// Email inválido
Email: usuario
✗ Email inválido. Debe tener formato nombre@dominio.com

// Email válido
Email: usuario@dominio.com
✓ Email válido
```

### Promociones Automáticas
Si el día actual está entre el 10 y 20 del mes, se aplica automáticamente un 20% de descuento en todos los medicamentos.

### Prevención de Duplicados
El sistema detecta y previene el registro de clientes duplicados basándose en nombre y email:
```
✓ Clientes únicos registrados: 2 (de 3 intentos)
  - Se previno 1 duplicado exitosamente
```

---

**Nota**: Para reportar problemas o sugerencias, contacta al desarrollador del proyecto.
