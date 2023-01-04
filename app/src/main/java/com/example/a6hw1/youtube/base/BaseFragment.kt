package com.example.a6hw1.youtube.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.a6hw1.R

abstract class BaseFragment<VB : ViewBinding, VM: BaseViewModel> : Fragment() {
    protected lateinit var binding: VB
    protected abstract val viewModel: VM


    abstract fun inflateViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkInternet()
        initView()
        initListener()
        initViewModel()
    }

    abstract fun initView()
    open fun initListener(){}
    open fun initViewModel(){}
    open fun checkInternet(){}
}