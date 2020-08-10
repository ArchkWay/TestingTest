package com.example.testingtest.data.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitProvider {
    private val retrofit: Retrofit
    val api: Api
        get() = retrofit.create(Api::class.java)

    companion object {
        private const val BASE_URL = "http://stage.apianon.ru:3000"
        private const val CONNECT_TIMEOUT: Long = 60
        private const val READ_TIMEOUT: Long = 60
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client( buildOkHttpClient() )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun buildOkHttpClient(): OkHttpClient? {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(
            CONNECT_TIMEOUT,
            TimeUnit.SECONDS
        )
            .readTimeout(
                READ_TIMEOUT,
                TimeUnit.SECONDS
            )
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            builder.addInterceptor(interceptor)
        return builder.build()
    }
}