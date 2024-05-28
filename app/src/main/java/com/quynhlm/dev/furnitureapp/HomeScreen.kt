package com.quynhlm.dev.furnitureapp

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.quynhlm.dev.furnitureapp.models.Product

enum class ROUTE_HOME_SCREEN {
    Home,
    Favorite,
    Notification,
    Profile
}

class Category(val icon: Int, val name: String)

@Composable
fun FurnitureApp(navHostController : NavController) {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavigationItem(ROUTE_HOME_SCREEN.Home.name, Icons.Default.Home, Icons.Outlined.Home),
        BottomNavigationItem(ROUTE_HOME_SCREEN.Favorite.name, Icons.Default.Favorite, Icons.Outlined.Favorite),
        BottomNavigationItem(
            "Notification",
            Icons.Default.Notifications,
            Icons.Outlined.Notifications
        ),
        BottomNavigationItem(ROUTE_HOME_SCREEN.Profile.name, Icons.Default.Person, Icons.Outlined.Person)
    )
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar(navController = navController , navHostController = navHostController)
            },
            bottomBar = {
                BottomNavigationBar(
                    items = items,
                    selectedItemIndex = selectedItemIndex,
                    onItemSelected = { index ->
                        selectedItemIndex = index
                        navController.navigate(items[index].title)
                    }
                )
            }
        ) { innerPadding ->
            NavigationGraph(navHostController = navHostController,navController = navController, innerPadding = innerPadding)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(navController: NavHostController, navHostController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "Home"
    val homeTitle = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.Gray,
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                fontFamily = FontFamily(Font(R.font.gelasio_bold))
            )
        ) {
            append("Make home\n")
        }
        withStyle(
            style = SpanStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(Font(R.font.gelasio_bold))
            )
        ) {
            append("BEAUTIFUL")
        }
    }

    val title: Any = when (currentRoute) {
        "Home" -> homeTitle
        "Favorite" -> "Favorite"
        "Notification" -> "Notification"
        "Profile" -> "Profile"
        else -> "Furniture App"
    }
    androidx.compose.material3.TopAppBar(
        title = {
            if (title is AnnotatedString) {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            } else if (title is String) {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    fontFamily = FontFamily(
                        Font(R.font.merriweather_regular)
                    )
                )
            }
        },
        actions = {
            IconButton(onClick = { navHostController.navigate("cart") }) {
                Icon(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        },
    )
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    selectedItemIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar(
        containerColor = Color("#ffffff".toColorInt())
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = { onItemSelected(index) },
                icon = {
                    Icon(
                        imageVector = if (selectedItemIndex == index) item.selectIcon else item.unselectItem,
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = android.R.color.black),
                    unselectedIconColor = Color.Gray
                )
            )
        }
    }
}

@Composable
fun CategoryItem(icon: Int, name: String) {
    Column(
        modifier = Modifier.padding(end = 25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .size(44.dp)
                .shadow(elevation = 2.dp, RoundedCornerShape(14.dp))
                .background(color = Color("#F5F5F5".toColorInt())),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(22.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = name,
            color = Color("#999999".toColorInt()),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(
                Font(R.font.nunitosans_7pt_condensed_light)
            )
        )
    }
}
@Composable
fun HomeScreen(innerPadding: PaddingValues = PaddingValues(), navController: NavController) {
    val categoryArr = listOf(
        Category(R.drawable.cart, "Chair"),
        Category(R.drawable.cart, "Chair"),
        Category(R.drawable.cart, "Chair"),
        Category(R.drawable.cart, "Chair"),
        Category(R.drawable.cart, "Chair"),
        Category(R.drawable.cart, "Chair"),
        Category(R.drawable.cart, "Chair"),
        Category(R.drawable.cart, "Chair"),
        Category(R.drawable.cart, "Chair"),
        Category(R.drawable.cart, "Chair"),
        Category(R.drawable.cart, "Chair"),
        Category(R.drawable.cart, "Chair")
    )
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.padding(
            top = 10.dp,
            end = 15.dp,
            start = 15.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState)
        ) {
            categoryArr.forEach { category ->
                CategoryItem(icon = category.icon, name = category.name)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(productArr.chunked(2)) { productRow ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    for (product in productRow) {
                        ProductItem(
                            image = product.image,
                            name = product.name,
                            price = product.price,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun NavigationGraph(navHostController : NavController, navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController,
        startDestination = ROUTE_HOME_SCREEN.Home.name,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(ROUTE_HOME_SCREEN.Home.name) { HomeScreen(innerPadding , navHostController) }
        composable(ROUTE_HOME_SCREEN.Favorite.name) { FavoriteScreen(innerPadding) }
        composable(ROUTE_HOME_SCREEN.Notification.name) { NotificationScreen(innerPadding) }
        composable(ROUTE_HOME_SCREEN.Profile.name) { AccountScreenControl(innerPadding , navHostController) }
    }
}

data class BottomNavigationItem(
    val title: String,
    val selectIcon: ImageVector,
    var unselectItem: ImageVector
)

val productArr = listOf(
    Product(R.drawable.image1, "Black Simple Lamp", 12.00),
    Product(R.drawable.image2, "Black Simple Lamp", 12.00),
    Product(R.drawable.image3, "Black Simple Lamp", 12.00),
    Product(R.drawable.image1, "Black Simple Lamp", 12.00),
    Product(R.drawable.image1, "Black Simple Lamp", 12.00),
    Product(R.drawable.image2, "Black Simple Lamp", 12.00),
    Product(R.drawable.image3, "Black Simple Lamp", 12.00),
    Product(R.drawable.image1, "Black Simple Lamp", 12.00),
)

@Composable
fun ProductItem(image: Int, name: String, price: Double , navController: NavController) {
    Column(
        modifier = Modifier
            .width(165.dp)
            .height(253.dp).
            clickable { navController.navigate("detail") },
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = image),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 10.dp, end = 15.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                Row {

                }
                Row(
                    modifier = Modifier
                        .size(30.dp)
                        .shadow(elevation = 2.dp, RoundedCornerShape(6.dp))
                        .background(color = Color("#95a5a6".toColorInt()))
                        .alpha(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.shopping_bag),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
        Text(
            text = name,
            fontSize = 14.sp,
            color = Color.Gray,
            fontWeight = FontWeight(500),
            fontFamily = FontFamily(
                Font(R.font.nunitosans_7pt_condensed_light)
            )
        )
        Text(
            text = "\$ " + price,
            fontSize = 14.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(
                Font(R.font.nunitosans_7pt_condensed_light)
            )
        )
    }
}

@Composable
fun FavoriteItem(icon : Int , name : String , price : Double){
    Row (modifier = Modifier
        .fillMaxWidth()
        .height(110.dp)
        .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(id = icon), contentDescription = null, modifier = Modifier
            .width(110.dp)
            .height(120.dp), contentScale = ContentScale.FillBounds)

        Column (modifier = Modifier
            .width(200.dp)
            .padding(start = 10.dp)
            .fillMaxHeight()) {
            Text(text = name, fontSize = 15.sp, fontWeight = FontWeight(600), color = colorResource(
                id = R.color.gray
            ), fontFamily = FontFamily(
                Font(R.font.nunitosans_7pt_condensed_light)
            ))
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = "\$ " + price, fontSize = 16.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily(
                Font(R.font.nunitosans_7pt_condensed_bold)
            ))
        }
        Column (modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally){
            Icon(painter = painterResource(id = R.drawable.delete), contentDescription = null, modifier = Modifier.size(24.dp))

            Row {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.bag), contentDescription = null, modifier = Modifier.size(24.dp))
                }
            }
        }
    }
}


@Composable
fun CartItem(icon : Int , name : String , price : Double){
    Row (modifier = Modifier
        .fillMaxWidth()
        .height(110.dp)
        .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){
        Image(painter = painterResource(id = icon), contentDescription = null, modifier = Modifier
            .width(110.dp)
            .height(120.dp), contentScale = ContentScale.FillBounds)

        Column (modifier = Modifier
            .width(200.dp)
            .padding(start = 10.dp)
            .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(text = name, fontSize = 15.sp, fontWeight = FontWeight(600), color = colorResource(
                    id = R.color.gray
                ), fontFamily = FontFamily(
                    Font(R.font.nunitosans_7pt_condensed_light)
                ))
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = "\$ "+price, fontSize = 16.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily(
                    Font(R.font.nunitosans_7pt_condensed_bold)
                ))
            }
            Row(
                modifier = Modifier.width(113.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(color = Color("#E0E0E0".toColorInt())),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.add),
                        contentDescription = null,
                        modifier = Modifier.size(13.dp)
                    )
                }
                Text(
                    text = "01",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = FontFamily(
                        Font(R.font.nunitosans_7pt_condensed_bold)
                    )
                )
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(color = Color("#E0E0E0".toColorInt())),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.apart),
                        contentDescription = null,
                        modifier = Modifier.size(13.dp)
                    )
                }
            }


        }
        Column (modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally){
            Icon(painter = painterResource(id = R.drawable.delete), contentDescription = null, modifier = Modifier.size(24.dp))

            Row {

            }
        }
    }
}