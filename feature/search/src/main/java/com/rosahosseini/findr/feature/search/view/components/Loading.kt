package com.rosahosseini.findr.feature.search.view.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rosahosseini.findr.ui.theme.FindrColor
import com.rosahosseini.findr.ui.widget.DotsPulsing

@Composable
internal fun BoxScope.LoadingScreen() {
    Box(modifier = Modifier.align(Alignment.Center)) {
        DotsPulsing(
            delayUnit = 300,
            color = FindrColor.BrandColor,
            modifier = Modifier.size(20.dp)
        )
    }
}
