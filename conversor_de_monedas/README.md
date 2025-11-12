# 🪙 Conversor de Monedas — Desafío ONE - Java

## 📋 Descripción
Este proyecto forma parte del programa **Oracle Next Education (ONE)** en conjunto con **Alura Latam**.  
El objetivo es construir una aplicación en **Java** que realice la **conversión de divisas en tiempo real**, utilizando la API de [ExchangeRate-API](https://www.exchangerate-api.com/).

La aplicación permite al usuario seleccionar monedas, ingresar un valor y obtener el resultado convertido según la tasa de cambio actual.

---

## 🧩 Tecnologías utilizadas
- **Java 17**
- **Gson** (para parsear JSON)
- **HTTPURLConnection** (para consumir la API)
- **ExchangeRate API** (fuente de datos de tasas de cambio)

---

## ⚙️ Estructura del proyecto
El proyecto está organizado en paquetes para mantener un código limpio y legible:

```
src/
 ├── api/
 │    └── ApiClient.java           # Maneja las solicitudes HTTP a la API
 ├── modelos/
 │    └── Moneda.java              # Representa los datos de una moneda
 ├── servicios/
 │    └── ConversorService.java    # Lógica de conversión de monedas
 ├── menu/
 │    └── Menu.java                # Interfaz de usuario en consola
 └── Main.java                     # Punto de entrada del programa
```

---

## 🚀 Ejecución del programa

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/tuusuario/conversor-monedas.git
   cd conversor-monedas
   ```

2. **Abrir en tu IDE** (Eclipse, IntelliJ o VS Code)

3. **Agregar la dependencia de Gson**
   Si usás Maven, en tu `pom.xml` incluí:
   ```xml
   <dependency>
     <groupId>com.google.code.gson</groupId>
     <artifactId>gson</artifactId>
     <version>2.10.1</version>
   </dependency>
   ```

4. **Ejecutar el programa**
   Corre la clase `Main.java`.

---

## 💡 Ejemplo de uso
```
===============================
    CONVERSOR DE MONEDAS
===============================
1. Dólar (USD) → Peso Argentino (ARS)
2. Peso Argentino (ARS) → Dólar (USD)
3. Dólar (USD) → Real Brasileño (BRL)
4. Real Brasileño (BRL) → Dólar (USD)
5. Salir

Seleccione una opción: 1
Ingrese el valor que desea convertir: 100
Resultado: 100 USD = 95.000 ARS
```

---

## 🧠 Aprendizajes aplicados
- Consumo de **API REST** en Java.
- Análisis de **respuestas JSON** con **Gson**.
- Aplicación de **buenas prácticas de modularidad y separación de responsabilidades**.
- Uso de **excepciones y validaciones** para evitar errores comunes.

---

## ✨ Autor
Desarrollado por **Facundo Orona**  
Como parte del programa **Oracle Next Education (ONE) + Alura Latam**  
📅 2025
