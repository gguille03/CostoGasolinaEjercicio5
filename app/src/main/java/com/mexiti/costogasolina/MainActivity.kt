package com.mexiti.costogasolina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.mexiti.costogasolina.ui.theme.CostoGasolinaTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CostoGasolinaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CostGasLayout()
                }
            }
        }
    }
}

@Composable
fun CostGasLayout() {
    var precioLitroEntrada by remember {
        mutableStateOf("")
    }
    var cantLitrosEntrada by remember {
        mutableStateOf("")
    }
    var propinaEntrada by remember {
        mutableStateOf("")
    }
    var darPropina by remember {
        mutableStateOf(false)
    }

    val precioLitro = precioLitroEntrada.toDoubleOrNull() ?: 0.0
    val cantLitros = cantLitrosEntrada.toDoubleOrNull() ?: 0.0
    val propina = propinaEntrada.toDoubleOrNull() ?: 0.0
    val total = CalcularMonto(precioLitro,cantLitros, darPropina = darPropina, propina = propina)

    Column {
        Text(
            text = stringResource(R.string.calcular_monto),

            )
       EditNumberField(
           label = R.string.ingresa_gasolina,
           leadingIcon = R.drawable.money_gas ,
           keyboardsOptions = KeyboardOptions.Default.copy(
               keyboardType = KeyboardType.Number,
               imeAction = ImeAction.Next
           ),
           value = precioLitroEntrada,
           onValueChanged = {precioLitroEntrada = it}
       )
       EditNumberField(
           label = R.string.litros,
           leadingIcon = R.drawable.gasolina ,
           keyboardsOptions = KeyboardOptions.Default.copy(
               keyboardType = KeyboardType.Number,
               imeAction = ImeAction.Next
           ) ,
           value = cantLitrosEntrada,
           onValueChanged = {cantLitrosEntrada = it}
       )
       EditNumberField(
           label = R.string.propina,
           leadingIcon = R.drawable.outline_18_up_rating_24,
           keyboardsOptions = KeyboardOptions.Default.copy(
               keyboardType = KeyboardType.Number,
               imeAction = ImeAction.Done
           ) ,
           value = propinaEntrada,
           onValueChanged = {propinaEntrada = it}
       )
        Switch(
            checked = darPropina,
            onCheckedChange =  { darPropina = it }
        )
        Text(
            text = stringResource(R.string.monto_total,total)
        )

    }

}

@Composable
fun EditNumberField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    keyboardsOptions:KeyboardOptions,
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
){
    TextField(
        label = { Text(text = stringResource(id = label))  },
        value = value,
        singleLine = true,
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon) , contentDescription = null) },
        keyboardOptions = keyboardsOptions,
        modifier = modifier,
        onValueChange = onValueChanged
    )

}


private fun CalcularMonto(precio: Double, cantLitros: Double, darPropina: Boolean, propina:Double ): String{
    var monto = precio * cantLitros
    if ( darPropina){
        monto +=  propina
    }
    return NumberFormat.getCurrencyInstance().format(monto)

}
@Preview(showBackground = true)
@Composable
fun CostGasLayoutPreview() {
    CostoGasolinaTheme {
        CostGasLayout()
    }
}