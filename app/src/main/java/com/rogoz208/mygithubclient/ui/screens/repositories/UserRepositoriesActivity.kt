package com.rogoz208.mygithubclient.ui.screens.repositories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.mygithubclient.R
import com.rogoz208.mygithubclient.databinding.ActivityUserRepositoriesBinding

class UserRepositoriesActivity : AppCompatActivity(R.layout.activity_user_repositories) {

    private val binding by viewBinding(ActivityUserRepositoriesBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}