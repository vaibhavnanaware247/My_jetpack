package com.example.my_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_jetpack.ui.theme.My_jetpackTheme
import com.example.my_jetpack.ui.theme.latofamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            My_jetpackTheme {
                mainUI()
            }

        }
    }

    @Composable
    fun mainUI() {
        val viewpager: viewpager = viewpager()
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            viewpager.showViewPager()

            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 12.dp)
            ) {

                google_button()

                Text(
                    text = "or",
                    style = TextStyle(
                        color = colorResource(id = R.color.grey_medium4),
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.padding(top = 10.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(bottom = 10.dp)
                ) {

                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(top = 6.dp),
                        shape = RoundedCornerShape(6.dp),
                        border = BorderStroke(
                            width = 1.dp,
                            color = colorResource(id = R.color.grey_medium2)
                        )
                    ) {
                        Text(
                            text = "Email/Mobile",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontFamily = latofamily,
                                fontWeight = FontWeight.Normal
                            ),
                            modifier = Modifier.padding(horizontal = 18.dp, vertical = 6.dp)
                        )

                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(top = 6.dp),
                        shape = RoundedCornerShape(6.dp),
                        border = BorderStroke(
                            width = 1.dp,
                            color = colorResource(id = R.color.grey_medium2)
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(horizontal = 18.dp, vertical = 3.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_fb_icon),
                                contentDescription = "",
                                tint = colorResource(id = R.color.fb_color)
                            )
                            Text(
                                text = "Facebook",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = latofamily,
                                    fontSize = 14.sp
                                )
                            )
                        }


                    }
                }
                Row(
                    modifier = Modifier.padding(top = 5.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "By continuing, you agree with our",
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.textColorGray)
                        )
                    )
                    Text(
                        text = "terms and conditions",
                        style = TextStyle(
                            color = colorResource(id = R.color.privacy_color),
                            fontSize = 12.sp
                        ),
                        modifier = Modifier.padding(start = 4.dp)
                    )

                }

            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        val viewpager = viewpager()
        My_jetpackTheme {

            mainUI()


        }
    }
}