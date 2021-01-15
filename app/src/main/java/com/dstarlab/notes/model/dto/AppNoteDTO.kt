package com.dstarlab.notes.model.dto

import java.io.Serializable

data class AppNoteDTO (
    val id: Int = 0,
    val name: String = "",
    val text: String = "" ) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AppNoteDTO

        if (id != other.id) return false
        if (name != other.name) return false
        if (text != other.text) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + text.hashCode()
        return result
    }

}