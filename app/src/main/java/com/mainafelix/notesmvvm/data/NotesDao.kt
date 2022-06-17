package com.mainafelix.notesmvvm.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mainafelix.notesmvvm.models.Note

interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  insert(note: Note)
    @Delete
    suspend fun  delete(note: Note)
    @Query("SELECT* FROM notes ORDER by id ASC")
    fun getAll():LiveData<List<Note>>
    @Update
    suspend fun update (note:Note)



}