package com.djoij.demoapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.djoij.demoapp.R
import com.djoij.demoapp.common.UserInfo
import com.djoij.demoapp.data.CarInfo
import com.djoij.demoapp.data.HeaderView
import com.djoij.demoapp.data.MoreCarsView
import com.djoij.demoapp.data.NearestVehicleView
import com.djoij.demoapp.data.UserInfoView

@Composable
fun MainScreen() {
    Column(
        Modifier
            .padding(vertical = 14.dp, horizontal = 28.dp)
            .verticalScroll(rememberScrollState())
    ) {
        HeaderView()
        Spacer(modifier = Modifier.padding(10.dp))
        val nearestCar = CarInfo("Fortuner GR", ">870 km", "50L", "$45.00/h", R.drawable.car_img)
        NearestVehicleView(nearestCar)
        Spacer(modifier = Modifier.padding(10.dp))
        val userInfo = UserInfo("Jane Cooper", R.drawable.user_img, "$4,253")
        UserInfoView(userInfo, R.drawable.map_img)
        Spacer(modifier = Modifier.padding(10.dp))
        MoreCarsView()
    }
}