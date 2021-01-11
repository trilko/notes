package com.dstarlab.notes.screens.add_new_note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dstarlab.notes.MainActivity
import com.dstarlab.notes.R
import com.dstarlab.notes.databinding.FragmentAddNewNoteBinding
import com.dstarlab.notes.model.room.entity.AppNote
import com.dstarlab.notes.screens.BaseFragment
import com.dstarlab.notes.utilits.showToast

class AddNewNoteFragment : BaseFragment<FragmentAddNewNoteBinding, AddNewNoteViewModel>() {

    override fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddNewNoteViewModel::class.java)
        mBinding.btnAddNote.setOnClickListener {
            val name = mBinding.inputNameNote.text.toString()
            val text = mBinding.inputTextNote.text.toString()
            if (name.isEmpty()) {
                showToast(getString(R.string.toast_enter_name), activity as MainActivity)
            } else {
                mViewModel.insert(AppNote(name = name, text = text))
                mObserverList = Observer {
                    (activity as MainActivity).navHostController.navigate(R.id.action_addNewNoteFragment_to_mainFragment)
                }
                mViewModel.allNotes.observe(this, mObserverList)
            }
        }
    }

    override fun getFragmentBinding(
            inflater: LayoutInflater,
            container: ViewGroup?):
            FragmentAddNewNoteBinding
    = FragmentAddNewNoteBinding.inflate(inflater, container, false)

    override fun onDestroy() {
        super.onDestroy()
        mViewModel.allNotes.removeObserver(mObserverList)
    }

    override fun getViewModel(): Class<AddNewNoteViewModel> = AddNewNoteViewModel::class.java

}