package com.example.my_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
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
import androidx.compose.ui.text.style.TextAlign
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
}

    @Preview(showBackground = true)
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

                Row(modifier = Modifier.padding(horizontal = 75.dp, vertical = 20.dp), verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.Center)
                {

                   Box(modifier = Modifier
                       .height(0.5.dp)
                       .weight(0.3f)
                       .background(color = Color.Red)
                       .align(alignment = Alignment.CenterVertically))
                    Box(contentAlignment = Alignment.Center    ,  modifier = Modifier
                        .weight(0.4f)
                        .padding(horizontal = 1.dp).align(alignment = Alignment.CenterVertically))
                    {
                        Text(
                            text = "or sign in with",
                            style = TextStyle(
                                color = colorResource(id = R.color.grey_medium4),
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center
                            ),


                        )
                    }
                        Box(modifier = Modifier
                            .height(0.5.dp)
                            .weight(0.3f)
                            .background(color = Color.Red)
                            .align(alignment = Alignment.CenterVertically) )
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically ,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(bottom = 45.dp)

                ) 
                {

                    Image( modifier = Modifier
                        .padding(horizontal = 12.dp),
                            painter = painterResource(id = R.drawable.ic_group_185), contentDescription =null)
                           

                    Image(painter = painterResource(id = R.drawable.ic_group_104),
                        contentDescription =null ,
                    modifier = Modifier
                        .padding(horizontal = 12.dp)

                        )

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



    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        val viewpager = viewpager()
        My_jetpackTheme {

//            mainUI()


        }
    }
