package com.oscar.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.oscar.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Filas(modifier = Modifier.padding(innerPadding))
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
     .verticalScroll(rememberScrollState()),
     verticalArrangement = Arrangement.SpaceBetween){
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

 }

}

//EJEMPLO DE FILAS
@Composable
fun Filas(modifier: Modifier){

    Row (modifier = Modifier.horizontalScroll(rememberScrollState())){
        Text(text = "Texto 1")
        Text(text = "Texto 2")
        Text(text = "Texto 3")
        Text(text = "Texto 4")
        Text(text = "Texto 5")
        Text(text = "Texto 6")
        Text(text = "Texto 7")
        Text(text = "Texto 9")
        Text(text = "Texto 10")
        Text(text = "Texto 11")
    }


}

//EJEMPLO QUE CONTIENE TODOS LOS TIPOS DE LAYOUTS
@Composable
fun ComplexLayout(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Gray)) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
            .weight(1f), contentAlignment = Alignment.Center){

            Text(text = "Ejemplo 1")
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)
            .weight(1f)){

            Row(modifier = Modifier.fillMaxWidth()){
                Box(modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Black), contentAlignment = Alignment.Center){
                    Text(text = "Ejemplo 2", color = Color.White)
                }
                Box(modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.Green), contentAlignment = Alignment.Center){
                    Text(text = "Ejemplo 3")
                }
            }

        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .weight(1f), contentAlignment = Alignment.BottomCenter){

            Text(text = "Ejemplo 4");
        }
    }
}

//EJEMPLO CON CONSTRAINT LAYOUT
@Composable
fun FunConstraint(){

    ConstraintLayout (modifier = Modifier.fillMaxSize()){

        val (box_red, box_blue, box_yellow, box_magenta, box_black) = createRefs();

        Box(modifier = Modifier.size(125.dp).background(Color.Red).constrainAs(box_red){
            top.linkTo(parent.top);
            bottom.linkTo(parent.bottom);
            start.linkTo(parent.start);
            end.linkTo(parent.end);
        }){}

        Box(modifier = Modifier.size(125.dp).background(Color.Blue).constrainAs(box_blue){
            top.linkTo(box_red.bottom)
            start.linkTo(box_red.end)
        }){}

        Box(modifier = Modifier.size(125.dp).background(Color.Black).constrainAs(box_black){
            top.linkTo(box_red.bottom)
            end.linkTo(box_red.start)
        }){}

        Box(modifier = Modifier.size(125.dp).background(Color.Yellow).constrainAs(box_yellow){
            bottom.linkTo(box_red.top)
            end.linkTo(box_red.start)
        }){}

        Box(modifier = Modifier.size(125.dp).background(Color.Magenta).constrainAs(box_magenta){
            bottom.linkTo(box_red.top);
            start.linkTo(box_red.end)
        }){}
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        FunConstraint()
    }
}