package com.example.a6hw1.youtube.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.a6hw1.youtube.model.Playlist

@Database(entities = [Playlist::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDataBase: RoomDatabase() {
    abstract fun dao(): PlaylistDao
}