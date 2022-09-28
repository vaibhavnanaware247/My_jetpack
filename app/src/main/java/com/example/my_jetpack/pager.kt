package com.example.my_jetpack

import androidx.annotation.DrawableRes


data class pager(@DrawableRes val image: Int, val title: String, val caption: Int)

val pagerlist = listOf<pager>(
    pager(R.drawable.top_1, "Largest Learning Destination", R.string.caption1),
    pager(R.drawable.top_2, "Highest Success Numbers", R.string.caption2),
    pager(R.drawable.top_3, "Unmatched Tests & Video Classes", R.string.caption3),
    pager(R.drawable.top_4, "\n Stay ahead of the pack", R.string.caption4)

)

