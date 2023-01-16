package com.example.testapp.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.adapters.MaterialDataAdapter
import com.example.testapp.MaterialViewModel
import com.example.testapp.R
import com.example.testapp.databinding.FragmentThirdBinding

class ThirdFragment: Fragment() {
    lateinit var binding: FragmentThirdBinding
    lateinit var materialDataAdapter: MaterialDataAdapter
    val materialViewModel: MaterialViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        init()
        setListeners()
        setObservables()
        materialViewModel.loadData()
        return binding.root
    }

    fun init(){
        binding = FragmentThirdBinding.inflate(layoutInflater)

        binding.rvItems.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        materialDataAdapter = MaterialDataAdapter(listOf())
        binding.rvItems.adapter = materialDataAdapter
    }

    fun setListeners(){
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_third_to_second)
        }
        binding.btnBackToFirst.setOnClickListener {
            findNavController().navigate(R.id.action_third_to_first)
        }
    }

    fun setObservables(){
        materialViewModel.dataList.observe(viewLifecycleOwner){
            materialDataAdapter.setData(it)
        }
    }

}