package ru.vdv.myexchangerates.model.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientDR {
    var retrofit: Retrofit? = null
    fun getClient(baseUrl:String): Retrofit {
        if(retrofit == null){
            retrofit = Retrofit.Builder().baseUrl(baseUrl).client(
                OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                    .build()
            )
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit!!
    }
}