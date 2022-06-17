package com.mainafelix.notesmvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mainafelix.notesmvvm.models.Note
import java.time.Instant

@Database(entities = [Note::class], version = 1, exportSchema = false )
abstract class NoteDatabase:RoomDatabase() {
    abstract  fun getNotesDao():NotesDao
    companion object{
        //@volatle means the instance will not be stored in the local cache
        @Volatile
        private  var  INSTANCE :NoteDatabase? =null
        fun getDatabase(context: Context):NoteDatabase{
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            // synchronisation prevents different threads from accessing the databae instance at the same time
            return INSTANCE?: synchronized(this){
                val  instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                //return instance
                instance
            }
        }


    }
}