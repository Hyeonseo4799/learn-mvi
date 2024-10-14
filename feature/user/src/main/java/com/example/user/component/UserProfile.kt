package com.example.user.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.user.R
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun UserProfile(
    imageUrl: String,
    username: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(color = Color.LightGray,)
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        GlideImage(
            imageModel = { imageUrl },
            modifier = Modifier
                .clip(CircleShape)
                .size(100.dp),
            previewPlaceholder = painterResource(R.drawable.img_placeholder)
        )
        Text(
            text = username,
            fontSize = 18.sp,
        )
    }
}

@Preview
@Composable
fun UserProfilePreview() {
    UserProfile(imageUrl = "", username = "Hyeonseo4799", onClick = { })
}