package com.dstarlab.notes.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.dstarlab.notes.di.ViewModelFactory
import com.dstarlab.notes.model.dto.AppNoteDTO
import javax.inject.Inject

abstract class BaseFragment<VB: ViewBinding, VM: ViewModel> : Fragment() {

    private var _binding : VB ?= null
    protected val mBinding get() = _binding!!
    protected lateinit var mObserverList: Observer<List<AppNoteDTO>>

    @Inject
    lateinit var mViewModel: VM

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = getFragmentBinding(inflater,container)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViewModel()
        initialization()
    }

    abstract fun initialization()

    abstract fun initializeViewModel()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    abstract fun getFragmentBinding(inflater: LayoutInflater,container: ViewGroup?): VB
}