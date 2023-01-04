package com.example.a6hw1.youtube.ui.playlist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.a6hw1.R
import com.example.a6hw1.databinding.FragmentPlaylistBinding
import com.example.a6hw1.youtube.App
import com.example.a6hw1.youtube.base.BaseFragment
import com.example.a6hw1.youtube.network.Status
import com.example.a6hw1.youtube.ui.playlist.adapter.PlaylistAdapter
import com.example.a6hw1.youtube.utils.isOnline

class PlaylistFragment() : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {

    private val adapter: PlaylistAdapter by lazy {
        PlaylistAdapter(this::onClick)
    }

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlaylistBinding {
        return FragmentPlaylistBinding.inflate(inflater, container, false)
    }

    override fun initView() {
    }

    override fun initListener() {
        super.initListener()
        binding.noInternet.btnTryAgain.setOnClickListener {
            checkInternet()
        }
    }

    override fun initViewModel() {
        super.initViewModel()
        //Local data
        viewModel.getPlaylistDB.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    viewModel.loading.value = false
                    adapter.addData(it.data?.items)
                }
                Status.LOADING -> {
                    viewModel.loading.value = true
                }
                Status.ERROR
                -> {
                    viewModel.loading.value = false
                    Log.e("ololo", "initViewModel: " + it.msg)

                }
            }
        }

        //Remote data
        viewModel.getPlaylist.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    viewModel.loading.value = false
                    adapter.addData(it.data?.items)
                    it.data?.let { it1 -> viewModel.setPlaylistDB(it1) }
                }
                Status.LOADING -> {
                    viewModel.loading.value = true
                }
                Status.ERROR
                -> {
                    viewModel.loading.value = false
                    Log.e("ololo", "initViewModel: " + it.msg)

                }
            }
        }
        viewModel.setPlaylistDB.observe(viewLifecycleOwner, {
            Log.e("ololo", "initViewModel: " + it )
        })
        viewModel.loading.observe(viewLifecycleOwner){
            binding.progressBar.isVisible = it
        }
        binding.recyclerPlaylist.adapter = adapter
    }



    override fun checkInternet() {
        super.checkInternet()
        val online = isOnline(requireContext())
        binding.recyclerPlaylist.isVisible = online
        binding.noInternetContainer.isVisible = !online

    }

    private fun onClick(id: String) {
        findNavController().navigate(R.id.detailFragment, bundleOf("id" to id))
    }


}