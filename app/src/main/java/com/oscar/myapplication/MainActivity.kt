package com.oscar.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oscar.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Columns(modifier = Modifier.padding(innerPadding));
                }
            }
        }
    }
}

//EJEMPLO DE MODIFIERS
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Text(
        text = "Hello $name!",
        modifier = modifier
            .background(color = Color.Blue)
            .padding(15.dp)
            .clickable { println("Boton clickeado") }
    )
}

//EJEMPLO DE ALIGNMENT Y BOXES
@Composable
fun Boxes(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red), contentAlignment = Alignment.Center){

        Box (modifier = Modifier
            .background(Color.Gray)
            .width(30.dp)
            .height(30.dp),
            contentAlignment = Alignment.Center
        ){
            Text(text = "A")
        }

    }

}

//EJEMPLO DE COLUMNAS
@Composable
fun Columns(modifier: Modifier){
 Column (modifier = Modifier
     .fillMaxSize()
     .verticalScroll(rememberScrollState())){
     Text(text = "Texto 1", modifier = Modifier
         .background(Color.Black)
         .height(100.dp)
         .fillMaxWidth())
     Text(text = "Texto 2", modifier = Modifier
         .background(Color.Gray)
         .height(100.dp)
         .fillMaxWidth())
     Text(text = "Texto 3", modifier = Modifier
         .background(Color.Red)
         .height(100.dp)
         .fillMaxWidth())
     Text(text = "Texto 4", modifier = Modifier
         .background(Color.Blue)
         .height(100.dp)
         .fillMaxWidth())
     Text(text = "Texto 4", modifier = Modifier
         .background(Color.Cyan)
         .height(100.dp)
         .fillMaxWidth())
     Text(text = "Texto 4", modifier = Modifier
         .background(Color.Green)
         .height(100.dp)
         .fillMaxWidth())
     Text(text = "Texto 4", modifier = Modifier
         .background(Color.Magenta)
         .height(100.dp)
         .fillMaxWidth())
     Text(text = "Texto 4", modifier = Modifier
         .background(Color.LightGray)
         .height(100.dp)
         .fillMaxWidth())
     Text(text = "Texto 4", modifier = Modifier
         .background(Color.LightGray)
         .height(100.dp)
         .fillMaxWidth())
     Text(text = "Texto 4", modifier = Modifier
         .background(Color.LightGray)
         .height(100.dp)
         .fillMaxWidth())
     Text(text = "Texto 4", modifier = Modifier
         .background(Color.LightGray)
         .height(100.dp)
         .fillMaxWidth())
     Text(text = "Texto 4", modifier = Modifier
         .background(Color.LightGray)
         .height(100.dp)
         .fillMaxWidth())

 }

}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Columns(Modifier);
    }
}