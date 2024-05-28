package com.quynhlm.dev.furnitureapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.quynhlm.dev.furnitureapp.ui.theme.FurnitureAppTheme

//sealed class MyAppScreen(val route: String, val icon: Int, val title: String) {
//    object Home : MyAppScreen("home", R.drawable.home, "Trang chủ")
//    object History : MyAppScreen("history", R.drawable.marker, "Lịch sử")
//    object Cart : MyAppScreen("cart", R.drawable.bell, "Giỏ hàng")
//    object Profile : MyAppScreen("profile", R.drawable.person, "Hồ sơ")
//}

class MainActivity : ComponentActivity() {
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

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SmallTopAppBarExample() {
//    val snackbarHostState = remember { SnackbarHostState() }
//    val coroutineScope = rememberCoroutineScope()
//    val navController = rememberNavController()
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = colorResource(id = R.color.white),
//                    titleContentColor = MaterialTheme.colorScheme.primary,
//                ),
//                title = {
//                    Text(text = buildAnnotatedString {
//                        withStyle(
//                            style = SpanStyle(
//                                color = Color.Gray,
//                                fontSize = 18.sp,
//                                fontWeight = FontWeight(400),
//                                fontFamily = FontFamily(Font(R.font.gelasio_bold))
//                            )
//                        ) {
//                            append("Make home\n")
//                        }
//                        withStyle(
//                            style = SpanStyle(
//                                color = Color.Black,
//                                fontSize = 18.sp,
//                                fontWeight = FontWeight(700),
//                                fontFamily = FontFamily(Font(R.font.gelasio_bold))
//                            )
//                        ) {
//                            append("BEAUTIFUL")
//                        }
//                    }, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
//                },
//                navigationIcon = {
//                    IconButton(onClick = {}) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.search),
//                            contentDescription = null,
//                            modifier = Modifier.size(24.dp)
//                        )
//                    }
//                },
//                actions = {
//                    IconButton(onClick = { /* do something */ }) {
//                        Icon(
//                            painter = painterResource(id = R.drawable.cart),
//                            contentDescription = null,
//                            modifier = Modifier.size(24.dp)
//                        )
//                    }
//                },
//            )
//        },
//        bottomBar = {
//            BottomNavigationBar(navController = navController)
//        },
//        snackbarHost = {
//            SnackbarHost(hostState = snackbarHostState)
//        }
//    ) { innerPadding ->
//        NavigationGraph(navController = navController, innerPadding)
//    }
//}
//
//@Composable
//private fun BottomNavigationBar(navController: NavHostController) {
//
//    // Tạo list dựa vào các object đã khai báo ở main
//    val items = listOf(
//        MyAppScreen.Home,
//        MyAppScreen.History,
//        MyAppScreen.Cart,
//        MyAppScreen.Profile
//    )
//
//    NavigationBar(
//        containerColor = Color("#ffffff".toColorInt())
//    ) {
//        // trả về thông tin của màn hình hiện tại( đường dẫn ,trạng thái màn hình,Trạng thái vòng đời của màn hình,..)
//        val navBackStackEntry by navController.currentBackStackEntryAsState()
//
//        val currentRoute = navBackStackEntry?.destination?.route
//        // kiểm tra xem các mục trong điều hướng có trùng với đường dẫn màn hình đc lưu trong biến currentRoute hay ko
//
//        items.forEach { screen ->
//            NavigationBarItem(
//                icon = {
//                    Icon(
//                        painterResource(id = screen.icon),
//                        contentDescription = screen.title,
//                        modifier = Modifier.size(24.dp)
//                    )
//                },
//
//                selected = currentRoute == screen.route, // nếu danh mục được chọn, trả về currentRoute= link đường dẫn đến danh mục được chọn
//                onClick = {
//                    navController.navigate(screen.route) {
//                        // Điều hướng đến một màn hình duy nhất, không tạo thêm bản sao
//                        launchSingleTop = true
//                        // Khôi phục trạng thái đã lưu
//                        restoreState = true
//                        // Xóa tất cả các trang trước trang đích để tránh chồng chất trang
//                        popUpTo(navController.graph.startDestinationId) {
//                            saveState = true
//                        }
//                    }
//                },
//                colors = NavigationBarItemDefaults.colors(
//                    selectedIconColor = colorResource(id = android.R.color.holo_orange_dark),
//                    unselectedIconColor = Color.Gray,
//                    selectedTextColor = colorResource(id = android.R.color.holo_orange_dark),
//                    unselectedTextColor = Color.Gray,
//                    indicatorColor = Color.Transparent
//                )
//            )
//        }
//    }
//}

@Composable
fun NavigationGraph(navController: NavHostController, innerPadding: PaddingValues) {

//         nhận nhiệm vụ xử lí chính cho việc chuyển màn khi ấn vào icon của thanh điều hướng
    // truyền và o 3 tham số : navController là công cụ thuộc thư việ có sẵn của jetpack compose giúp xử lí về bottom nav bar
//    NavHost(navController, startDestination = Screen.Home.route) {
//
//        // tùy vào route object nào sẽ navigate đến fun component đó
//        composable(Screen.Home.route) { RegisterScreen(null) }
//        composable(Screen.History.route) { RegisterScreen(null) }
//        composable(Screen.Cart.route) { RegisterScreen(null) }
//    }
}
//@Preview(name = "WelCome", showBackground = true)




//
//

//

//
//@Composable
//fun CategoryItem(icon: Int, name: String) {
//    Column(
//        modifier = Modifier.padding(end = 25.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Row(
//            modifier = Modifier
//                .size(44.dp)
//                .shadow(elevation = 2.dp, RoundedCornerShape(14.dp))
//                .background(color = Color("#F5F5F5".toColorInt())),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Center,
//        ) {
//            Image(
//                painter = painterResource(id = icon),
//                contentDescription = null,
//                modifier = Modifier.size(22.dp)
//            )
//        }
//        Spacer(modifier = Modifier.height(5.dp))
//        Text(
//            text = name,
//            color = Color("#999999".toColorInt()),
//            fontSize = 14.sp,
//            fontWeight = FontWeight.Bold,
//            fontFamily = FontFamily(
//                Font(R.font.nunitosans_7pt_condensed_light)
//            )
//        )
//    }
//}
//

//
////@Preview(name = "Register", showBackground = true)
//
//






//@Preview(name = "Main", showBackground = true, device = "id:pixel_2_xl")
//@Composable
//fun GreetingPreview() {
//    FurnitureAppTheme {
//        SmallTopAppBarExample()
//    }
//}


//
//@Preview(name = "Details", showBackground = true, device = "id:pixel_4a")


