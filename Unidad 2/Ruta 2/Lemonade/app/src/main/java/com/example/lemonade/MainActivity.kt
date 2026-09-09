package com.example.lemonade

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeScreen(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val (imageResource, textResource) = when (result) {
        1 -> R.drawable.lemon_tree to R.string.Lemon_tree
        2 -> R.drawable.lemon_squeeze to R.string.Lemon
        3 -> R.drawable.lemon_restart to R.string.Glass_of_lemonade
        else -> R.drawable.lemon_drink to R.string.Empty_glass
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(
            onClick = { result = if (result == 4) 1 else result + 1 },
            modifier = Modifier,
            shape = RoundedCornerShape(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC3ECD2)
            )
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = result.toString(),
            )
        }
        Spacer(
            modifier = Modifier
                .height(25.dp)
        )
        Text(
            text = stringResource(
                textResource
            ),
        )
    }
}

@Composable
fun LemonadeHeader(modifier: Modifier = Modifier) {
    Text(
        fontSize = 16.sp ,
        text = "Lemonade",
        modifier = modifier
            .background(Color(0xFFF9E44C))
            .wrapContentSize(Alignment.Center)
            .padding(5.dp)

    )
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LemonadeHeader(modifier = Modifier
            .wrapContentSize(Alignment.TopCenter)
            .fillMaxWidth()
        )
        Spacer(modifier = Modifier
            .height(16.dp)
        )
        LemonadeScreen(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .wrapContentSize(Alignment.Center)
        )
    }
}