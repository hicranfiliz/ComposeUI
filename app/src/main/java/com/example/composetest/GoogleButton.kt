package com.example.composetest

import android.service.autofill.OnClickAction
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Icon

@Composable
fun GoogleButton(
    text: String = "Sign Up with Google",
    loadingText: String = "Creating Account",
    icon: Painter = painterResource(id = R.drawable.ic_google_logo),
    shape : Shape = RoundedCornerShape(4.dp),
    borderColor : Color = Color.LightGray,
    backGroundColor : Color = MaterialTheme.colorScheme.surface,
    processIndicatorColor: Color = MaterialTheme.colorScheme.primary,
    onClicked: () -> Unit
) {
    var clicked by remember{ mutableStateOf(false) }

    Surface(
        onClick = {clicked = !clicked},
        shape = shape,
        border = BorderStroke(1.dp, color = borderColor),
        color = backGroundColor
    ) {
        Row(modifier = Modifier.padding(
            start = 12.dp,
            end = 16.dp,
            top = 12.dp,
            bottom = 12.dp
        ).animateContentSize(
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearOutSlowInEasing
            )
        ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Icon(
                painter = icon,
                contentDescription = "Google Button",
                tint = Color.Unspecified)
            Spacer(modifier = Modifier.width(8.dp))
            Text(if(clicked) loadingText else text)
            if(clicked){
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = processIndicatorColor
                )
                onClicked()
            }
        }
    }
}

@Composable
@Preview
private fun GoogleButtonPreview(){
    GoogleButton(
        text = "Sign Up with Google",
        loadingText = "Creating Account",
        onClicked = {})
}