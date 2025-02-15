package com.example.composetest

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import com.example.composetest.ui.theme.color1
import com.example.composetest.ui.theme.color2

@Composable
fun GradientButton(
    text: String,
    textColor: Color,
    gradient: Brush,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        onClick = {onClick()},
        modifier = Modifier.wrapContentWidth()
    ) {
        Box(modifier = Modifier
            .background(gradient)
            .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ){
            Text(text, color = textColor)
        }
    }
}

@Preview
@Composable
fun GradientButtonPreview() {
    GradientButton(text = "Button", textColor = Color.White, gradient = Brush.horizontalGradient(
        colors = listOf(
            color1, color2
        )
    )) { }
}