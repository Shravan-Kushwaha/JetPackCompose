package com.example.latestjetpackprojectstructure.demo

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.latestjetpackprojectstructure.R
import com.example.latestjetpackprojectstructure.demo.data.allWords
import com.example.latestjetpackprojectstructure.ui.theme.LatestJetPackProjectStructureTheme
import com.example.latestjetpackprojectstructure.ui.theme.PurpleGrey80


/**
 * # 5. UnScramble Demo
 * */
@Composable
fun GameScreen(
    gameViewModel: GameViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val gameUiState by gameViewModel.uiState.collectAsState()
    var verticalPadding = dimensionResource(id = R.dimen.padding_medium)
    var horizonatalPadding = dimensionResource(id = R.dimen.padding_vertical)
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        GameLayout(
            wordCount = gameUiState.currentWordCount,
            currentScrambledWord = gameUiState.currentScrambledWord,
            userGuess = gameViewModel.userGuess,
            onUserGuessChanged = { gameViewModel.updateUserGuess(it) },
            onKeyboardDone = { gameViewModel.checkUserGuess() },
            isGuessWrong = gameUiState.isGuessedWordWrong,
            modifier = modifier.padding(
                horizontal = horizonatalPadding,
                vertical = verticalPadding
            )
        )
        Button(
            modifier = Modifier
                .padding(horizontal = horizonatalPadding, vertical = verticalPadding)
                .fillMaxWidth(),
            onClick = { gameViewModel.checkUserGuess() }) {
            Text(
                text = stringResource(id = R.string.submit),
                fontSize = 20.sp,
            )
        }
        OutlinedButton(
            modifier = Modifier
                .padding(
                    horizontal = horizonatalPadding,
                )
                .fillMaxWidth(),
            onClick = { gameViewModel.skipWord() }) {
            Text(
                text = stringResource(id = R.string.skip),
                fontSize = 20.sp,
            )
        }
        ScoreLayout(score = gameUiState.score, verticalPadding)
        if (gameUiState.isGameOver) {
            FinalScoreDialog(
                score = gameUiState.score,
                onPlayAgain = { gameViewModel.resetGame() }
            )
        }
    }
}

@Composable
fun ScoreLayout(score: Int, verticalPadding: Dp) {
    Card(
        modifier = Modifier
            .padding(
                vertical = verticalPadding,
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Text(
            text = stringResource(id = R.string.score, score),
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun GameLayout(
    isGuessWrong: Boolean,
    userGuess: String,
    wordCount: Int,
    onKeyboardDone: () -> Unit,
    onUserGuessChanged: (String) -> Unit,
    currentScrambledWord: String,
    modifier: Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = PurpleGrey80),
        modifier = modifier
    ) {
        Text(
            modifier = modifier
                .clip(shapes.large)
                .align(Alignment.End)
                .background(colorScheme.surfaceTint)
                .padding(horizontal = 10.dp, vertical = 4.dp),
            style = typography.titleMedium,
            color = colorScheme.onPrimary,
            text = stringResource(
                id = R.string.word_count, wordCount, allWords.size
            ),
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
        )
        Text(
            modifier = modifier.align(Alignment.CenterHorizontally),
            text = currentScrambledWord,
            fontWeight = FontWeight.SemiBold,
            fontSize = 40.sp,
        )
        Text(
            modifier = modifier,
            text = stringResource(id = R.string.unscramble_the_word_using_all_the_letters),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        OutlinedTextField(
            value = userGuess,
            singleLine = true,
            shape = shapes.large,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.surface,
                unfocusedContainerColor = colorScheme.surface,
                disabledContainerColor = colorScheme.surface,
            ), modifier = modifier
                .align(Alignment.CenterHorizontally),
            label = {
                if (isGuessWrong) {
                    Text(stringResource(R.string.wrong_guess))
                } else {
                    Text(stringResource(R.string.enter_your_word))
                }
            },
            isError = isGuessWrong,
            keyboardOptions = KeyboardOptions.run {
                Default.copy(
                    imeAction = ImeAction.Done
                )
            },
            keyboardActions = KeyboardActions(
                onDone = { onKeyboardDone() }
            ),
            onValueChange =  onUserGuessChanged
        )
    }
}

@Composable
private fun FinalScoreDialog(
    score: Int,
    onPlayAgain: () -> Unit,
    modifier: Modifier = Modifier
) {
    val activity = (LocalContext.current as Activity)

    AlertDialog(
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onDismissRequest.
        },
        title = { Text(stringResource(R.string.congratulations)) },
        text = { Text(stringResource(R.string.you_scored, score)) },
        modifier = modifier,
        dismissButton = {
            TextButton(
                onClick = {
                    activity.finish()
                }
            ) {
                Text(text = stringResource(R.string.exit))
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onPlayAgain()
                }
            ) {
                Text(text = stringResource(R.string.play_again))
            }
        }
    )
}

@Preview(showBackground = true, device = Devices.PIXEL_3)
@Composable
fun UnScramblePreview() {
    LatestJetPackProjectStructureTheme {
        GameScreen()
    }
}



