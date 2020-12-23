package com.dstarlab.notes.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dstarlab.notes.R
import com.dstarlab.notes.model.room.entity.AppNote
import kotlinx.android.synthetic.main.note_item.view.*

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var mListNotes = emptyList<AppNote>()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameNote: TextView = view.item_note_name
        val textNote: TextView = view.item_note_text
    }

    override fun onViewAttachedToWindow(holder: ViewHolder) {
        holder.itemView.setOnClickListener {
            MainFragment.click(mListNotes[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameNote.text = mListNotes[position].name
        holder.textNote.text = mListNotes[position].text
    }

    override fun getItemCount(): Int = mListNotes.size

    fun setListNotes(list: List<AppNote>) {
        mListNotes = list
        notifyDataSetChanged()
    }
}