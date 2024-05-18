package com.example.internalstorage

import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.internalstorage.ui.theme.InternalStorageTheme

class MainActivity : ComponentActivity() {

    private val filename = "ExampleFile.txt"

    private fun saveNote(note: String) {
        openFileOutput(filename, Context.MODE_PRIVATE).use {
            it.write(note.toByteArray())
        }
    }

    private fun loadNote(): String {
        val loadnote  = openFileInput(filename).use {
            val note = it.readBytes().toString(Charsets.UTF_8)
            note
        }
        return loadnote
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Container(saveNote = { saveNote(it) }, { loadNote()} )
        }
    }
}





@Composable
fun Container( saveNote: (String) -> Unit , loadNote: () -> String){

    var note by rememberSaveable {
        mutableStateOf("")
    }
    var loadedNote by rememberSaveable {
        mutableStateOf("")
    }



    Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp, 100.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(
            value = note,
            onValueChange = {
                note = it
            },
            label = { Text("Enter your note") }
        )

        Button(onClick = {
            saveNote(note)
        }) {
            Text("Save Note")
        }
        Button(onClick = {
            loadedNote = loadNote()
        }) {
            Text("Load Note")
        }

        TextField(value = loadedNote, onValueChange = {})



    }
}