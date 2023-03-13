package com.example.retrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.Retrofit.FakeApi
import com.example.retrofit.model.ProductsItem
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakeApi: FakeApi) {
    private val _products = MutableLiveData<List<ProductsItem>>()
    val products: LiveData<List<ProductsItem>>
        get() = _products

    suspend fun getProducts() {
        val results = fakeApi.products()
        if (results.isSuccessful && results.body() != null) {
            _products.postValue(results.body())
        }
    }
}
