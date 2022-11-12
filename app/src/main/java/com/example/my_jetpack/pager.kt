package com.adda247.modules.login

import androidx.annotation.DrawableRes
import com.example.my_jetpack.R

data class pager(@DrawableRes val image: Int, val title: Int, val caption: Int)

val pagerList = listOf<pager>(
    pager(R.drawable.top_1, R.string.onboarding_title1, R.string.caption1),
    pager(R.drawable.top_2, R.string.onboarding_title2, R.string.caption2),
    pager(R.drawable.top_3, R.string.onboarding_title3, R.string.caption3),
    pager(R.drawable.top_4, R.string.onboarding_title4, R.string.caption4)
)

//val schoolPagarList = listOf<pager>(
//    pager(R.drawable.top_1, R.string.onboarding_title1, R.string.caption1),
//    pager(R.drawable.top_5, R.string.onboarding_title5, R.string.caption6),
//    pager(R.drawable.top_6, R.string.onboarding_title6, R.string.caption7),
//    pager(R.drawable.top_7, R.string.onboarding_title7, R.string.caption8)
//
//
//)