package com.welsh.disneycodechallenge_kristywelsh

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.welsh.disneycodechallenge_kristywelsh.room.Guest
import com.welsh.disneycodechallenge_kristywelsh.room.GuestRespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GuestViewModel @Inject constructor(
    private val guestRespository: GuestRespository
) : ViewModel() {

    val guestWithReservations:LiveData<List<Guest>>
    val guestWithoutReservations:LiveData<List<Guest>>
    val allGuests: LiveData<List<Guest>>
    val selectedGuests: LiveData<Int>

    init {
        populateDatabase()
        guestWithoutReservations = guestRespository.guestsWithoutReservations
        guestWithReservations = guestRespository.guestsWithReservations
        allGuests = guestRespository.allGuests
        selectedGuests = guestRespository.selectedGuests
    }

    fun updateGuest(guest: Guest) {
        viewModelScope.launch(Dispatchers.IO) {
            guestRespository.updateGuest(guest)
        }
    }

    fun populateDatabase() {
        viewModelScope.launch(Dispatchers.IO) {

            guestRespository.deleteAllGuests()

            var guest = Guest(name = "Henry Gibson", hasReservation = true, selected = false)
            guestRespository.insert(guest)
            guest = Guest(name = "Laura Gibson", hasReservation = false, selected = false)
            guestRespository.insert(guest)
            guest = Guest(name = "Lottie Gibson", hasReservation = true, selected = false)
            guestRespository.insert(guest)
            guest = Guest(name = "Steve Gibson", hasReservation = false, selected = false)
            guestRespository.insert(guest)
        }
    }
}