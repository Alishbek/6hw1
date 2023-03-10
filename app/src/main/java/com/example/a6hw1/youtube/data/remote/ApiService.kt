package com.example.a6hw1.youtube.data.remote

import com.example.a6hw1.BuildConfig
import com.example.a6hw1.youtube.`object`.Constant
import com.example.a6hw1.youtube.model.Playlist
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    suspend fun getPlaylist(
        @Query("part") part: String = Constant.PART,
        @Query("channelId") channelId: String = Constant.CHANNEL_ID,
        @Query("maxResults") maxResults: String = Constant.MAX_RESULTS,
        @Query("key") key: String = BuildConfig.API_KEY,
    ):Response<Playlist>

    @GET("playlistItems")
    suspend fun getPlaylistItems(
        @Query("part") part: String = Constant.PART,
        @Query("playlistId") playlistId: String,
        @Query("maxResults") maxResults: String = Constant.MAX_RESULTS,
        @Query("key") key: String = BuildConfig.API_KEY
    ):Response<Playlist>
}