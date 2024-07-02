package com.djoij.demoapp.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.djoij.demoapp.R
import com.djoij.demoapp.common.Color

@Composable
fun MoreCarsView() {
    Column(
        Modifier
            .background(Color.FF2D2D2D, shape = RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 20.dp, top = 20.dp, end = 24.dp, bottom = 22.dp)
    ) {
        MoreCarsHeader(name = "More Cars", resId = R.drawable.akar_icons_more_horizontal)
        Spacer(modifier = Modifier.padding(4.dp))
        val otherOptions = listOf(
            CarInfo("Corolla Cross", ">4 km", "50L"),
            CarInfo("Ionic 5", ">8 km", "80%", isElectric = true),
        )
        otherOptions.forEachIndexed { ind, it ->
            Spacer(modifier = Modifier.padding(4.dp))
            MoreCarItem(it.carName, it.distance, it.fuel, it.isElectric)
            if(ind + 1 != otherOptions.size){
                Spacer(modifier = Modifier.padding(4.dp))
                Divider(color = Color.FF4B4B4B, thickness = 1.dp)
            }
        }
    }
}

@Composable
private fun MoreCarsHeader(name: String, resId: Int) {
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(name, fontSize = 12.sp, color = Color.FFD4D4D4)
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = resId),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
private fun MoreCarItem(name: String, distance: String, detail: String, isElectric : Boolean) {
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column {
            Text(name, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = androidx.compose.ui.graphics.Color.White)
            Spacer(modifier = Modifier.padding(6.dp))
            Row {
                Image(
                    painter = painterResource(id = R.drawable.jam_gps_f),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp),
                    colorFilter = ColorFilter.tint(Color.FFD8D8D8),
                    alignment = Alignment.Center
                )
                Text(distance, fontSize = 16.sp, color = Color.FFD8D8D8)
                Spacer(modifier = Modifier.padding(6.dp))
                Image(
                    painter = painterResource(id = if (isElectric) R.drawable.bxs_battery_low else R.drawable.bxs_gas_pump),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp),
                    colorFilter = ColorFilter.tint(Color.FFD8D8D8),
                    alignment = Alignment.Center
                )
                Text(detail, fontSize = 16.sp, color = Color.FFD8D8D8)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .size(30.dp)
                .background(
                    androidx.compose.ui.graphics.Color.White,
                    shape = RoundedCornerShape(30.dp)
                )
                .align(Alignment.CenterVertically)
        ){
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.Center)
            )
        }

    }
}