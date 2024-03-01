package com.mexiti.costogasolina

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class CalcularMontoTest {
    @Test
fun  calcularMonto23_94_20l(){
        val precio = 23.94
        val cantLitros = 20.0
        val darPropina = false
        val propina = 0.0

        val montoEsperado = NumberFormat.getCurrencyInstance().format(478.8)
        val montoActual = calcularMonto(precio, cantLitros, darPropina, propina)

        assertEquals(montoEsperado, montoActual)
}



}