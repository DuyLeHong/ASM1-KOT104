package com.quynhlm.dev.furnitureapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.quynhlm.dev.furnitureapp.ui.theme.FurnitureAppTheme

class FinalOrderScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FurnitureAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}
    @Composable
    fun FinalScreen(navController : NavController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
                .background(Color.White),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "SUCCESS!",
                fontSize = 36.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(
                    Font(R.font.merriweather_regular)
                )
            )
            Box(
                modifier = Modifier
                    .width(290.dp)
                    .height(250.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.success),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.finalorder),
                        contentDescription = null,
                        modifier = Modifier
                            .width(200.dp)
                            .height(180.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.done),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                    )
                }
            }

            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Gray,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold))
                    )
                ) {
                    append("Your order will be delivered soon.\n")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.Gray,
                        fontSize = 18.sp,
                        fontWeight = FontWeight(400),
                        fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold))
                    )
                ) {
                    append("Thank you for choosing our app!")
                }
            })

            Column {
                CustomButton(
                    title = "Track your orders",
                    modifier = Modifier
                        .padding(7.dp)
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF242424))
                        .clickable(onClick = {navController.navigate("order")}),
                    textStyle = TextStyle(
                        fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold)),
                        fontWeight = FontWeight(600),
                        fontSize = 18.sp,
                        color = Color.White
                    ),
                )
                CustomButton(
                    title = "BACK TO HOME",
                    modifier = Modifier
                        .padding(7.dp)
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(Color("#FFFFFF".toColorInt()))
                        .clickable(onClick = {navController.navigate("home")})
                        .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(8.dp)),
                    textStyle = TextStyle(
                        fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold)),
                        fontWeight = FontWeight(600),
                        fontSize = 18.sp,
                        color = Color.Black
                    ),
                )
            }
        }
    }