package com.dstarlab.notes.screens.note

import android.view.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dstarlab.notes.MainActivity
import com.dstarlab.notes.R
import com.dstarlab.notes.databinding.FragmentNoteBinding
import com.dstarlab.notes.model.room.entity.AppNote
import com.dstarlab.notes.screens.BaseFragment
import com.dstarlab.notes.utilits.showToast

class NoteFragment : BaseFragment<FragmentNoteBinding, NoteViewModel>() {

    private lateinit var mCurrentNote: AppNote

    override fun initialization() {
        mCurrentNote = arguments?.getSerializable("note") as AppNote
        setHasOptionsMenu(true)
        mBinding.noteText.setText(mCurrentNote.text)
        mBinding.noteName.setText(mCurrentNote.name)
        mViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        mBinding.btnUpdate.setOnClickListener {
            val id = mCurrentNote.id
            val name = mBinding.noteName.text.toString()
            val text = mBinding.noteText.text.toString()
            if(name == "") {
                showToast(getString(R.string.toast_enter_name), activity as MainActivity)
            } else {
                mViewModel.update(AppNote(id = id, name = name, text = text))
                mObserverList = Observer {
                    (activity as MainActivity).navHostController.navigate(R.id.action_noteFragment_to_mainFragment)
                }
                mViewModel.allNotes.observe(this, mObserverList)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.note_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.btn_delete -> {
                mViewModel.delete(mCurrentNote)
                mObserverList = Observer {
                    (activity as MainActivity).navHostController.navigate(R.id.action_noteFragment_to_mainFragment)
                }
                mViewModel.allNotes.observe(this, mObserverList)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        mViewModel.allNotes.removeObserver(mObserverList)
    }

    override fun getFragmentBinding(
            inflater: LayoutInflater,
            container: ViewGroup?):
            FragmentNoteBinding
            = FragmentNoteBinding.inflate(inflater,container,false)

    override fun getViewModel(): Class<NoteViewModel> = NoteViewModel::class.java

}