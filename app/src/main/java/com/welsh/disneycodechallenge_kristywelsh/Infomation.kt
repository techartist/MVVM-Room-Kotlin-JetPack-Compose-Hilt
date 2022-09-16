package com.welsh.disneycodechallenge_kristywelsh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Information() {

    val dpHeightText = 14.sp

    val dpHeightSpacer = 200.dp

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom=dpHeightSpacer)
    ) {

        Icon(
            Icons.Filled.Info,
            tint = MaterialTheme.colors.primary,
            contentDescription = "info",
            modifier = Modifier
                .padding(start = 16.dp)
        )
        Text(
            text = "At least one Guest in the party must have a reservation. " +
                    "Guests without reservations must remain in the same booking party in order to enter.",
            modifier = Modifier
                .padding(start = 9.dp)
                .align(Alignment.CenterVertically),
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Normal,
            fontSize = dpHeightText,
            textAlign = TextAlign.Left,
        )

    }
}

@Composable
fun ReservationNeeded() {

    val boxHeight = 92.dp

    val titleTextHeight = 20.sp

    val textHeight = 16.sp

    val iconHeight = 41.dp

    val iconWidth = 28.dp

    val textPadding = 16.dp

    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                MaterialTheme.colors.onSecondary
            )
            .padding(start = textPadding)
            .height(boxHeight)
    ) {
        Column(modifier = Modifier.align(Alignment.CenterVertically)) {

            Text(
                "Reservation Needed",
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Left,
                fontSize = titleTextHeight// horizontal center of the text
            )
            Text(
                "Select at least one Guest that has a reservation to continue.",
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Left,
                fontSize = textHeight// horizontal center of the text
            )
        }

        Icon(
            Icons.Filled.Cancel,
            tint = Color.White,
            contentDescription = "chevron left",
            modifier =
            Modifier
                .width(iconWidth)
                .height(iconHeight)
                .padding(start = 16.dp, end = 9.dp)
        )

    }
}