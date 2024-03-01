package com.mexiti.costogasolina

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.mexiti.costogasolina.ui.theme.CostoGasolinaTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class CalcularMontoUITest {

    @get:Rule //leer algo
    val composeTextRule = createComposeRule()
    @Test
    fun CalcularMonto23_94_20l(){
        composeTextRule.setContent {
            CostoGasolinaTheme {
                CostGasLayout()

            }
        }
        composeTextRule.onNodeWithText("Ingresa precio por litro de Gasolina")
            .performTextInput("23.94")
        composeTextRule.onNodeWithText("Litros")
            .performTextInput("20")
        val montoEsperado = NumberFormat.getCurrencyInstance().format(478.8)

        composeTextRule.onNodeWithText("Monto Total: $montoEsperado").
        assertExists("No se encontro ningun nodo con el texto señalado")
    }
}