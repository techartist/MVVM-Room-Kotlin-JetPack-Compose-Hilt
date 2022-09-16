package com.welsh.disneycodechallenge_kristywelsh

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainHeader(text: String) {
    val dpHeightText = 20.sp

    val dpHeightTopHeader = 51.dp

    Box(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier
            .height(dpHeightTopHeader)
            .width(375.dp)
            .drawWithContent {
                drawContent()
                clipRect { // Not needed if you do not care about painting half stroke outside
                    val strokeWidth = Stroke.DefaultMiter
                    val y = size.height // - strokeWidth
                    // if the whole line should be inside component
                    drawLine(
                        brush = SolidColor(Color(0xFFD0D7DE)),
                        strokeWidth = strokeWidth,
                        cap = StrokeCap.Square,
                        start = Offset.Zero.copy(y = y),
                        end = Offset(x = size.width, y = y)
                    )
                }
            }) {

            Icon(
                Icons.Filled.ChevronLeft,
                tint = MaterialTheme.colors.surface,
                contentDescription = "chevron left",
                modifier =
                Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 9.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text(
                text = text,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = dpHeightText,
                color = MaterialTheme.colors.primary,
            )

        }
    }
}

@Composable
fun SubHeader(text: String) {
    val dpHeightText = 18.sp

    val dpHeightTopHeader = 51.dp

    val paddingLeft = 16.dp

    Row(modifier = Modifier.height(dpHeightTopHeader)) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = paddingLeft),
            color = MaterialTheme.colors.primary,
            fontSize = dpHeightText
        )
    }
}