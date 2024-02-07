package com.example.latestjetpackprojectstructure.authdemo.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.latestjetpackprojectstructure.R
import com.example.latestjetpackprojectstructure.authdemo.components.BoldText
import com.example.latestjetpackprojectstructure.authdemo.components.CommonButton
import com.example.latestjetpackprojectstructure.authdemo.components.CommonImage
import com.example.latestjetpackprojectstructure.authdemo.components.CommonSpacer
import com.example.latestjetpackprojectstructure.authdemo.components.NormalText
import com.example.latestjetpackprojectstructure.authdemo.data.ScreenEnum
import com.example.latestjetpackprojectstructure.ui.theme.Pink80
import com.example.latestjetpackprojectstructure.ui.theme.ThemeColor

val splashImages = listOf(
    R.drawable.food,
    R.drawable.study_office,
    R.drawable.food_delivery_boy,

    )

var Title = listOf(
    R.string.fresh_food_order,
    R.string.fast_delivery,
    R.string.good_service
)
val SubTitle = listOf(
    R.string.prepare_to_be_dazzled_by_the_symphony_of_the_flavours_that_dance_upon_your_table,
    R.string.the_clock_was_tickling_and_hungry_patrons_eagerly_awaited_their_meals_with_determination_in_his_eyes_jake_sprang_into_action,
    R.string.with_our_streamlined_delivery_process_your_culinary_desires_are_just_a_few_click_away
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SplashScreen(navController: NavHostController) {
    val pagerState = rememberPagerState(pageCount = { splashImages.size })
    val modifier = if (pagerState.currentPage == 2) {
        Modifier
            .alpha(0f)
    } else {
        Modifier
    }
    Column(
        verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxSize()
            .background(
                Color.White
            )
    ) {
        SkipButton(navController, modifier)
        OnBoardingPager(navController, pagerState)
        PagerIndicator(pagerState)
        //NextButton(navController, modifier)
    }

}

@Composable
fun NextButton(navController: NavHostController, modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = modifier
            .fillMaxWidth()

            .offset(y = (-20).dp)
            .padding(end = 30.dp),
    ) {
        Text(
            text = stringResource(id = R.string.next),
            color = Color.Gray,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                textAlign = TextAlign.End
            )
        )
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "",
            tint = Color.Gray
        )


    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerIndicator(pagerState: PagerState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-50).dp),
        /*
        .weight(1f)
        */
        horizontalArrangement = Arrangement.Center,
    ) {
        repeat(splashImages.size) { iteration ->
            val color = if (pagerState.currentPage == iteration) ThemeColor else Pink80
            Box(
                modifier = Modifier
                    .padding(horizontal = 6.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(10.dp)
            )
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingPager(navController: NavHostController, pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,
        key = { splashImages[it] },
        modifier = Modifier
            .fillMaxWidth(),
        /* .align(Alignment.CenterHorizontally)*/
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
        ) {
            CommonImage(
                imageId = splashImages[it],
                modifier = Modifier
                    .height(200.dp)
            )

            CommonSpacer(w = 20.dp)
            BoldText(stringId = Title[it])

            CommonSpacer(w = 20.dp)
            NormalText(stringId = SubTitle[it])

            CommonSpacer(w = 20.dp)
            AnimatedVisibility(
                modifier = Modifier.fillMaxWidth(),
                enter = fadeIn() + expandHorizontally(),
                exit = fadeOut() + shrinkHorizontally(),
                visible = pagerState.currentPage == 2
            ) {
                CommonButton(
                    navController = navController,
                    text = R.string.get_started_now,
                    route = ScreenEnum.HOME.name
                )
            }

        }
    }
}

@Composable
fun SkipButton(navController: NavHostController, modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = modifier
            .fillMaxWidth()
            .offset(y = 10.dp)
            .padding(end = 10.dp),
    ) {
        Text(
            modifier = Modifier
                .clickable {
                    navController.popBackStack()
                    navController.navigate(ScreenEnum.HOME.name)
                },
            text = stringResource(id = R.string.skip),
            color = Color.Gray,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "",
            tint = Color.Gray,
        )

    }
}

