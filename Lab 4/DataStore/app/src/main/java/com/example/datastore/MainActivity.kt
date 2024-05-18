package com.example.datastore

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.datastore.ui.theme.DataStoreTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.util.function.LongUnaryOperator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Container(this)
        }
    }
}

@Composable
fun Container(context: Context){


    val corotineScope = CoroutineScope(Dispatchers.IO + SupervisorJob())



//    var CounterValue by rememberSaveable { mutableStateOf(0) }
//
//    LaunchedEffect(Unit){
//        CounterValue = DatastoreManager.getCounter(context)
//
//    }

//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//        Text(text = "Store & Retrieve Data using DataStore")
//        Row (
//            modifier = Modifier.padding(10.dp),
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically
//        ){
//
//            TextField(value = CounterValue.toString(),
//                onValueChange = {},
//                modifier = Modifier.fillMaxWidth(.5f),
//                label = { Text("Key") },
//                enabled = false,
//            )
//
//            Button(onClick = {
//                corotineScope.launch {
//                    DatastoreManager.incrementCounter(context)
//                    CounterValue = DatastoreManager.getCounter(context)
//                }
//            }) {
//                Text(text = "Increment")
//            }
//
//            Row(
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically
//            ){
//                Button(onClick = {
//                    corotineScope.launch {
//                        DatastoreManager.incrementCounter(context)
//                        CounterValue = DatastoreManager.getCounter(context)
//                    }
//                }) {
//                    Text(text = "Increment")
//                }
//            }
//
//        }
//    }

    var username by rememberSaveable { mutableStateOf("") }
    var age by rememberSaveable { mutableStateOf("") }

    var user by rememberSaveable {
        mutableStateOf(Pair("", 0))
    }

    LaunchedEffect(key1 = user){
        Toast.makeText(context, "User: ${user.first} ${user.second}", Toast.LENGTH_SHORT).show()
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Save & Retrieve User Data using DataStore")
        TextField(value = username,
            onValueChange = { username = it },
            modifier = Modifier.fillMaxWidth(.5f),
            label = { Text("Username") },
        )

        TextField(value = age,
            onValueChange = { age = it },
            modifier = Modifier.fillMaxWidth(.5f),
            label = { Text("Age") },
        )

       Button(onClick = {
                corotineScope.launch {
                    DatastoreManager.saveUser(context, username, age.toInt())
                }
                Toast.makeText(context, "User Data Saved", Toast.LENGTH_SHORT).show()
            }
       ) {
                Text(text = "Save User Data")
            }

       Button(onClick = {
                corotineScope.launch {
                    val userL = DatastoreManager.getUser(context)
                    age = userL.second.toString()
                    username = userL.first

                    user = userL
                }

       }) {
           Text(text ="Get User Data")
       }

    }
}