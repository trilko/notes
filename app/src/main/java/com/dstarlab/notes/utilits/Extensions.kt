package com.dstarlab.notes.utilits

import android.app.Activity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.dstarlab.notes.R
import com.dstarlab.notes.model.room.entity.AppNote

fun Activity.findNavController(@IdRes viewId: Int): NavController =
        Navigation.findNavController(this, viewId)

fun Fragment.navigate(resId: Int, bundle: Bundle? = null) {
    NavHostFragment.findNavController(this).navigate(resId, bundle)
}

fun Fragment.click(note: AppNote) {
    val bundle = Bundle()
    bundle.putSerializable("note", note)
    navigate(R.id.action_mainFragment_to_noteFragment, bundle)
}