package com.example.a6hw1.youtube.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    protected lateinit var binding: VB

    abstract fun inflateViewBinding(inflater: LayoutInflater): VB
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = inflateViewBinding(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    open fun initView(){

    }
}