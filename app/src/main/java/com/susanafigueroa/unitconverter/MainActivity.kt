package com.susanafigueroa.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.susanafigueroa.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ){
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter(){

    var inputQuantity by remember {
        mutableStateOf("")
    }

    var unitOrigin by remember {
        mutableStateOf("")
    }

    var unitConvert by remember {
        mutableStateOf("")
    }

    var result by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))

        Row {

            OutlinedTextField(
                value = inputQuantity,
                onValueChange = {},
                label = {
                    Text("Enter your quantity")
                },
                readOnly = false
            )

            Spacer(modifier = Modifier.width(8.dp))

            Box {
                var expanded_menu by remember {
                    mutableStateOf(false)
                }

                Button(onClick = { expanded_menu = true }) {
                    Text(unitOrigin)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(
                    expanded = expanded_menu,
                    onDismissRequest = { expanded_menu = false }) {
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = {
                        unitOrigin = "cm"
                        expanded_menu = false
                    })
                    DropdownMenuItem(text = { Text("Meters") }, onClick = {
                        unitOrigin = "m"
                        expanded_menu = false
                    })
                    DropdownMenuItem(text = { Text("Feet") }, onClick = {
                        unitOrigin = "feet"
                        expanded_menu = false
                    })
                    DropdownMenuItem(text = { Text("Milimeters") }, onClick = {
                        unitOrigin = "mm"
                        expanded_menu = false
                    })
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        result = obtainResult(inputQuantity, unitOrigin, unitConvert)

        Row {

            OutlinedTextField(
                value = result,
                onValueChange = {},
                readOnly = true,
                label = {
                    Text("Result")
                }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Box {

                var expanded_menu by remember {
                    mutableStateOf(false)
                }

                Button(onClick = { expanded_menu = true }) {
                    Text(unitConvert)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(
                    expanded = expanded_menu,
                    onDismissRequest = { expanded_menu = false }) {
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = {
                        unitConvert = "cm"
                        expanded_menu = false
                    })
                    DropdownMenuItem(text = { Text("Meters") }, onClick = {
                        unitConvert = "m"
                        expanded_menu = false
                    })
                    DropdownMenuItem(text = { Text("Feet") }, onClick = {
                        unitConvert = "feet"
                        expanded_menu = false
                    })
                    DropdownMenuItem(text = { Text("Milimeters") }, onClick = {
                        unitConvert = "mm"
                        expanded_menu = false
                    })
                }
            }
        }
    }
}

fun obtainResult(quantity: String, unitOrigen: String, converterTo: String): String {
    val result = quantity + unitOrigen + converterTo
    return result
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}