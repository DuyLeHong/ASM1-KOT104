package com.quynhlm.dev.furnitureapp

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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

class AddPaymentMethord : ComponentActivity() {
}
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AddPaymentScreen(navController : NavController){
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "Add payment method",
                            textAlign = TextAlign.Center,
                            fontSize = 17.sp,
                            modifier = Modifier.fillMaxWidth(),
                            fontFamily = FontFamily(
                                Font(R.font.merriweather_regular)
                            )
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {navController.navigateUp() }) {
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
            content = { innerPadding ->
                MethodAddPayment(innerPadding)
            }
        )
    }
    @Composable
    fun MethodAddPayment(innerPaddingValues: PaddingValues) {
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, innerPaddingValues.calculateTopPadding(), end = 10.dp , bottom = 15.dp)
            .background(Color.White),
            verticalArrangement = Arrangement.SpaceBetween) {
            Column (modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .background(Color.White)) {
                Image(painter = painterResource(id = R.drawable.payment_card), contentDescription = null , modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp), contentScale = ContentScale.FillBounds)
            }

            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(260.dp), verticalArrangement = Arrangement.SpaceEvenly){
                OutlinedTextField(
                    value = "",
                    label = { Text(text = "Card Holder Name") },
                    placeholder = { Text(text = "Ex: Bruno Pham") },
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color("#F5F5F5".toColorInt()),
                        unfocusedContainerColor = Color("#F5F5F5".toColorInt()),
                        disabledContainerColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                )

                OutlinedTextField(
                    value = "",
                    label = { Text(text = "Card Number") },
                    placeholder = { Text(text = "**** **** **** 3456") },
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color("#F5F5F5".toColorInt()),
                        unfocusedContainerColor = Color("#F5F5F5".toColorInt()),
                        disabledContainerColor = Color.Gray,
                        unfocusedIndicatorColor = Color.Gray,
                    ),
                )

                Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    OutlinedTextField(
                        value = "",
                        label = { Text(text = "CVV") },
                        placeholder = { Text(text = "Ex: 123") },
                        onValueChange = {},
                        modifier = Modifier
                            .height(66.dp)
                            .width(160.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color("#F5F5F5".toColorInt()),
                            unfocusedContainerColor = Color("#F5F5F5".toColorInt()),
                            disabledContainerColor = Color.Gray,
                            unfocusedIndicatorColor = Color.Gray,
                        ),
                    )

                    OutlinedTextField(
                        value = "",
                        label = { Text(text = "Expiration Date") },
                        placeholder = { Text(text = "03/22") },
                        onValueChange = {},
                        modifier = Modifier
                            .height(66.dp)
                            .width(160.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color("#F5F5F5".toColorInt()),
                            unfocusedContainerColor = Color("#F5F5F5".toColorInt()),
                            disabledContainerColor = Color.Gray,
                            unfocusedIndicatorColor = Color.Gray,
                        ),
                    )
                }
            }

            Row (modifier = Modifier.fillMaxWidth().height(200.dp)){

            }
                CustomButton(
                    title = "SAVE ADDRESS",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF242424))
                        .clickable(onClick = {}),
                    textStyle = TextStyle(
                        fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_bold)),
                        fontWeight = FontWeight(600),
                        fontSize = 18.sp,
                        color = Color.White
                    ),
                )
        }
    }