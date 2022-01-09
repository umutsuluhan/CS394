package com.example.projectt.api

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterfaceRenovation {

    @GET("OGPC")
    fun getRenovations() : Call<JsonArray>

    companion object {

        var BASE_URL = "https://jsonkeeper.com/b/"

        fun create() : ApiInterfaceRenovation {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterfaceRenovation::class.java)
        }
    }

}