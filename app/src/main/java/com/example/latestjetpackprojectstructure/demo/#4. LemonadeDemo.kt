package com.example.latestjetpackprojectstructure.demo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.latestjetpackprojectstructure.R
import com.example.latestjetpackprojectstructure.ui.theme.LatestJetPackProjectStructureTheme
import com.example.latestjetpackprojectstructure.ui.theme.md_theme_dark_onPrimaryContainer
import com.example.latestjetpackprojectstructure.ui.theme.md_theme_dark_primaryContainer
import com.example.latestjetpackprojectstructure.ui.theme.md_theme_dark_scrim
import com.example.latestjetpackprojectstructure.ui.theme.md_theme_light_primaryContainer
import com.example.latestjetpackprojectstructure.ui.theme.md_theme_light_scrim


/**
 * # 4. Lemonade
 * */
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, device = Devices.NEXUS_5, name = "Lemonade")
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
                    }, colors = topAppBarColors(
                        containerColor = md_theme_light_primaryContainer,
                        titleContentColor = md_theme_light_scrim
                    )
                )
            }) {
            Lemonade(modifier = Modifier.padding(it))
        }
    }
}

@Composable
fun Lemonade(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var selectedImage by remember { mutableStateOf(R.drawable.lemon_tree) }
        var selectedText by remember { mutableStateOf(R.string.tap_the_lemon_tree_to_select_a_lemon) }
        var step by remember { mutableStateOf(1) }
        when (step) {
            1 -> {
                Image(
                    painter = painterResource(id = selectedImage),
                    contentDescription = "tree",
                    modifier = modifier
                        .border(
                            border = BorderStroke(2.dp, Color(105, 205, 216)),
                            shape = RoundedCornerShape(20.dp),


                            )
                        .clickable {
                            selectedImage = R.drawable.lemon_squeeze
                            selectedText = R.string.keep_tapping_the_lemon_to_squeeze_it
                            step = 2
                        })
                Spacer(modifier.height(16.dp))
                Text(
                    text = stringResource(id = selectedText)
                )
            }

            2 -> {
                Image(
                    painter = painterResource(id = selectedImage),
                    contentDescription = "tree",
                    modifier = modifier
                        .border(
                            border = BorderStroke(2.dp, Color(105, 205, 216)),
                            shape = RoundedCornerShape(20.dp),


                            )
                        .clickable {
                            selectedImage = R.drawable.lemon_drink
                            selectedText = R.string.tap_the_lemonade_to_drink_it
                            step = 3
                        })
                Spacer(modifier.height(16.dp))
                Text(
                    text = stringResource(id = selectedText)
                )
            }

            3 -> {
                Image(
                    painter = painterResource(id = selectedImage),
                    contentDescription = "tree",
                    modifier = modifier
                        .border(
                            border = BorderStroke(2.dp, Color(105, 205, 216)),
                            shape = RoundedCornerShape(20.dp),


                            )
                        .clickable {
                            selectedImage = R.drawable.lemon_restart
                            selectedText = R.string.tap_the_empty_glass_to_start_again
                            step = 4
                        })
                Spacer(modifier.height(16.dp))
                Text(
                    text = stringResource(id = selectedText)
                )
            }

            4 -> {
                Image(
                    painter = painterResource(id = selectedImage),
                    contentDescription = "tree",
                    modifier = modifier
                        .border(
                            border = BorderStroke(2.dp, Color(105, 205, 216)),
                            shape = RoundedCornerShape(20.dp),


                            )
                        .clickable {
                            selectedImage = R.drawable.lemon_tree
                            selectedText = R.string.keep_tapping_the_lemon_to_squeeze_it
                            step = 1
                        })
                Spacer(modifier.height(16.dp))
                Text(
                    text = stringResource(id = selectedText)
                )
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {

    var currentStep by remember { mutableStateOf(1) }

    var squeezeCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_select,
                        drawableResourceId = R.drawable.lemon_tree,
                        contentDescriptionResourceId = R.string.lemon_tree_content_description,
                        onImageClick = {
                            currentStep = 2
                            squeezeCount = (2..4).random()
                        }
                    )
                }

                2 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_squeeze,
                        drawableResourceId = R.drawable.lemon_squeeze,
                        contentDescriptionResourceId = R.string.lemon_content_description,
                        onImageClick = {
                            squeezeCount--
                            if (squeezeCount == 0) {
                                currentStep = 3
                            }
                        }
                    )
                }

                3 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_drink,
                        drawableResourceId = R.drawable.lemon_drink,
                        contentDescriptionResourceId = R.string.lemonade_content_description,
                        onImageClick = {
                            currentStep = 4
                        }
                    )
                }

                4 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_empty_glass,
                        drawableResourceId = R.drawable.lemon_restart,
                        contentDescriptionResourceId = R.string.empty_glass_content_description,
                        onImageClick = {
                            currentStep = 1
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescriptionResourceId),
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.button_image_width))
                        .height(dimensionResource(R.dimen.button_image_height))
                        .padding(dimensionResource(R.dimen.button_interior_padding))
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
            Text(
                text = stringResource(textLabelResourceId),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
fun LemonPreview() {
    LatestJetPackProjectStructureTheme {
        LemonadeApp()
    }
}