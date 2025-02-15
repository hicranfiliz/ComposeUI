package com.example.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Column(
                       modifier = Modifier.fillMaxSize(),
                       verticalArrangement = Arrangement.Center,
                       horizontalAlignment = Alignment.CenterHorizontally
                   ) {
                       CoilImage()
                   }
                }
            }
        }
    }

    @Composable
    fun CoilImage(){
        Box(
            modifier = Modifier
                .height(150.dp)
                .width(150.dp),
            contentAlignment = Alignment.Center
        ) {
            val context = LocalContext.current
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(context)
                    .data("https://avatars.githubusercontent.com/u/14994036?v=4")
                    .placeholder(R.drawable.paper_plane)
                    .error(R.drawable.minus)
                    .crossfade(1000)
                    .transformations(CircleCropTransformation())
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .build()
            )
            var painterState = painter.state
            Image(painter = painter, contentDescription = "Logo Image")
//            if (painterState is AsyncImagePainter.State.Loading){
//                CircularProgressIndicator()
//            }
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
                CoilImage()
            }
        }
    }
}