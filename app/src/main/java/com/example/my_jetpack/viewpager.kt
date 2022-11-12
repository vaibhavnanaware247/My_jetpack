package com.example.my_jetpack

import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adda247.modules.login.pager
import com.adda247.modules.login.pagerList
import com.example.my_jetpack.ui.theme.latofamily
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

class viewpager {


    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun showViewPager() {
        val pageState = rememberPagerState(initialPage = 0)

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            HorizontalPager(
                count = pagerList.size,
                state = pageState,
                modifier = Modifier.fillMaxWidth()

            ) { pager ->
                PageItem(pager = pagerList[pager])

            }
            HorizontalPagerIndicator(
                pagerState = pageState,
                modifier = Modifier.padding(top = 22.dp, bottom = 22.dp)
            )
        }
        LaunchedEffect(Unit) {
            while (true) {
                delay(3000)
                val Topage = (pageState.currentPage + 1) % pageState.pageCount
                tween<Float>(600)
                pageState.animateScrollToPage(page = Topage)
            }
        }
    }

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun HorizontalPagerIndicator(
        pagerState: PagerState,
        modifier: Modifier = Modifier,
        activeColor: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
        inactiveColor: Color = activeColor.copy(ContentAlpha.disabled),
        indicatorWidth: Dp = 6.dp,
        indicatorHeight: Dp = indicatorWidth,
        spacing: Dp = indicatorWidth,
        indicatorShape: Shape = CircleShape,
    ) {

        val indicatorWidthPx = LocalDensity.current.run { indicatorWidth.roundToPx() }
        val spacingPx = LocalDensity.current.run { spacing.roundToPx() }

        Box(
            modifier = modifier,
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(spacing),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                val indicatorModifier = Modifier
                    .size(width = indicatorWidth, height = indicatorHeight)
                    .background(color = inactiveColor, shape = indicatorShape)

                repeat(pagerState.pageCount) {
                    Box(indicatorModifier)
                }
            }

            Box(
                Modifier
                    .offset {
                        val scrollPosition = (pagerState.currentPage + pagerState.currentPageOffset)
                            .coerceIn(
                                0f,
                                (pagerState.pageCount - 1)
                                    .coerceAtLeast(0)
                                    .toFloat()
                            )
                        IntOffset(
                            x = ((spacingPx + indicatorWidthPx) * scrollPosition).toInt(),
                            y = 0
                        )
                    }
                    .size(
                        width = indicatorWidth,
                        height = indicatorHeight
                    )
                    .background(
                        color = colorResource(id = R.color.active),
                        shape = indicatorShape,
                    )

            )
        }
    }

    @Composable
    fun PageItem(pager: pager) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {

            Image(
                painter = painterResource(id = pager.image), modifier = Modifier
                    .fillMaxWidth(), contentDescription = "vs"
            )

            Column(modifier = Modifier
                .height(120.dp)
                .background(color = Color.Red)) {

                Text(
                    text = stringResource(id = pager.title),
                    style = TextStyle(
                        color = colorResource(id = R.color.title_large),
                        fontSize = 22.sp,
                        fontFamily = latofamily,
                        fontWeight = FontWeight(600)
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 60.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = stringResource(id = pager.caption), style = TextStyle(
                        color = colorResource(
                            id =
                            R.color.caption
                        ), fontSize = 16.sp, fontFamily = latofamily, fontWeight = FontWeight(400)
                    ), textAlign = TextAlign.Center, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp)
                )
            }
        }


    }
}