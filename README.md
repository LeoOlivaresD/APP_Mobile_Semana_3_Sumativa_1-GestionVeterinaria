# Sistema de Gestión Veterinaria

Aplicación desarrollada en Kotlin para la gestión integral de clínicas veterinarias, facilitando el manejo de agendas, citas, consultas y administración de veterinarios.

## 📋 Descripción del Proyecto

Sistema de gestión veterinaria que permite administrar agendas de veterinarios, programar consultas, gestionar información de mascotas y sus dueños, con validaciones robustas y sistema de promociones.

## ✨ Características Principales

### Gestión de Agendas
- Sistema de agendas individuales por veterinario
- Gestión de citas y consultas programadas
- Organización eficiente de horarios

### Sistema de Validaciones
- **Validación de Email**: Verificación mediante expresión regular
- **Formateo de Teléfonos**: Formato automático para números chilenos (+56)
  - Soporta números de 9 dígitos (ej: 912345678)
  - Soporta números con código de país (ej: 56912345678)
- **Validación de Rangos de Fecha**: Verificación de días dentro de rangos específicos
- **Validación de Cantidades**: Rango permitido de 1 a 100 unidades
- **Sistema de Períodos Promocionales**: Detección automática de períodos de descuento

### Sistema de Promociones
- Anotación `@Promocionable` para productos y servicios
- Configuración flexible de descuentos
- Descripción personalizada de promociones

## 📱 Requisitos del Sistema

### Para Desarrollo:
- JDK 11 o superior
- Kotlin 1.8+
- IDE recomendado: IntelliJ IDEA o Android Studio

### Para Ejecución:
- Java Runtime Environment (JRE) 11+

## 🚀 Instalación y Ejecución

### 1. Clonar el Repositorio
```bash
git clone https://github.com/LeoOlivaresD/APP_Mobile_Semana_3_Sumativa_1-GestionVeterinaria.git
cd APP_Mobile_Semana_3_Sumativa_1-GestionVeterinaria
```

### 2. Compilar el Proyecto
```bash
kotlinc -include-runtime -d GestionVeterinaria.jar *.kt
```

### 3. Ejecutar la Aplicación
```bash
java -jar GestionVeterinaria.jar
```

O desde tu IDE:
- Abrir el proyecto
- Ejecutar la función `main()` del archivo principal

## 📂 Estructura del Proyecto

```
APP_Mobile_Semana_3_Sumativa_1-GestionVeterinaria/
│
├── model/
│   ├── Agenda.kt              # Gestión de agendas veterinarias
│   ├── Validaciones.kt        # Utilidades de validación
│   ├── Veterinaria.kt         # Clase principal del sistema
│   ├── Veterinario.kt         # Modelo de veterinario
│   ├── Consulta.kt            # Modelo de consulta
│   ├── Promocionable.kt       # Anotación para promociones
│   └── [otros modelos]
│
├── Main.kt                    # Punto de entrada de la aplicación
└── README.md
```

### Annotation Promocionable
```kotlin
@Promocionable(descuento = 0.15, descripcion = "Consulta con descuento")
```
Permite marcar servicios o productos con descuentos especiales.

## 📝 Ejemplos de Uso

### Validación de Email
```kotlin
val emailValido = Validaciones.validarEmail("cliente@veterinaria.cl")
// Retorna: true
```

### Formateo de Teléfono
```kotlin
val telefonoFormateado = Validaciones.formatearTelefono("912345678")
// Retorna: "+56 9 1234 5678"
```

### Validación de Período Promocional
```kotlin
val enPromocion = Validaciones.estaEnPeriodoPromocional(15, 10, 20)
// Retorna: true (día 15 está entre el 10 y 20)
```

## 🧪 Características de Validación

### Formato de Email
- Soporta letras, números y caracteres especiales (+, _, ., -)
- Requiere símbolo @
- Dominio válido con extensión de 2+ caracteres

### Formato de Teléfono Chileno
- Detecta números de 9 dígitos que comienzan con 9
- Detecta números con código de país 56
- Formatea automáticamente a: `+56 9 XXXX XXXX`

### Validación de Cantidades
- Rango permitido: 1 a 100 unidades
- Previene valores negativos o excesivos
