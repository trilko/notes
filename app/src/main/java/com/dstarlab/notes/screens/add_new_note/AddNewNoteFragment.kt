package com.dstarlab.notes.screens.add_new_note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.dstarlab.notes.MainActivity
import com.dstarlab.notes.R
import com.dstarlab.notes.databinding.FragmentAddNewNoteBinding
import com.dstarlab.notes.di.components.DaggerMainComponent
import com.dstarlab.notes.model.dto.AppNoteDTO
import com.dstarlab.notes.screens.BaseFragment
import com.dstarlab.notes.utilits.injectViewModel
import com.dstarlab.notes.utilits.navigate
import com.dstarlab.notes.utilits.showToast

class AddNewNoteFragment : BaseFragment<FragmentAddNewNoteBinding, AddNewNoteViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMainComponent.builder().application(requireActivity().application).build().inject(this)
    }

    override fun initialization() {
        mBinding.btnAddNote.setOnClickListener {
            val name = mBinding.inputNameNote.text.toString()
            val text = mBinding.inputTextNote.text.toString()
            if (name.isEmpty()) {
                showToast(getString(R.string.toast_enter_name), activity as MainActivity)
            } else {
                mViewModel.insert(AppNoteDTO(name = name, text = text))
                mObserverList = Observer {
                    navigate(R.id.action_addNewNoteFragment_to_mainFragment, null)
                }
                mViewModel.allNotes.observe(this, mObserverList)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mViewModel.allNotes.removeObserver(mObserverList)
    }

    override fun initializeViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getFragmentBinding(
            inflater: LayoutInflater,
            container: ViewGroup?):
            FragmentAddNewNoteBinding
            = FragmentAddNewNoteBinding.inflate(inflater, container, false)

}