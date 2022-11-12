package com.example.my_jetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material3.Surface
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
import com.example.my_jetpack.ui.theme.latofamily


@Preview(showBackground = true)
@Composable
fun google_button() {

    Button(onClick = { /*TODO*/ },modifier = Modifier
        .height(47.dp)
        .fillMaxWidth()
        .border(
            0.5.dp, color = colorResource(id = R.color.gglborder),
            shape = RoundedCornerShape(6)
        ),
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.white))

        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_group_91),
                    contentDescription = "google"
                )

                Spacer(modifier = Modifier.width(7.dp))
                Text(
                    text = "Continue with Google",
                    style = TextStyle(
                        color = colorResource(id = R.color.signtext),
                        fontSize = 14.sp,
                        fontFamily = latofamily,
                        fontWeight = FontWeight.Normal
                    ),
                    textAlign = TextAlign.Center,

                    )
            }
        }

}