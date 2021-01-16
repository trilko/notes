package com.dstarlab.notes.utilits

import android.widget.Toast
import com.dstarlab.notes.MainActivity

fun showToast(message: String, activity: MainActivity) {
    Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
}