package com.example.a6hw1.youtube.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.a6hw1.R
import com.example.a6hw1.databinding.ActivityMainBinding
import com.example.a6hw1.youtube.base.BaseActivity
import com.example.a6hw1.youtube.ui.playlist.PlaylistFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

//    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
//        super.onCreate(savedInstanceState, persistentState)
//            Navigation.findNavController(this, R.id.mainActivity).navigate(R.id.action_mainActivity_to_playlistFragment)
//    }



}