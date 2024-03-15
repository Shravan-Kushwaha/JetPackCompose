package com.example.latestjetpackprojectstructure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.latestjetpackprojectstructure.authdemo.navigation.MainNavGraph
import com.example.latestjetpackprojectstructure.demo.DiceWithButtonAndImage
import com.example.latestjetpackprojectstructure.demo.GreetingImage
import com.example.latestjetpackprojectstructure.demo.LearnTogether
import com.example.latestjetpackprojectstructure.demo.Lemonade
import com.example.latestjetpackprojectstructure.ui.theme.LatestJetPackProjectStructureTheme
import com.example.latestjetpackprojectstructure.ui.theme.md_theme_light_primaryContainer
import com.example.latestjetpackprojectstructure.ui.theme.md_theme_light_scrim
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LatestJetPackProjectStructureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /**
                     * # 1. HappyBirth Demo
                     * */
                    //GreetingImage(name = "Happy BirthDay", from = "Shravan!")

                    /**
                     * # 2. LearnTogether Demo
                     * */
                    /* LearnTogether(
                         "Jetpack Compose tutorial",
                         "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                         "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
                     )*/

                    /**
                     * # 3. DiceRoller Demo
                     * */
                    /*DiceWithButtonAndImage(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(Alignment.Center)
                    )*/

                    /**
                     * # 4. Lemonade Demo
                     * */
                    /* Scaffold(
                         topBar = {
                             CenterAlignedTopAppBar(
                                 title = {
                                     Text(
                                         text = "Lemonade",
                                         textAlign = TextAlign.Center
                                     )
                                 }, colors = TopAppBarDefaults.topAppBarColors(
                                     containerColor = md_theme_light_primaryContainer,
                                     titleContentColor = md_theme_light_scrim
                                 )
                             )
                         }) {
                         Lemonade(modifier = Modifier.padding(it))
                     }*/
                    /**
                     * # 5. UNScramble Demo
                     * */
                    //  GameScreen()

                    /**
                     * # 6. Compose Auth Demo
                     * */
                    MainNavGraph()


                }
            }
        }
    }
}


/**
 * # 4. Lemonade
 * */
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, device = Devices.NEXUS_5, name = "Dice Roller")
@Composable
fun LemonadePreview() {
    LatestJetPackProjectStructureTheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Lemonade",
                            textAlign = TextAlign.Center
                        )
                    }, colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = md_theme_light_primaryContainer,
                        titleContentColor = md_theme_light_scrim
                    )
                )
            }) {
            Lemonade(modifier = Modifier.padding(it))
        }
    }
}

/**
 * # 3. DiceRoller
 * */
@Preview(showBackground = true, device = Devices.NEXUS_5, name = "Dice Roller")
@Composable
fun DiceRollerPreview() {
    LatestJetPackProjectStructureTheme {
        DiceWithButtonAndImage(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}

/**
 * # 2. LearnTogether
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


/**
 * # 1. HappyBirthDemo
 * */
@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun GreetingImagePreview() {
    LatestJetPackProjectStructureTheme {
        GreetingImage(name = "Happy BirthDay Shravan!", from = "From Vasudev")
    }
}
