# Robot en Grilla 🤖

Aplicación de escritorio en Java con interfaz gráfica en la que un robot se desplaza por una grilla buscando el camino optimo. Permite comparar distintos algoritmos de resolución y ver estadísticas de cada ejecución.

## Funcionalidades

- **Tablero interactivo:** visualización de la grilla y del recorrido del robot, que va dejando sus huellas.
- **Algoritmos de resolución:** [backtracking y fuerza bruta con poda]. Se pueden comparar entre sí.
- **Grillas aleatorias:** generador de grillas con números aleatorios.
- **Carga y guardado de archivos:** permite abrir y guardar grillas desde un selector de archivos.
- **Estadísticas:** [tiempo de ejecución / cantidad de pasos] de cada corrida.
- **Gráfico lineal:** visualización de las estadísticas con JFreeChart.
- **Tests:** pruebas de la lógica.

## Tecnologías

- Java
- Swing, con JGoodies Forms para los layouts
- JFreeChart y JCommon para los gráficos
- Eclipse

## Estructura

| Clase | Función |
|---|---|
| `Grilla` | Representa la grilla y sus reglas |
| `Posicion` | Posición dentro de la grilla |
| `SolverRobot` | Lógica de movimiento del robot |
| `SolverAlgoritmos` | Algoritmos de resolución |
| `GeneradorGrillaAleatoria`, `RandomNumeros` | Generación de grillas aleatorias |
| `Archivo` | Carga y guardado de grillas |
| `TableroElectronico` | Interfaz gráfica del tablero |

## Cómo ejecutarlo

1. Clonar el repositorio.
2. En Eclipse: **File → Import → Existing Projects into Workspace** y elegir la carpeta del proyecto.
3. Verificar que los `.jar` de la carpeta del proyecto estén en el Build Path.
4. Ejecutar la clase principal: `[clase con el main]`.

## Integrantes

- Natanael Andrés Otranto
- Maximiliano Martínez 
- Axel Santino Pattenden

## Contexto

Trabajo práctico final de programación 3, UNGS, 2025.
