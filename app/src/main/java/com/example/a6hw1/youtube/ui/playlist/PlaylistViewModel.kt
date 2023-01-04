package com.example.a6hw1.youtube.ui.playlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.a6hw1.youtube.base.BaseViewModel
import com.example.a6hw1.youtube.data.remote.ApiService
import com.example.a6hw1.youtube.data.remote.Repository
import com.example.a6hw1.youtube.data.remote.RetrofitClient
import com.example.a6hw1.youtube.model.Playlist
import com.example.a6hw1.youtube.network.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.security.auth.login.LoginException


class PlaylistViewModel : BaseViewModel() {
    private val repo = Repository()
    val setPlaylistLiveData = MutableLiveData<Playlist>()
    val setPlaylistDB = setPlaylistLiveData.switchMap {
        repo.setPlaylistDB(it)
    }

    val getPlaylist: LiveData<Resource<Playlist>> = repo.getPlaylist()

    val getPlaylistDB: LiveData<Resource<Playlist>> = repo.getPlaylistDB()

    fun setPlaylistDB(playlist: Playlist){
        setPlaylistLiveData.postValue(playlist)
    }
}