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
                value = "",
                onValueChange = {}
            )

            Spacer(modifier = Modifier.width(8.dp))

            Box {
                var expanded_menu by remember {
                    mutableStateOf(false)
                }

                Button(onClick = { expanded_menu = true }) {
                    Text("")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(
                    expanded = expanded_menu,
                    onDismissRequest = { expanded_menu = false }) {
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("Meters") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("Feet") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("Milimeters") }, onClick = { /*TODO*/ })
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {

            Box {

                var expanded_menu by remember {
                    mutableStateOf(false)
                }

                Button(onClick = { expanded_menu = true }) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(
                    expanded = expanded_menu,
                    onDismissRequest = { expanded_menu = false }) {
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("Meters") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("Feet") }, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text("Milimeters") }, onClick = { /*TODO*/ })
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Result:")

    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}