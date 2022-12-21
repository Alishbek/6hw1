package com.example.a6hw1.youtube.model

data class Playlist(
    var etag: String? = null,
    var items: List<Item>? = null,
    var kind: String? = null,
    var nextPageToken: String? = null,
    var pageInfo: PageInfo? = null
)