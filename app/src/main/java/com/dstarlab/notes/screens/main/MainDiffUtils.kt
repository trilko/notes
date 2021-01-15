package com.dstarlab.notes.screens.main

import androidx.recyclerview.widget.DiffUtil
import com.dstarlab.notes.model.dto.AppNoteDTO
import com.dstarlab.notes.model.room.entity.AppNote

class MainDiffUtils(private val oldList: List<AppNoteDTO>, private val newList: List<AppNoteDTO>): DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}