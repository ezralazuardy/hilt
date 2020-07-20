package com.ezralazuardy.hilt.utils

import android.util.Log
import com.ezralazuardy.hilt.config.AppConfig
import com.ezralazuardy.hilt.config.AppConfig.IO_TIMEOUT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object Retrofit {

    @Provides
    @Singleton
    fun getClient(baseUrl: String = AppConfig.API_ENDPOINT): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(IO_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(IO_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(IO_TIMEOUT, TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    fun Throwable.printRetrofitError() {
        this.printStackTrace()
        when (this) {
            is IOException -> Log.e(
                this::class.java.simpleName,
                "Network Error happened in Retrofit | cause: ${this.cause} | message: ${this.message}"
            )
            is HttpException -> Log.e(
                this::class.java.simpleName,
                "HTTP Exception happened in Retrofit | cause: ${this.cause} | message: ${this.message}"
            )
            else -> Log.e(
                this::class.java.simpleName,
                "Unknown Error happened in Retrofit | cause: ${this.cause} | message: ${this.message}"
            )
        }
    }
}