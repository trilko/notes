package com.dstarlab.notes.screens.note

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dstarlab.notes.R
import com.dstarlab.notes.databinding.FragmentNoteBinding
import com.dstarlab.notes.model.room.entity.AppNote
import com.dstarlab.notes.utilits.APP_ACTIVITY
import com.dstarlab.notes.utilits.logger
import com.dstarlab.notes.utilits.showToast

class NoteFragment : Fragment() {

    private var _binding: FragmentNoteBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: NoteViewModel
    private lateinit var mCurrentNote: AppNote

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(layoutInflater, container, false)
        mCurrentNote = arguments?.getSerializable("note") as AppNote
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        setHasOptionsMenu(true)
        mBinding.noteText.setText(mCurrentNote.text)
        mBinding.noteName.setText(mCurrentNote.name)
        mViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        mBinding.btnUpdate.setOnClickListener {
            val id = mCurrentNote.id
            val name = mBinding.noteName.text.toString()
            val text = mBinding.noteText.text.toString()
            if((name == null)||(name == "")) {
                showToast(getString(R.string.toast_enter_name))
            } else {
                mViewModel.update(AppNote(id = id, name = name, text = text)) {
                    logger.info(getString(R.string.note_update_success))
                }
                APP_ACTIVITY.navHostController.navigate(R.id.action_noteFragment_to_mainFragment)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.note_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.btn_delete -> {
                mViewModel.delete(mCurrentNote) {
                    logger.info(getString(R.string.note_delete_success))
                }
                APP_ACTIVITY.navHostController.navigate(R.id.action_noteFragment_to_mainFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}