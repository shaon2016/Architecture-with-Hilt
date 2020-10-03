package com.lastblade.androidarchitecturewithhilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.lastblade.androidarchitecturewithhilt.R
import com.lastblade.androidarchitecturewithhilt.base.BaseActivity
import com.lastblade.androidarchitecturewithhilt.data.model.User
import com.lastblade.androidarchitecturewithhilt.util.Result
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private val vm: UserVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun viewRelatedTask() {
        vm.getUsers()

//        vm.users.observe(this, Observer {users->
//            users?.let {
//                rvUsers.layoutManager = LinearLayoutManager(this)
//                rvUsers.adapter = UserRvAdapter(users)
//            }
//        })

        vm.result.observe(this, {
            when (it) {
                is Result.InProgress -> {
                    if (it.isLoading)
                        showProgressing(true)
                    else
                        hideProgressing()
                }
                is Result.Success -> {
                    handleSuccessfulResponse(it)
                }
            }
        })
    }

    private fun handleSuccessfulResponse(success: Result.Success<Any>) {
        if (success.data is User) {

        }
    }


}