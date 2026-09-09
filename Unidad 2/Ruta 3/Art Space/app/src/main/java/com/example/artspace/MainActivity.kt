package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun Screen(){
    var result by remember { mutableStateOf(1)}
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.BottomEnd)
    ) {
        ScreenContent(
            result
        )
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        ScreenActions(
            onPrevious = {
                result = if (result == 1) 4 else result - 1
            },
            onNext = {
                result = if (result == 4) 1 else result + 1
            }
        )
    }
}

@Composable
fun ScreenContent(
    result: Int
){
    val imageResource = when (result) {
        1 -> R.drawable.img1
        2 -> R.drawable.img2
        3 -> R.drawable.img3
        else -> R.drawable.img4
    }
    Box(
        modifier = Modifier
            .shadow(10.dp, RoundedCornerShape(5.dp))
            .background(color = Color.White)
    ){
        Image(
            painter = painterResource(imageResource),
            contentDescription = "Hola",
            modifier = Modifier
                .padding(20.dp)
                .size(300.dp)
        )
    }
    Spacer(
        modifier = Modifier
            .height(100.dp)
    )
    Column (
        modifier = Modifier
            .width(300.dp)
            .background(color = Color(0xFFC3ECD2))
            .padding(horizontal = 18.dp, vertical = 20.dp)
    ) {
        Text(
            text = "Sailing Under the Bridge",
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Kat Kuan ",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                )
            Text(
                text = "(2017)",
                fontSize = 15.sp,

            )
        }
    }
}

@Composable
fun ScreenActions(
    onPrevious: () -> Unit,
    onNext: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(
                align = Alignment.Center
            )
            .padding(horizontal = 25.dp, vertical = 15.dp)
    ) {
        Button(
            onClick = onPrevious,
            modifier = Modifier
                .width(150.dp)
        ) {
            Text(
                text = "Previous"
            )

        }
        Spacer(
            modifier = Modifier
                .weight(1f)
        )
        Button(
            onClick = onNext,
            modifier = Modifier
                .width(150.dp)
        ) {
            Text(
                text = "Next"
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceApp(
    modifier: Modifier = Modifier
        .fillMaxSize()
) {
    Screen()
}