package com.example.task_2

import android.health.connect.datatypes.HeightRecord
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.task_2.ui.theme.Task2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Container()
        }
    }
}

@Composable
fun Container(){
    Row(
        modifier = Modifier.padding(10.dp).border(1.dp, Color.Red, RoundedCornerShape(10.dp)).fillMaxWidth().height(120.dp)
    ){
       Column(
           modifier = Modifier.padding(10.dp).border(1.dp, Color.Blue, RoundedCornerShape(10.dp))
       ) {
           Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "")
       }
        Column (
            modifier = Modifier.padding(10.dp).border(1.dp, Color.Red, RoundedCornerShape(10.dp)).fillMaxHeight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row (
                modifier = Modifier.padding(10.dp).border(1.dp, Color.Red, RoundedCornerShape(10.dp)).fillMaxWidth(1f)
            ){
                Text(modifier = Modifier.padding(3.dp), text = "Muhammad Ali", fontWeight = FontWeight.Bold)
            }
            Row (
                modifier = Modifier.padding(10.dp).border(1.dp, Color.Red, RoundedCornerShape(10.dp)).fillMaxWidth(1f)
            ){
                Text( modifier = Modifier.padding(3.dp),text = "Semester VIII Computer Science")
            }
        }
    }
}