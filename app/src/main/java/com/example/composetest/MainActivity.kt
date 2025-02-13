package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.example.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    
                }
            }
        }
    }

    //buildannotatedString: metnin bir bolumunu farkli stillendirmek icin
@Composable
fun SuperScriptText(
    normalText : String,
    normalFontSize: TextUnit = MaterialTheme.typography.bodyLarge.fontSize,
    superText: String,
    superTextFontSize: TextUnit  = MaterialTheme.typography.bodySmall.fontSize,
    superTextFontWeight: FontWeight = FontWeight.Normal
) {
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = normalFontSize
            )
        ) {
            append(normalText)
        }
        withStyle(
            style = SpanStyle(
                fontSize = superTextFontSize,
                fontWeight = superTextFontWeight,
                baselineShift = BaselineShift.Superscript
            )
        ){
            append(superText)
        }
    })
}

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeTestTheme {
            SuperScriptText(normalText = "Hello", superText = "Compose", superTextFontWeight = FontWeight.Bold)
        }
    }
}