package com.welsh.disneycodechallenge_kristywelsh

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.welsh.disneycodechallenge_kristywelsh.room.Guest

@Composable
fun MainScreen() {
    val viewModel: GuestViewModel = viewModel()
    val selectedGuests by viewModel.selectedGuests.observeAsState(0)
    val guestsWithReservations by viewModel.guestWithReservations.observeAsState()
    val guestsWithoutReservations by viewModel.guestWithoutReservations.observeAsState()
    Column  {
        MainHeader(text = "Selected Guests")
        guestsWithReservations?.let { ListOfGuests(it, viewModel::updateGuest) }
        guestsWithoutReservations?.let { ListOfGuests(it, viewModel::updateGuest) }
        Information()
        if (guestsWithReservations?.size == 0) {
            ReservationNeeded()
        } else {
            ConfirmButton(selectedGuests)
        }
    }
}

@Composable
fun ListOfGuests(list: List<Guest>, updateGuest: (Guest) -> Unit) {

    LazyColumn {
        item{ if (list[0].hasReservation) {SubHeader(text = "These Guests Have Reservations") }
        else SubHeader(text = "These Guests Need Reservations")}
        items(
            items = list,
            key = { guest ->
                // Return a stable + unique key for the item
                guest.name
            }
        ) { guest ->
            CheckBoxEntry(guest, updateGuest)
        }
    }
}

@Composable
fun CheckBoxEntry(guest: Guest, updateGuest: (Guest) -> Unit) {
    val dpHeightText = 16.sp

    val paddingLeft = 16.dp

    val checkedState = remember { mutableStateOf(guest.selected) }
    Row(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)) {
        CustomCheckBox(guest, updateGuest)

        Text(
            text = guest.name,
            fontSize  = dpHeightText,
            color = MaterialTheme.colors.secondary,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(start=paddingLeft)
        )
    }
}