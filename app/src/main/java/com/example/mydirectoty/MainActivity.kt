package com.example.mydirectoty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mydirectoty.ui.theme.MyDirectotyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDirectotyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimatedCircle("Android")
                }
            }
        }
    }
}

@Composable
fun AnimatedCircle(name: String, modifier: Modifier = Modifier) {
    Spacer(modifier = modifier
        .drawWithCache {
//            val path = generatePath()
            onDrawBehind {
                translate(left = 2f, top = 3f) {
                    drawCircle(
                        color = Color.Magenta,
                        center = Offset(
                            5.dp.toPx(),
                            2.dp.toPx()
                        ),
                        radius = size.width / 2
                    )
                    val w = size.width
                }
            }
        }
        .height(30.dp)
        .width(30.dp))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyDirectotyTheme {
        AnimatedCircle("Android")
    }
}