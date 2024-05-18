package com.example.task1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField

import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.task1.ui.theme.Task1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginScreen(this)
        }
    }
}


@Composable
fun LoginScreen(context: Context) {
    val darkTurquoise = Color(0xFF045D56)
    val offWhite = Color(0xFFECEFF1)
    val white = Color.White

    Surface(color = darkTurquoise, modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TextField(
                value = "",
                onValueChange = {},
                label = {
                    Text(
                        "Email",
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyLarge
                    )
                },

                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = "",
                onValueChange = {},
                label = {
                    Text(
                        "Password",
                        color = Color.Black,
                        style = MaterialTheme.typography.bodyLarge
                    )
                },

                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { /* Handle action */ }),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Handle login */ },
                colors = ButtonDefaults.buttonColors(containerColor = white),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("LOGIN", color = darkTurquoise, style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.height(8.dp))
            TextButton(onClick = {
                val intent = Intent(context, RegisterActivity::class.java)
                context.startActivity(intent)
            }) {
                Text(
                    "Not a member? Sign up now.",
                    color = white,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}