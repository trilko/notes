package com.dstarlab.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.dstarlab.notes.databinding.ActivityMainBinding
import com.dstarlab.notes.di.components.DaggerMainComponent
import com.dstarlab.notes.di.components.MainComponent
import com.dstarlab.notes.screens.main.MainFragment
import com.dstarlab.notes.utilits.findNavController

class MainActivity : AppCompatActivity() {

    lateinit var mToolbar: Toolbar
    lateinit var navHostController: NavController
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Notes)
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mToolbar = mBinding.toolbar
        findNavController(R.id.nav_host_fragment)
        navHostController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setSupportActionBar(mToolbar)
        title = getString(R.string.title)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}