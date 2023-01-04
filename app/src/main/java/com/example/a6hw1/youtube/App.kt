package com.example.a6hw1.youtube

import android.app.Application
import androidx.room.Room
import com.example.a6hw1.youtube.data.local.AppDataBase

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppDataBase::class.java,"playlist.db").build()
    }

    companion object{
        lateinit var db: AppDataBase
    }
}