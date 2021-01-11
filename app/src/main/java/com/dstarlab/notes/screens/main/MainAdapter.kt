package com.dstarlab.notes.screens.main

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
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
            val activity = it.context as AppCompatActivity
            MainFragment.click(mListNotes[holder.adapterPosition], activity)
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
        updateList(list)
        mListNotes = list
    }

    private fun updateList(newList: List<AppNote>) {
        val diffResult = DiffUtil.calculateDiff(MainDiffUtils(this.mListNotes, newList))
        diffResult.dispatchUpdatesTo(this)
    }
}