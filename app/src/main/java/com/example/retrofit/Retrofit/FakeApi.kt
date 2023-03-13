package com.example.retrofit.Retrofit

import com.example.retrofit.model.ProductsItem
import retrofit2.Response
import retrofit2.http.GET

interface FakeApi {
    @GET("products")
   suspend fun products(): Response<List<ProductsItem>>
}