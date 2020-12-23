package com.dstarlab.notes.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModelProvider
import com.dstarlab.notes.R
import com.dstarlab.notes.databinding.FragmentMainBinding
import com.dstarlab.notes.utilits.APP_ACTIVITY
import com.dstarlab.notes.utilits.logger
import java.util.logging.Logger

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.initDatabase {
            logger.info(getString(R.string.database_init_success))
        }

        mBinding.btnAddNote.setOnClickListener {
            APP_ACTIVITY.mNavHostController.navigate(R.id.action_mainFragment_to_addNewNoteFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}