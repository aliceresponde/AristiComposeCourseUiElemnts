package com.aliceresponde.aristicomposecourse

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MyDivider(color: Color = Color.LightGray) {
    Divider(
        modifier = Modifier
            .padding(top = 16.dp)
            .height(1.dp)
            .fillMaxWidth(),
        color = color

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    BadgedBox(
        modifier = Modifier
            .padding(16.dp),
        badge = {
            Text(
                modifier = Modifier
                    .background(
                        color = Color.Blue,
                        shape = CircleShape
                    )
                    .padding(4.dp),
                text = "101212",
                color = Color.White,
            )

        }
    ) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "MyIcon",
            tint = Color.Red,
            modifier = Modifier
                .background(Color.White)
                .size(50.dp)
        )
    }
}

@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Filled.Star,
        contentDescription = "MyIcon",
        tint = Color.Yellow,
        modifier = Modifier
            .background(Color.White)
    )
}

@Composable
fun MyCircleImage(borderColor: Color = Color.Red, borderStrokeSize: Dp = 5.dp, @DrawableRes image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "MyImage",
        modifier = Modifier
            .padding(8.dp)
            .clip(CircleShape)
            .border(borderStrokeSize, borderColor, CircleShape),
        contentScale = Crop
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "MyImage",
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp),
        alpha = 0.5f,
    )
}




