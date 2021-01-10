package com.dstarlab.notes.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.dstarlab.notes.R
import com.dstarlab.notes.databinding.FragmentMainBinding
import com.dstarlab.notes.model.room.entity.AppNote
import com.dstarlab.notes.screens.BaseFragment
import com.dstarlab.notes.utilits.APP_ACTIVITY
import com.dstarlab.notes.utilits.logger

class MainFragment() : BaseFragment<FragmentMainBinding, MainViewModel>() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: MainAdapter
    private lateinit var mObserverList: Observer<List<AppNote>>

    override fun initialization() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mBinding.btnAddNote.setOnClickListener {
            APP_ACTIVITY.navHostController.navigate(R.id.action_mainFragment_to_addNewNoteFragment)
        }

        //init viewModel and RecyclerView
        mAdapter = MainAdapter()
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.adapter = mAdapter
        mObserverList = Observer {
            val list = it.asReversed()
            mAdapter.setListNotes(list)
        }
        mViewModel.initAllNotes()
        mViewModel.allNotes.observe(this, mObserverList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mViewModel.allNotes.removeObserver(mObserverList)
        mRecyclerView.adapter = null
    }

    companion object {
        fun click(note: AppNote) {
            val bundle = Bundle()
            bundle.putSerializable("note", note)
            APP_ACTIVITY.navHostController.navigate(R.id.action_mainFragment_to_noteFragment, bundle)
        }
    }

    override fun getFragmentBinding(
            inflater: LayoutInflater,
            container: ViewGroup?
    ) = FragmentMainBinding.inflate(inflater,container,false)

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

}