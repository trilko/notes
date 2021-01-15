package com.dstarlab.notes.model.mapper

import com.dstarlab.notes.model.dto.AppNoteDTO
import com.dstarlab.notes.model.room.entity.AppNote

class AppNoteMapper: DomainMapper<AppNote, AppNoteDTO> {

    override fun mapToDomainModel(model: AppNote): AppNoteDTO {
        return AppNoteDTO(
                id = model.id,
                name = model.name,
                text = model.text)
    }

    fun toDomainList(initial: List<AppNote>): List<AppNoteDTO>{
        return initial.map { mapToDomainModel(it) }
    }

    override fun mapFromDomainModel(domainModel: AppNoteDTO): AppNote {
        return AppNote(
                id = domainModel.id,
                name = domainModel.name,
                text = domainModel.text
        )
    }

    fun fromDomainList(initial: List<AppNoteDTO>): List<AppNote>{
        return initial.map { mapFromDomainModel(it) }
    }

}