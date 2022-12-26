package com.rosahosseini.bleacher.photodetail.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rosahosseini.bleacher.model.Photo
import com.rosahosseini.bleacher.ui.R
import com.rosahosseini.bleacher.ui.theme.BleacherColor
import com.rosahosseini.bleacher.ui.theme.Dimen
import com.rosahosseini.bleacher.ui.theme.Typography
import com.rosahosseini.bleacher.ui.widget.LoadImage

@Composable
fun PhotoDetailRoute(getPhoto: () -> Photo, onBackPressed: () -> Unit) {
    PhotoDetailScreen(getPhoto, onBackPressed)
}

@Composable
fun PhotoDetailScreen(getPhoto: () -> Photo, onBackPressed: () -> Unit) {
    Box(Modifier.background(BleacherColor.DarkBackground)) {
        LoadImage(
            modifier = Modifier
                .fillMaxSize(),
            url = getPhoto().urlSmall,
            description = getPhoto().description,
            contentScale = ContentScale.FillBounds
        )
        TopTool(onBackPressed)
        BottomContent(getPhoto)
    }
}

@Composable
private fun BoxScope.TopTool(onBackPressed: () -> Unit) {
    Box(
        modifier = Modifier
            .align(Alignment.TopCenter)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(BleacherColor.DarkBackground, Color.Transparent)
                )
            )
            .fillMaxWidth()
            .padding(Dimen.defaultMarginDouble)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(24.dp)
                .clickable { onBackPressed() }
        )
    }
}

@Composable
private fun BoxScope.BottomContent(getPhoto: () -> Photo) {
    getPhoto().title?.let { title ->
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(BleacherColor.DarkBackground, Color.Transparent),
                        startY = Float.POSITIVE_INFINITY,
                        endY = 0f
                    )
                )
                .padding(Dimen.defaultMarginDouble)
        ) {
            Text(
                text = title,
                style = Typography.h3,
                color = BleacherColor.TextLight,
                modifier = Modifier
                    .fillMaxWidth(),
            )
            getPhoto().description?.let { description ->
                Text(
                    text = description,
                    style = Typography.body2,
                    color = BleacherColor.TextLight,
                    modifier = Modifier
                        .alpha(1f)
                        .fillMaxWidth(),
                )
            }
        }
    }
}