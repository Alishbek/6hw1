package com.example.a6hw1.youtube.model

data class Item(
    var contentDetails: ContentDetails? = null,
    var etag: String? = null,
    var id: String? = null,
    var kind: String? = null,
    var snippet: Snippet? = null
)