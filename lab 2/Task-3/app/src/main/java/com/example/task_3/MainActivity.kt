package com.example.task_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task_3.ui.theme.Task3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyVerticalGridDemo()
        }
    }
}

@Composable
fun LazyVerticalGridDemo(){
    val list = (1..10).map { it.toString() }
    var imageTurn = false

    LazyVerticalGrid(
        columns = GridCells.Adaptive(256.dp),

        // content padding
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(list.size) { index ->
                Card(

                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),

                ) {
                    Row(
                        modifier = Modifier.padding(10.dp).fillMaxWidth().height(120.dp)
                    ){
                        Column(
                            modifier = Modifier.padding(10.dp)
                        ) {
                            val image = if (index %2 ==0)  R.drawable.ic_launcher_foreground else R.drawable.ic_launcher_background
                            Image(painter = painterResource(id = image), contentDescription = "")
                        }
                        Column (
                            modifier = Modifier.padding(10.dp).fillMaxHeight(1f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Row (
                                modifier = Modifier.padding(10.dp).fillMaxWidth(1f)
                            ){
                                Text(modifier = Modifier.padding(3.dp), text = "Muhammad Ali", fontWeight = FontWeight.Bold)
                            }
                            Row (
                                modifier = Modifier.padding(10.dp).fillMaxWidth(1f)
                            ){
                                val age = (index+1) * 10
                                Text( modifier = Modifier.padding(3.dp),text = "Age: $age")
                            }
                        }
                    }

                }
            }
        }
    )
}
