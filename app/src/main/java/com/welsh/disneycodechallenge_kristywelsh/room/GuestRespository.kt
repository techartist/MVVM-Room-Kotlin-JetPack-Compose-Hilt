package com.welsh.disneycodechallenge_kristywelsh.room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GuestRespository @Inject constructor(val guestDao: GuestDao) {

    val allGuests: LiveData<List<Guest>> = guestDao.getAllGuests()
    val guestsWithReservations: LiveData<List<Guest>> = guestDao.getGuestWithReservation()
    val guestsWithoutReservations: LiveData<List<Guest>> = guestDao.getGuestWithoutReservations()
    val selectedGuests: LiveData<Int> = guestDao.getSelectedGuests()

    @WorkerThread
    suspend fun insert(guest: Guest) {
        guestDao.insert(guest)
    }

    @WorkerThread
    suspend fun deleteAllGuests() {
        guestDao.deleteAll()
    }

    @WorkerThread
    suspend fun updateGuest(guest: Guest) {
        guestDao.update(guest)
    }
}
