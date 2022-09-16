package com.welsh.disneycodechallenge_kristywelsh

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.welsh.disneycodechallenge_kristywelsh.room.Guest


@Composable
fun ConfirmButton(value: Int) {
    val dpBottomSpacer = 34.dp

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val color = if (isPressed) MaterialTheme.colors.secondaryVariant
    else if (value > 0) MaterialTheme.colors.surface else MaterialTheme.colors.onSurface
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(bottom =dpBottomSpacer ).fillMaxSize()
    ) {

        Button(
            onClick = {

            },
            shape = RoundedCornerShape(50),
            interactionSource = interactionSource,
            colors = ButtonDefaults.buttonColors(color),
            modifier = Modifier.width(343.dp).align(Alignment.CenterHorizontally)
        ) {
            Text(
                "Continue", color = MaterialTheme.colors.background,
                textAlign = TextAlign.Center,  // horizontal center of the text
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun CustomCheckBox(guest: Guest, updateGuest: (Guest) -> Unit) {
    val paddingInBetweenEntries = 16.dp
    val isCheck = remember { mutableStateOf(guest.selected) }
    Row( modifier = Modifier
        .padding(start = paddingInBetweenEntries)
    ) {
        Card(
            modifier = Modifier.background(Color.White),
            elevation = 0.dp,
            shape = RoundedCornerShape(3.dp),
            border = BorderStroke(1.5.dp, color = Color(0xFF798E99 ))
        ) {
            Box(
                modifier = Modifier
                    .size(25.dp)
                    .background(if (isCheck.value) Color(0xFF118900) else Color.White)
                    .clickable {
                        isCheck.value = !isCheck.value
                        val guestChecked = Guest(
                            name = guest.name,
                            selected = isCheck.value,
                            hasReservation = guest.hasReservation
                        )
                        updateGuest(guestChecked)
                    },
                contentAlignment = Alignment.Center
            ) {
                if(isCheck.value)
                    Icon(Icons.Default.Check, contentDescription = "", tint = Color.White)
            }
        }
    }
}