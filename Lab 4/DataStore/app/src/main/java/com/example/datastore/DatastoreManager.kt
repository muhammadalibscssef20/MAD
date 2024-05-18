package com.example.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map


object DatastoreManager {

        private val Context.dataStore by preferencesDataStore(name = "settings")

        private val Counter = intPreferencesKey("counter")

        private val USERNAME = stringPreferencesKey("username")
        private val AGE = intPreferencesKey("age")


// saving user data
        suspend fun saveUser(context: Context, username: String, age: Int) {
            context.dataStore.edit { settings ->
                settings[USERNAME] = username
                settings[AGE] = age
            }
        }

    // get user data
        suspend fun getUser(context: Context): Pair<String, Int> {
            val user = context.dataStore.data.map { settings ->
                val username = settings[USERNAME] ?: ""
                val age = settings[AGE] ?: 0
                Pair(username, age)
            }
            return user.first()
        }
//
//// increment counter
//        suspend fun incrementCounter(context: Context) {
//            context.dataStore.edit { settings ->
//                val currentCounterValue = settings[Counter] ?: 0
//                settings[Counter] = currentCounterValue + 1
//            }
//        }
//
//
//// get counter value
//        suspend fun getCounter(context: Context): Int {
//            val counter = context.dataStore.data.map { settings ->
//                settings[Counter] ?: 0
//            }
//            return counter.first()
//        }
}

