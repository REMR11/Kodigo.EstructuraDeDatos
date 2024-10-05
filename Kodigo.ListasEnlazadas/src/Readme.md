# Lista Enlazada Simple en Java

Este proyecto ha sido desarrollado por el equipo 6 integrantes:

* **Escobar Cisneros, Lisbeth**
* **Mejía Reinosa, Ronald Eduardo**
* **Salguero Hernández, Alejandra Marisol**
* **Salguero Hernández, Mario Enrique**

## Descripción del Proyecto

Este proyecto es una implementación de una lista enlazada simple en Java, desarrollada como tarea práctica para el Bootcamp Java 18 de KODIGO.ORG.

## Instructores

* **Oscar Lemus**
* **Eduardo Calle**

## Tecnologías Utilizadas

* **Lenguaje de programación:** Java

## Estructura de la Lista Enlazada

La lista enlazada simple implementada en este proyecto consta de tres clases: `Nodo.java`, `ListaEnlazadaSimple.java` y `Main.java`.

* **Nodo.java**: Representa un nodo individual en la lista enlazada. Cada nodo contiene un atributo `int dato` que almacena un valor entero y un atributo `Nodo siguiente` que apunta al siguiente nodo en la lista.
* **ListaEnlazadaSimple.java**: Representa la lista enlazada en sí misma. Contiene métodos para manipular la lista, incluyendo:
	+ `insertarAlInicio(int dato)`: Agrega un nuevo nodo al inicio de la lista con el valor especificado.
	+ `eliminarAlInicio()`: Elimina el nodo al inicio de la lista.
	+ `imprimirLista()`: Imprime la lista enlazada completa.
* **Main.java**: Clase principal que invoca los métodos de la clase `ListaEnlazadaSimple.java` para demostrar su funcionamiento.

## Instrucciones para Compilar y Ejecutar el Código

1. Compilar el proyecto utilizando el comando `javac` en la carpeta raíz del proyecto:
 ~~~Java
javac Nodo.java ListaEnlazaSimple.java Main.java
 ~~~  
2. Ejecutar la clase `Main` utilizando el comando `java`:
~~~java
java main
~~~
## Código de la Clase Main

```java
public class Main {
    public static void main(String[] args) {
        ListaEnlazadaSimple lista = new ListaEnlazadaSimple();

        // Insertar nodos al inicio de la lista
        lista.insertarAlInicio(5);
        lista.insertarAlInicio(10);
        lista.insertarAlInicio(15);

        // Imprimir la lista
        lista.imprimirLista();

        // Eliminar el nodo al inicio de la lista
        lista.eliminarAlInicio();

        // Imprimir la lista nuevamente
        lista.imprimirLista();
    }
}
```
# Pruebas y Observaciones

## Descripción de las Pruebas Unitarias

Se han realizado pruebas unitarias para verificar el funcionamiento correcto de los métodos de la lista enlazada. Estas pruebas incluyen:

* Verificar que el método `insertarAlInicio` agregue correctamente un nuevo nodo al inicio de la lista.
* Verificar que el método `eliminarAlInicio` elimine correctamente el nodo al inicio de la lista.
* Verificar que el método `imprimirLista` imprima correctamente la lista enlazada completa.

## Resultados Esperados

* La lista enlazada se crea correctamente con los nodos agregados y eliminados según sea necesario.
* La lista enlazada se imprime correctamente en la consola.

## Observaciones Relevantes

* La implementación de la lista enlazada simple utiliza una estructura de datos dinámica, lo que significa que la lista puede crecer o decrecer según sea necesario.
* La lista enlazada no tiene un tamaño fijo, lo que la hace más eficiente en términos de memoria.
* La implementación de la lista enlazada simple no incluye métodos para buscar o eliminar nodos en posiciones específicas, lo que la hace más sencilla y fácil de implementar.
