package org.example

import java.io.FileNotFoundException
import java.nio.file.Files
import java.nio.file.Paths

class EjercicioExcepciones {

    // ejercicio 1
    fun divisionSegura(numerador: Double, divisor: Double): Double =
        if (divisor == 0.0) throw ArithmeticException("division por cero no permitida") else (numerador / divisor)


    // ejercicio 2
    fun convertirCadenaANumero(cadena: String): Double = try {
        cadena.toDouble()
    } catch (e: Exception) {
        throw NumberFormatException("Cadena a convertir invalida")
    }

    // ejercicio 3
    fun validarEdad(edad: Int) =
        if (edad in 0..120) "Edad valida" else throw IllegalArgumentException("La edad debe estar entre 0 y 120")

    // ejercicio 4
    fun leerArchivo(ruta: String): String {
        var contenido: String = ""
        try {
            val path = Paths.get(ruta)
            Files.readAllLines(path, Charsets.UTF_8).forEach { contenido.plus(it) }
            return contenido
        } catch (e: Exception) {
            throw FileNotFoundException("El archivo no fue encontrado")
        }
    }

    // ejercicio 5
    fun validarNombreUsuario(nombreUsuario: String): Boolean =
        if (nombreUsuario.length < 5) throw InvalidUsernameException("El nombre de usuario debe tener al menos 5 caracteres") else true

    // ejercicio 6
    fun calcularPromedio(lista: List<Int>): Double =
        if (lista.isEmpty()) throw IllegalArgumentException("La lista no puede estar vacia") else (lista.sum() / lista.size).toDouble()

    // ejercicio 7
    fun dividirString(numerador: String, divisor: String): Double = try {
        numerador.toDouble() / if (divisor.toDouble() == 0.0) throw ArithmeticException("No puede dividir por cero") else divisor.toDouble()
    } catch (e: Exception) {
        throw NumberFormatException("La cadena no puede convertirse a un número")
    }


}

