package com.djoij.demoapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun MainScreen() {
    Column(
        Modifier
            .padding(vertical = 14.dp, horizontal = 28.dp)
            .verticalScroll(rememberScrollState())) {
        HeaderView()
        Spacer(modifier = Modifier.padding(4.dp))
        NearestVehicleView(R.drawable.car_img, "Fortuner GR")
        Spacer(modifier = Modifier.padding(4.dp))
        UserInfoView(R.drawable.user_img, R.drawable.car_img)
        Spacer(modifier = Modifier.padding(4.dp))
        MoreCarsView()
    }
}

@Composable
private fun HeaderView() {
    Row(
        Modifier
            .padding(horizontal = 22.dp)
            .fillMaxWidth()
            .height(22.dp)
    ) {
        InformationView("Information", R.drawable.jam_gps_f)
        Spacer(modifier = Modifier.padding(22.dp))
        InformationView("Notifications", R.drawable.jam_gps_f)
    }
}

@Composable
fun InformationView(content: String, resId: Int) {
    Row(Modifier.wrapContentSize()) {
        AsyncImage(model = resId, contentDescription = null, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = content, Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
private fun NearestVehicleView(nearestCarId: Int, nearestCarName : String) {
    Column(
        Modifier
            .background(Color(0xFFF3F3F3), shape = RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .wrapContentHeight()
            .clipToBounds()
    ) {
        Text(
            "Nearest Car",
            Modifier.padding(start = 22.dp, top = 18.dp),
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.padding(10.dp))
        AsyncImage(
            model = nearestCarId,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(150.dp)
                .offset(x = (-40).dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            nearestCarName,
            Modifier.padding(start = 22.dp, top = 18.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 22.dp)
        ) {
            //TODO these variable can be passed from above to make generic
            IndicatorView(">870 km", R.drawable.jam_gps_f)
            Spacer(modifier = Modifier.padding(4.dp))
            IndicatorView("50L", R.drawable.jam_gps_f)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                "$45.00/h",
                Modifier.align(Alignment.CenterVertically),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
    }
}

@Composable
fun IndicatorView(content: String, resId: Int) {
    Row(Modifier.wrapContentSize()) {
        AsyncImage(model = resId, contentDescription = null, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = content, Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
private fun UserInfoView(userImg : Int, mapView : Int) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(170.dp)
    ) {
        Column(
            Modifier
                .wrapContentSize()
                .background(Color(0xFFF3F3F3), shape = RoundedCornerShape(20.dp))
                .padding(16.dp)
        ) {
            AsyncImage(
                model = userImg,
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Column {
                Text("Jane Cooper", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("$4,253", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
            }
        }
        Row {
            AsyncImage(
                model = mapView,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
private fun MoreCarsView() {
    Column(
        Modifier
            .background(Color(0xFF2D2D2D), shape = RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {
        MoreCarsHeader(name = "More Cars", resId = R.drawable.jam_gps_f)
        Spacer(modifier = Modifier.padding(8.dp))
        MoreCarItem("Corolla Cross", ">4 km", "50L")
        Spacer(modifier = Modifier.padding(8.dp))
        MoreCarItem("Ionic 5", ">8 km", "80%")
    }
}

@Composable
fun MoreCarsHeader(name: String, resId: Int) {
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(name, fontSize = 18.sp, color = Color.White)
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.jam_gps_f),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun MoreCarItem(name: String, distance: String, detail: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column {
            Text(name, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Row {
                AsyncImage(
                    model = R.drawable.jam_gps_f,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Text(distance, fontSize = 16.sp, color = Color.Gray)
                Spacer(modifier = Modifier.padding(4.dp))
                Text(detail, fontSize = 16.sp, color = Color.Gray)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.jam_gps_f),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}