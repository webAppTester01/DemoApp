package com.djoij.demoapp.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.djoij.demoapp.R

@Composable
 fun HeaderView() {
    Row(
        Modifier
            .padding(horizontal = 22.dp)
            .fillMaxWidth()
            .height(22.dp)
    ) {
        InformationView("Information", R.drawable.info)
        Spacer(modifier = Modifier.padding(22.dp))
        InformationView("Notifications", R.drawable.bell)
    }
}

@Composable
private fun InformationView(content: String, resId: Int) {
    Row(Modifier.wrapContentSize()) {
        Image(
            painter = painterResource(resId),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = content,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}