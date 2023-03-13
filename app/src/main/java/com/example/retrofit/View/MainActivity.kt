package com.example.retrofit.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.Adapter.ProductAdapter
import com.example.retrofit.ViewModel.MainViewModel
import com.example.retrofit.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var ProductAdapter:ProductAdapter
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        ProductAdapter= ProductAdapter(this)
        binding.recyclerView.adapter=ProductAdapter
//     create viewModel object
        mainViewModel= ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.productlivedata.observe(this, Observer {
            it.let {
                if(it.isNotEmpty())
                {
                    ProductAdapter.submitList(it)
                }
            }
        })
    }
}