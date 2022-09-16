package com.welsh.disneycodechallenge_kristywelsh.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GuestDao {

    @Query("SELECT * from guest ORDER BY `Guest Name` ASC")
    fun getAllGuests(): LiveData<List<Guest>>

    @Query("SELECT * from guest WHERE hasReservation = 1 ORDER BY `Guest Name` ASC")
    fun getGuestWithReservation(): LiveData<List<Guest>>

    @Query("SELECT * from guest WHERE hasReservation = 0 ORDER BY `Guest Name` ASC")
    fun getGuestWithoutReservations(): LiveData<List<Guest>>

    @Query("SELECT Count(*) from guest WHERE selected = 1 ORDER BY `Guest Name` ASC")
    fun getSelectedGuests(): LiveData<Int>

    @Update
    fun update (guest: Guest)

    @Insert
    fun insert(guest: Guest)

    @Query("DELETE FROM guest")
    fun deleteAll()

    @Query("SELECT Count(*) From guest")
    fun getCountOfGuests() : Int
}
