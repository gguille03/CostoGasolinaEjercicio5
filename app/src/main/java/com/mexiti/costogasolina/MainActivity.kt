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
           value = "10.0",
           onValueChanged = {}
       )
       EditNumberField(
           label = R.string.litros,
           leadingIcon = R.drawable.gasolina ,
           keyboardsOptions = KeyboardOptions.Default.copy(
               keyboardType = KeyboardType.Number,
               imeAction = ImeAction.Next
           ) ,
           value = "10",
           onValueChanged = {}
       )
       EditNumberField(
           label = R.string.propina,
           leadingIcon = R.drawable.outline_18_up_rating_24,
           keyboardsOptions = KeyboardOptions.Default.copy(
               keyboardType = KeyboardType.Number,
               imeAction = ImeAction.Done
           ) ,
           value = "0",
           onValueChanged = {}
       )
        Switch(
            checked = false,
            onCheckedChange =  {}
        )
        Text(
            text = "Total:  $"
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


private fun CalcularMonto(precio: Double, cantLitros: Double ): String{
    val monto = precio * cantLitros
    return NumberFormat.getCurrencyInstance().format(monto)

}
@Preview(showBackground = true)
@Composable
fun CostGasLayoutPreview() {
    CostoGasolinaTheme {
        CostGasLayout()
    }
}