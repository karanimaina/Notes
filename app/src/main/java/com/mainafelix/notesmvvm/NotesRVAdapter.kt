package com.mainafelix.notesmvvm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mainafelix.notesmvvm.models.Note

class NoteRVAdapter(
    val context: Context,
  val allNotes: ArrayList<Note> = ArrayList<Note>()
) : RecyclerView.Adapter<NoteRVAdapter.myViewHolder>() {

   inner class myViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView) {
       val noteTV = itemView.findViewById<TextView>(R.id.idTVNote)
       val dateTV = itemView.findViewById<TextView>(R.id.idTVDate)
       val deleteIV = itemView.findViewById<ImageView>(R.id.idIVDelete)
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_rv_item,parent,false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

  val currentNote =  allNote[position]
   holder.apply {
       noteTV.text = currentNote.noteTitle
       dateTV.text = currentNote.timeStamp
       deleteIV.setOnClickListener {
       allNotes.remove(currentNote)
       }
       itemView.setOnClickListener {
           allNotes[currentNote.id]
       }

   }
    }

    override fun getItemCount(): Int {
        return  allNotes.size
    }
    fun  updatedList(newList:List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }

}


private val allNote = ArrayList<Note>()
