package com.example.latestjetpackprojectstructure.authdemo

import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.latestjetpackprojectstructure.R
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
@Preview(showBackground = true)
@Composable
fun SplashScreen() {
    val pagerState = rememberPagerState(pageCount = { splashImages.size })
    Box(
        modifier = Modifier

    ) {

        Column(
            verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.White
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 50.dp)
                    .padding(end = 10.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.skip),
                    color = Color.Gray,
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                )
                Image(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.Gray)
                )

            }
            HorizontalPager(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                state = pagerState,
                key = { splashImages[it] }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(30.dp)
                ) {
                    Image(
                        painter = painterResource(id = splashImages[it]),
                        contentDescription = "",
                        Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .align(Alignment.CenterHorizontally),
                        contentScale = ContentScale.FillHeight
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = Title[it]),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = SubTitle[it]),
                        color = Color.Gray,
                        lineHeight = 15.sp,
                        maxLines = 3,
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                        )
                    )
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (50).dp),
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
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y=(-20).dp)
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
                Image(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.Gray)
                )


            }
        }


    }

}