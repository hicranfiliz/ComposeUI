package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.example.composetest.ui.theme.ComposeTestTheme
import com.example.composetest.ui.theme.color1
import com.example.composetest.ui.theme.color2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Row(
                       modifier = Modifier.fillMaxSize(),
                       verticalAlignment = Alignment.CenterVertically,
                       horizontalArrangement = Arrangement.Center
                   ) {
                       GradientButton(text = "Button", textColor = Color.White, gradient = Brush.horizontalGradient(
                           colors = listOf(
                               color1, color2
                           )
                       )) { }
                       Button(onClick = {}) {
                           Text("Button 2")
                       }
                   }
                }
            }
        }
    }

    @Composable
    fun Greeting(){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var password by rememberSaveable {mutableStateOf("")}
            var passwordVisibility by remember { mutableStateOf(false) }

            val icon = if(passwordVisibility)
                painterResource(id = R.drawable.paper_plane)
            else
                painterResource(id = R.drawable.minus)

             OutlinedTextField(
                 value = password,
                 onValueChange = {
                     password = it
                 },
                 placeholder = { Text("Password", color = Color.Black) },
                 label = { Text("Password", color = Color.Black) },
                 trailingIcon = {
                     IconButton(onClick = {
                         passwordVisibility = !passwordVisibility
                     }) {
                         Icon(
                             painter = icon,
                             contentDescription = "Visibilty Icon",
                             tint = Color.Black
                         )
                     }
                 },
                 keyboardOptions = KeyboardOptions(
                     keyboardType = KeyboardType.Password
                 ),
                 visualTransformation = if(passwordVisibility) VisualTransformation.None
                 else PasswordVisualTransformation()
             )
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeTestTheme {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            }
        }
    }
}