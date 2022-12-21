package com.example.a6hw1.youtube.ui.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.a6hw1.databinding.FragmentPlaylistBinding
import com.example.a6hw1.youtube.base.BaseFragment
import com.example.a6hw1.youtube.ui.playlist.adapter.PlaylistAdapter

class PlaylistFragment() : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {

    private val adapter: PlaylistAdapter by lazy{
        PlaylistAdapter()
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
        TODO("Not yet implemented")
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getPlaylist().observe(viewLifecycleOwner){
//            Log.e("ololo", "initViewModel: " +it)
            adapter.addData(it.items)

        }
        binding.recyclerPlaylist.adapter = adapter
    }


}