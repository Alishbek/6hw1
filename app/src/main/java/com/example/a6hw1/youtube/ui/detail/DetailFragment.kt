package com.example.a6hw1.youtube.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.a6hw1.R
import com.example.a6hw1.databinding.FragmentDetailBinding
import com.example.a6hw1.youtube.base.BaseFragment
import com.example.a6hw1.youtube.ui.playlist.PlaylistFragment
import com.example.a6hw1.youtube.ui.playlist.PlaylistViewModel


class DetailFragment : BaseFragment<FragmentDetailBinding, PlaylistViewModel>() {

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)
    }



    override fun initListener() {
        super.initListener()
    }

    override fun initView() {
        TODO("Not yet implemented")
    }



}