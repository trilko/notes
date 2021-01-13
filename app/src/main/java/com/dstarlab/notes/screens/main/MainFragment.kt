package com.dstarlab.notes.screens.main

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.dstarlab.notes.MainActivity
import com.dstarlab.notes.R
import com.dstarlab.notes.databinding.FragmentMainBinding
import com.dstarlab.notes.di.components.DaggerMainComponent
import com.dstarlab.notes.model.room.entity.AppNote
import com.dstarlab.notes.screens.BaseFragment
import com.dstarlab.notes.utilits.injectViewModel
import com.dstarlab.notes.utilits.navigate

class MainFragment() : BaseFragment<FragmentMainBinding, MainViewModel>() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerMainComponent.builder().application(requireActivity().application).build().inject(this)
    }

    override fun initialization() {
        mBinding.btnAddNote.setOnClickListener {
            navigate(R.id.action_mainFragment_to_addNewNoteFragment, null)
        }

        //init viewModel and RecyclerView
        mAdapter = MainAdapter()
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.adapter = mAdapter
        mObserverList = Observer {
            val list = it.asReversed()
            mAdapter.setListNotes(list)
        }
        mViewModel.allNotes.observe(this, mObserverList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mViewModel.allNotes.removeObserver(mObserverList)
        mRecyclerView.adapter = null
    }

    companion object {
        fun click(note: AppNote, activity: Activity) {
            val bundle = Bundle()
            bundle.putSerializable("note", note)
            //i don't pretty sure how to solve this boilerplate code in this case
            (activity as MainActivity).navHostController.navigate(R.id.action_mainFragment_to_noteFragment, bundle)
        }
    }

    override fun initializeViewModel() {
        mViewModel = injectViewModel(viewModelFactory)
    }

    override fun getFragmentBinding(
            inflater: LayoutInflater,
            container: ViewGroup?
    ) = FragmentMainBinding.inflate(inflater, container, false)

}