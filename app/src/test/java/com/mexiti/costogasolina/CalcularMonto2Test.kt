package com.mexiti.costogasolina
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class CalcularMonto2Test {
    @Test
    fun  calcularMonto22_35_40l(){
        val precio = 22.35
        val cantLitros = 40.0
        val darPropina = false
        val propina = 0.0

        val montoEsperado = NumberFormat.getCurrencyInstance().format(894.0)
        val montoActual = calcularMonto(precio, cantLitros, darPropina, propina)

        assertEquals(montoEsperado, montoActual)
    }
}