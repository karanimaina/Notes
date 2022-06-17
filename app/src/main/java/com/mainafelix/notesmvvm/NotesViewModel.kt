package com.mainafelix.notesmvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mainafelix.notesmvvm.data.NoteDatabase
import com.mainafelix.notesmvvm.data.NoteRepository
import com.mainafelix.notesmvvm.models.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel (application: Application):AndroidViewModel(application) {
    val  allNotes : LiveData<List<Note>>
    val  repository: NoteRepository
    init {
        val  dao = NoteDatabase.getDatabase(application).getNotesDao()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }
    fun  deleteNote(note: Note)= viewModelScope.launch (Dispatchers.IO){
        repository.delete(note)
    }
    fun  updateNote (note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(note)
    }
   fun addNote (note: Note)  = viewModelScope.launch (Dispatchers.IO){
       repository.insert(note)
   }
}