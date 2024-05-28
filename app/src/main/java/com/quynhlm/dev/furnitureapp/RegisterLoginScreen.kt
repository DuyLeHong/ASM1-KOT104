package com.quynhlm.dev.furnitureapp

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun RegisterScreen(navController : NavController) {
//    val navController = rememberNavController()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(13.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Divider(
                    color = Color("#BDBDBD".toColorInt()),
                    thickness = 2.dp,
                    modifier = Modifier.width(105.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.size(75.dp)
                )
                Divider(
                    color = Color("#BDBDBD".toColorInt()),
                    thickness = 2.dp,
                    modifier = Modifier.width(105.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "WelCome",
                fontSize = 28.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(Font(R.font.gelasio_bold))
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(500.dp)
                .clip(RoundedCornerShape(16.dp))
                .shadow(elevation = 4.dp, spotColor = colorResource(id = R.color.graySecond))
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp), verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                InputRow(title = "Name")
                InputRow(title = "Email")
                InputRowPass(title = "Password")
                InputRowPass(title = "Confirm PassWord")

                Box(
                    modifier = Modifier
                        .padding(7.dp)
                        .width(285.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF242424))
                        .clickable(onClick = {})
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "SIGN UP",
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
                            fontWeight = FontWeight(600),
                            fontSize = 17.sp
                        )
                    }
                }
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Gray,
                            fontSize = 15.sp,
                            fontWeight = FontWeight(600),
                            fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light))
                        )
                    ) {
                        append("Already have account? ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light))
                        )
                    ) {
                        append("SIGN IN")
                    }
                }, modifier = Modifier.clickable { navController.popBackStack() })
            }
        }
        Column {

        }
    }
}

//var nav: NavController? = null
//@Preview
@Composable
fun LoginScreen(navController : NavController){
//    val navController = rememberNavController()
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Divider(
                    color = Color("#BDBDBD".toColorInt()),
                    thickness = 2.dp,
                    modifier = Modifier.width(105.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.size(75.dp)
                )
                Divider(
                    color = Color("#BDBDBD".toColorInt()),
                    thickness = 2.dp,
                    modifier = Modifier.width(105.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            StyledText()
        }
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth(0.85f)
                .height(400.dp)
                .clip(RoundedCornerShape(16.dp))
                .shadow(elevation = 4.dp, spotColor = colorResource(id = R.color.graySecond)),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp), verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var username by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var passwordVisible by remember { mutableStateOf(false) }

                Column {
                    Text(
                        text = "Email",
                        color = colorResource(id = R.color.graySecond),
                        fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                    TextField(
                        value = username,
                        onValueChange = {
                            username = it
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color("#E0E0E0".toColorInt()),
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.Gray,
                            unfocusedIndicatorColor = Color.Gray,
                        ),
                    )
                }
                Column {
                    Text(
                        text = "PassWord",
                        color = colorResource(id = R.color.graySecond),
                        fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )

                    TextField(
                        value = password,
                        onValueChange = { password = it },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color("#E0E0E0".toColorInt()),
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.Gray,
                            unfocusedIndicatorColor = Color.Gray,
                        ),
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            val image =
                                if (passwordVisible)
                                    painterResource(id = R.drawable.hide)
                                else
                                    painterResource(id = R.drawable.view)
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    painter = image,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        })
                }
                Text(
                    text = "Forgot Password",
                    color = Color("#303030".toColorInt()),
                    fontSize = 17.sp,
                    fontWeight = FontWeight(600)
                )
                Box(
                    modifier = Modifier
                        .padding(7.dp)
                        .width(285.dp)
                        .height(50.dp)
                        .shadow(elevation = 5.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF242424))
                        .clickable(onClick = {
                            if (username.isEmpty() || password.isEmpty()) {
                                Toast
                                    .makeText(
                                        context,
                                        "Username Empty And PassWord Empty",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            } else {
                                if (!username
                                        .trim()
                                        .isEmpty() && !password
                                        .trim()
                                        .isEmpty()
                                ) {
                                    Toast
                                        .makeText(context, "Login SuccessFully", Toast.LENGTH_SHORT)
                                        .show()
                                    navController.navigate("home")
                                } else {
                                    Toast
                                        .makeText(
                                            context,
                                            "Login Not SuccessFully",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                }
                            }
                        })
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Login",
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.gelasio_bold)),
                            fontWeight = FontWeight(600),
                            fontSize = 17.sp
                        )
                    }
                }
                Text(
                    text = "SIGN UP",
                    modifier = Modifier.clickable {
                        navController.navigate("signup")
                    }
                )
            }
        }
        Column {

        }
    }
}

@Composable
fun InputRow(title: String) {
    Column {
        Text(
            text = title,
            color = colorResource(id = R.color.graySecond),
            fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
        CustomTextField()
    }
}

@Composable
fun CustomTextField() {
    var username by remember { mutableStateOf("") }
    TextField(
        value = username,
        onValueChange = {

        },
        modifier = Modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color("#E0E0E0".toColorInt()),
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.Gray,
            unfocusedIndicatorColor = Color.Gray,
        ),
    )
}

@Composable
fun StyledText() {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = ParagraphStyle(
                lineHeight = 50.sp
            )
        ) {
            withStyle(
                style = SpanStyle(
                    color = Color.Gray,
                    fontSize = 27.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily(Font(R.font.gelasio_bold))
                )
            ) {
                append("Hello ! \n")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.Black,
                    fontSize = 27.sp,
                    fontWeight = FontWeight(600),
                    fontFamily = FontFamily(Font(R.font.gelasio_bold))
                )
            ) {
                append("WELCOME BACK")
            }
        }
    }

    BasicText(
        text = annotatedText,
        modifier = Modifier.width(300.dp),
    )
}

@Composable
fun PasswordTextField() {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = { password = it },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color("#E0E0E0".toColorInt()),
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.Gray,
            unfocusedIndicatorColor = Color.Gray,
        ),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image =
                if (passwordVisible)
                    painterResource(id = R.drawable.hide)
                else
                    painterResource(id = R.drawable.view)
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(painter = image, contentDescription = null, modifier = Modifier.size(20.dp))
            }
        }
    )
}

@Composable
fun InputRowPass(title: String) {
    Column {
        Text(
            text = title,
            color = colorResource(id = R.color.graySecond),
            fontFamily = FontFamily(Font(R.font.nunitosans_7pt_condensed_light)),
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp
        )
        PasswordTextField()
    }
}

