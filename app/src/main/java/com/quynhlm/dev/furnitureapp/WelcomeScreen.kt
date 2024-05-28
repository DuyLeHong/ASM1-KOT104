package com.quynhlm.dev.furnitureapp

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Preview
@Composable
fun WelComeScreen(navController: NavController? = null) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Background image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .height(400.dp)
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Column {
//
//            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "MAKE YOUR",
                    fontSize = 24.sp,
                    color = colorResource(id = R.color.gray),
                    fontWeight = FontWeight(600),
                    fontFamily = FontFamily(Font(R.font.gelasio_bold))
                )
                Text(
                    text = "HOME BEAUTIFUL",
                    fontSize = 30.sp,
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight(700),
                    fontFamily = FontFamily(Font(R.font.gelasio_bold))
                )
                Text(
                    modifier = Modifier.padding(start = 25.dp, top = 15.dp),
                    text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
                    color = colorResource(id = R.color.graySecond),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
                    lineHeight = 35.sp,
                    textAlign = TextAlign.Justify
                )
            }
            Column {
                CustomRow(onClick = {
                    navController?.navigate(ROUTE_NAME.login.name)
                })
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun CustomRow(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(7.dp)
            .width(160.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Color(0xFF242424))
            .clickable(onClick = onClick)
            .then(modifier)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),  // Fill the size of the Box
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Get Started",
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.gelasio_bold)),
                fontWeight = FontWeight(600),
                fontSize = 18.sp
            )  // Set text color
        }
    }
}