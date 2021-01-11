package com.dstarlab.notes.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import com.dstarlab.notes.model.room.entity.AppNote

abstract class BaseFragment<VB: ViewBinding, VM: AndroidViewModel> : Fragment() {

    protected lateinit var mViewModel: VM
    private var _binding : VB ?= null
    protected val mBinding get() = _binding!!
    protected lateinit var mObserverList: Observer<List<AppNote>>

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
        initialization()
    }

    abstract fun initialization()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    abstract fun getFragmentBinding(inflater: LayoutInflater,container: ViewGroup?): VB
    abstract fun getViewModel() : Class<VM>
}