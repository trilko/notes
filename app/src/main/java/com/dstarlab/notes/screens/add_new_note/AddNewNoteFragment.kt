package com.dstarlab.notes.screens.add_new_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.dstarlab.notes.R
import com.dstarlab.notes.databinding.FragmentAddNewNoteBinding
import com.dstarlab.notes.model.room.entity.AppNote
import com.dstarlab.notes.screens.BaseFragment
import com.dstarlab.notes.utilits.APP_ACTIVITY
import com.dstarlab.notes.utilits.logger
import com.dstarlab.notes.utilits.showToast

class AddNewNoteFragment : BaseFragment<FragmentAddNewNoteBinding>() {

    private lateinit var mViewModel: AddNewNoteViewModel

    override fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddNewNoteViewModel::class.java)
        mBinding.btnAddNote.setOnClickListener {
            val name = mBinding.inputNameNote.text.toString()
            val text = mBinding.inputTextNote.text.toString()
            if (name.isEmpty()) {
                showToast(getString(R.string.toast_enter_name))
            } else {
                mViewModel.insert(AppNote(name = name, text = text)) {
                    logger.info(getString(R.string.note_insert_success))
                }
                APP_ACTIVITY.navHostController.navigate(R.id.action_addNewNoteFragment_to_mainFragment)
            }
        }
    }

    override fun getFragmentBinding(
            inflater: LayoutInflater,
            container: ViewGroup?):
            FragmentAddNewNoteBinding
    = FragmentAddNewNoteBinding.inflate(inflater, container, false)


}