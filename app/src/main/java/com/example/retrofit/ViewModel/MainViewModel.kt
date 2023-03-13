package com.example.retrofit.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.model.ProductsItem
import com.example.retrofit.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ProductRepository):ViewModel(){
    val productlivedata:LiveData<List<ProductsItem>>
    get() = repository.products
    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}