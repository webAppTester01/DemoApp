package com.djoij.demoapp.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.djoij.demoapp.common.Color
import com.djoij.demoapp.common.UserInfo

@Composable
fun UserInfoView(userInfo: UserInfo, mapView: Int) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(170.dp)
    ) {
        Column(
            Modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color.FFF3F3F3, shape = RoundedCornerShape(20.dp))
                .padding(top = 20.dp, start = 20.dp, end = 30.dp, bottom = 10.dp)
        ) {
            Image(
                painter = painterResource(userInfo.img),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Box(Modifier.align(Alignment.CenterHorizontally)) {
                Text(userInfo.name, fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.padding(2.dp))
            Box(Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    userInfo.amt,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .clip(shape = RoundedCornerShape(20.dp))
        ) {
            Image(
                painter = painterResource(mapView),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}