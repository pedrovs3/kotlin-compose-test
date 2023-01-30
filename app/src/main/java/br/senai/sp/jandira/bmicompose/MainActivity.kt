package br.senai.sp.jandira.bmicompose

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmicompose.ui.theme.BMIComposeTheme
import java.text.Normalizer.Form

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
                    Global()
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun Global() {
    var heightState by rememberSaveable() {
        mutableStateOf("")
    }
    var weightState by rememberSaveable() {
        mutableStateOf("")
    }

    Column( // Content
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Header
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.bmi),
                contentDescription = "Ícone da aplicação"
            )
            Text(
                text = stringResource(id = R.string.app_title),
                color = MaterialTheme.colors.primary,
                fontSize = 32.sp,
                letterSpacing = 4.sp,
                fontWeight = FontWeight(400),
                fontStyle = FontStyle(2)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Form
        Column(
            Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            horizontalAlignment = Alignment.Start
        ) {

//            TextFieldMain(idLabel = R.string.weight_label)
//
//            Spacer(modifier = Modifier.height(16.dp))

//            TextFieldMain(idLabel = R.string.height_label, state)
            Text(text = stringResource(id = R.string.weight_label))
            OutlinedTextField(value = weightState, onValueChange = { weightState = it},
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp, top = 3.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                singleLine = true,
                shape = RoundedCornerShape(16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

//            Text(text = stringResource(id = R.string.height_label))
            OutlinedTextField(value = heightState, onValueChange = { heightState = it},
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp, top = 3.dp),
                label = {
                        Text(text = stringResource(id = R.string.height_label))
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                singleLine = true,
                shape = RoundedCornerShape(16.dp)
            )

            Button(onClick = { /*TODO*/ },
                Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(68, 160, 36, 255)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.button_calculate),
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
        //Footer
        Column() {
            Card(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Column(
                    Modifier
                        .padding(16.dp)
                        .fillMaxSize()
                    ,
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                 Text(
                     text = stringResource(id = R.string.score_label),
                     fontSize = 20.sp,
                     fontWeight = FontWeight.Bold,
                     textAlign = TextAlign.Center
                 )
                Text(
                    text = "0.00",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Congratulations! Your weight is ideal",
                    Modifier.fillMaxWidth(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color(137, 119, 248)
                    )
                    ) {
                        Icon(imageVector = Icons.Rounded.Refresh, contentDescription = "")
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Reset")
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(Color(137, 119, 248))
                    ) {
                        Icon(imageVector = Icons.Rounded.Share, contentDescription = "")
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Share")
                    }
                }
                }
            }
        }
    }
}


//@Composable
//fun TextFieldMain(idLabel : Int, state : String) {
//    Text(text = stringResource(id = idLabel))
//    OutlinedTextField(value = state, onValueChange = {state = it},
//        Modifier
//            .fillMaxWidth()
//            .padding(bottom = 5.dp, top = 3.dp),
//        shape = RoundedCornerShape(16.dp)
//    )
//}

//@Composable
//fun Header() {
//    Column(
//        Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.bmi),
//            contentDescription = "Ícone da aplicação"
//        )
//        Text(
//            text = stringResource(id = R.string.app_title),
//            color = MaterialTheme.colors.primary,
//            fontSize = 32.sp,
//            letterSpacing = 4.sp,
//            fontWeight = FontWeight(400),
//            fontStyle = FontStyle(2)
//        )
//    }
//    Form()
//    Footer()
//}
//
//@Composable
//fun Form() {
//    Column() {
//        Text(text = "teste")
//    }
//}
//
//@Composable
//fun Footer() {
//    Column() {
//        Text(text = "teste2")
//    }
//}
//
//@Preview
//@Composable
//fun test() {
//    Row() {
//        for (x in 1 .. 3) {
//            Button(onClick = { /*TODO*/ }) {
//                Text(text = "Botao ${x}")
//            }
//        }
//    }
//}