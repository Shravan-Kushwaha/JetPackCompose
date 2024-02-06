package com.example.latestjetpackprojectstructure.demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.latestjetpackprojectstructure.R
import com.example.latestjetpackprojectstructure.ui.theme.LatestJetPackProjectStructureTheme


/**
 * # 2. Jetpack Compose tutorial
 * */
@Preview(showBackground = true)
@Composable
fun LearnTogetherPreview() {
    LatestJetPackProjectStructureTheme {
        LearnTogether(
            "Jetpack Compose tutorial",
            "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
        )
    }
}

@Composable
fun LearnTogether(text1: String, text2: String, text3: String, modifier: Modifier = Modifier) {
    Column {
        val image = painterResource(id = R.drawable.bg_compose_background)
        Image(painter = image, contentDescription = null)
        Text(
            text = text1,
            fontSize = 24.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = text2,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = text3,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(16.dp)
        )
    }

}