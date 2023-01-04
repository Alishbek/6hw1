package com.example.a6hw1.youtube.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.a6hw1.youtube.base.BaseViewModel
import com.example.a6hw1.youtube.data.remote.ApiService
import com.example.a6hw1.youtube.data.remote.Repository
import com.example.a6hw1.youtube.data.remote.RetrofitClient
import com.example.a6hw1.youtube.model.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : BaseViewModel() {

    private val repo = Repository()
    fun getPlaylistItem(id: String) = repo.getPlaylistItems(id)
}