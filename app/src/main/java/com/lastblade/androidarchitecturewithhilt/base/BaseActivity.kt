package com.lastblade.androidarchitecturewithhilt.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lastblade.androidarchitecturewithhilt.util.D
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity(), Task {

    private val pbDialog by lazy {
        D.showProgressDialog(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewRelatedTask()
    }

    fun showProgressing(cancelable: Boolean = false) {
        pbDialog.setCancelable(cancelable)
        pbDialog.show()
    }

    fun hideProgressing() {
        if (pbDialog.isShowing) pbDialog.dismiss()
    }
}

interface Task {
    fun viewRelatedTask()
}