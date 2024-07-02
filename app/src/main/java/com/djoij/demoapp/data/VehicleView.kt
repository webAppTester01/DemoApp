package com.djoij.demoapp.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.djoij.demoapp.R
import com.djoij.demoapp.common.Color

@Composable
fun NearestVehicleView(nearestCar : CarInfo) {
    Column(
        Modifier
            .background(Color.FFF3F3F3, shape = RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .wrapContentHeight()
            .clipToBounds()
    ) {
        Text(
            "Nearest Car",
            Modifier.padding(start = 22.dp, top = 18.dp),
            fontSize = 16.sp,
            color = Color.FF787878
        )
        Spacer(modifier = Modifier.padding(10.dp))
        nearestCar.carImg?.let {
            Image(
                painter = painterResource(it),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(150.dp)
                    .offset(x = (-60).dp),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            nearestCar.carName,
            Modifier
                .padding(start = 22.dp, top = 0.dp)
                .offset(y = (-10).dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 22.dp)
        ) {
            IndicatorView(nearestCar.distance, R.drawable.jam_gps_f)
            Spacer(modifier = Modifier.padding(4.dp))
            IndicatorView(nearestCar.fuel, R.drawable.bxs_gas_pump)
            Spacer(modifier = Modifier.weight(1f))
            nearestCar.pricePerHour?.let {
                Text(
                    it,
                    Modifier.align(Alignment.CenterVertically),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
    }
}

@Composable
private fun IndicatorView(content: String, resId: Int) {
    Row(
        Modifier
            .wrapContentSize(),
    ) {
        Image(
            painter = painterResource(resId),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(Color.FF787878)
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(text = content, Modifier.align(Alignment.CenterVertically), color = Color.FF787878)
    }
}