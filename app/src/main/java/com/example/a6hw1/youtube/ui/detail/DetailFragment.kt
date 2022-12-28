package com.example.a6hw1.youtube.ui.detail

import android.os.Bundle
import android.util.Log
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


class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    override val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this)[DetailViewModel::class.java]
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
        val id = arguments?.getString("id")
        viewModel.getPlaylistItems(id.toString()).observe(viewLifecycleOwner){
            Log.e("ololo", "initView: " + it)
        }
    }


}