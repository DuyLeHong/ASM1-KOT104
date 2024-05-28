package com.quynhlm.dev.furnitureapp

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController

class ReviewScreen : ComponentActivity() {
}
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ReView(navController: NavController) {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colorResource(id = R.color.background),
                        titleContentColor = Color.Black,
                    ),
                    title = {
                        Text(
                            "Rating & Review",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            fontFamily = FontFamily(
                                Font(R.font.merriweather_regular)
                            )
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                painter = painterResource(id = R.drawable.arrowback),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            modifier = Modifier.size(24.dp),
                            onClick = { /* Handle action */ }) {
                            // Action icon (e.g., settings or more options) can be added here
                        }
                    },
                )
            },
        ) { innerPadding ->
            ReviewAndRatingScreen(innerPadding)
        }
    }

    @Composable
    fun ReviewAndRatingScreen(innerPadding: PaddingValues) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 10.dp,
                    top = innerPadding.calculateTopPadding(),
                    end = 10.dp
                )
                .background(color = colorResource(id = R.color.background))
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                ProductReview()
                Box (modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 25.dp),
                    contentAlignment = Alignment.BottomEnd){
                    CustomButton(
                        title = "Write a review", modifier = Modifier
                            .padding(7.dp)
                            .fillMaxWidth()
                            .height(60.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF242424))
                            .clickable(onClick = {}),
                        textStyle = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight(600)
                        )
                    )
                }
            }
        }
    }

    @Composable
    fun ProductReview() {
        Column ( modifier = Modifier
            .fillMaxWidth()){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image1),
                    contentDescription = null,
                    modifier = Modifier
                        .width(110.dp)
                        .height(120.dp),
                    contentScale = ContentScale.FillBounds
                )
                Column(
                    modifier = Modifier
                        .width(200.dp)
                        .padding(start = 20.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Minimal Stand",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.gray),
                        fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light))
                    )
                    Row(
                        modifier = Modifier.width(200.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = "4.5",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold)),
                            modifier = Modifier.padding(7.dp)
                        )
                    }
                    Text(
                        text = "10 reviews",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color("#303030".toColorInt())
                    )
                }
            }

            Spacer(modifier = Modifier.height(15.dp))
            Divider(color = Color("#F0F0F0".toColorInt()), thickness = 1.dp)
            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn {
                items(4) { item ->
                    ReViewItem()
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }

    @Composable
    fun ReViewItem() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Column(
                        modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth()
                            .background(Color.White)
                            .shadow(elevation = 0.dp, shape = RoundedCornerShape(12.dp))
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(15.dp),
                            verticalArrangement = Arrangement.SpaceEvenly,
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Bruno Fernandes",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold))
                                )
                                Text(
                                    text = "20/03/2020",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold)),
                                    color = Color.Gray
                                )
                            }
                            Row(
                                modifier = Modifier.width(120.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                repeat(5) {
                                    Image(
                                        painter = painterResource(id = R.drawable.star),
                                        contentDescription = null,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                            Text(
                                text = "Nice Furniture with good delivery. The delivery time is very fast. The products look exactly like the picture in the app. Besides, the color is also the same and the quality is very good despite the very cheap price.",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Justify,
                                fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
                                color = Color.Black
                            )
                        }
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
