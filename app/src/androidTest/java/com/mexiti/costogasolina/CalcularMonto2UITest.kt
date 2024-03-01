package com.mexiti.costogasolina
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.mexiti.costogasolina.ui.theme.CostoGasolinaTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat
class CalcularMonto2UITest {

    @get:Rule //leer algo
    val composeTextRule = createComposeRule()
    @Test
    fun CalcularMonto22_35_40l(){
        composeTextRule.setContent {
            CostoGasolinaTheme {
                CostGasLayout()

            }
        }
        composeTextRule.onNodeWithText("Ingresa precio por litro de Gasolina")
            .performTextInput("22.35")
        composeTextRule.onNodeWithText("Litros")
            .performTextInput("40")
        val montoEsperado = NumberFormat.getCurrencyInstance().format(894.0)

        composeTextRule.onNodeWithText("Monto Total: $montoEsperado").
        assertExists("No se encontro ningun nodo con el texto señalado")
    }
}