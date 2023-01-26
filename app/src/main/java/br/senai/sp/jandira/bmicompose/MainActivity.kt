package br.senai.sp.jandira.bmicompose

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmicompose.ui.theme.BMIComposeTheme
import kotlinx.coroutines.selects.select

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMIComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var valueOfTextField = remember { mutableStateOf("") }
    var nameState = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.background(color = Color.White),
//        verticalArrangement = Arrangement.SpaceBetween
    ) {
//        for (x in 1 .. 2) {  // Loop in Kotlin
//            Text(
//                text = "Hello $name! - $x",
//                fontSize = 48.sp,
//                color = MaterialTheme.colors.primary
//            )
//        }
        
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color.LightGray)
//            ,
//            Arrangement.SpaceEvenly,
//            Alignment.CenterVertically,
//
//        ) {
//            for (x in 1 .. 3) {
//                Button(
//                    onClick = { },
//                    modifier = Modifier.height(48.dp),
//                    shape = CircleShape,
//                    colors = ButtonDefaults.buttonColors(Color.DarkGray)
//                ) {
//                    Row(
//
//                    ) {
//                        Text(text = "botao $x", color = Color.White)
//                    }
//                }
//            }
//        }
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
            ,
            backgroundColor = MaterialTheme.colors.primary
        ) {
            Column(
                Modifier.padding(start = 10.dp, end = 10.dp, top = 32.dp, bottom = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {

                TextField(
                    value = valueOfTextField.value,
                    onValueChange = {valueOfTextField.value = it},
                    Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = nameState.value,
                    onValueChange = {nameState.value = it},
                    Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp)
                )

                Button(
                    onClick = { nameState.value = ""
                              valueOfTextField.value = "" },
                    colors = ButtonDefaults.buttonColors(Color.DarkGray)
                ) {
                    Row (
                        Modifier.fillMaxWidth().height(40.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ){
                        Icon(imageVector = Icons.Rounded.Delete, contentDescription = "clear", modifier = Modifier.padding(end = 10.dp))
                        Text(text = "Limpar")
                    }

                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BMIComposeTheme {
        Greeting("Android")
    }
}