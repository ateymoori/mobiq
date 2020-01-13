package com.mobiquity.di.modules

import android.util.Log
import com.mobiquity.di.base.RetrofitServiceGenerator
import com.mobiquity.di.repo.RestService
import com.mobiquity.utils.bases.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
open class ApplicationModule {

    @Singleton
    @Provides
    fun provideRetrofit(
        converter: GsonConverterFactory,
        httpClient: OkHttpClient.Builder,
        @Named("baseURL") baseURL: String
    ): Retrofit {
        val retrofitClass =
            RetrofitServiceGenerator(
                converter,
                httpClient,
                baseURL
            )
        return retrofitClass.getClient()
    }

    @Singleton
    @Provides
    fun provideOkHttp(interceptor: HttpLoggingInterceptor): OkHttpClient.Builder {
        val httpClient = OkHttpClient().newBuilder()
        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)
        httpClient.callTimeout(30, TimeUnit.SECONDS)
        httpClient.addInterceptor(interceptor)
        return httpClient
    }

    @Singleton
    @Provides
    fun provedHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d(Constants.OK_HTTP_LOG_KEY, message)
            }
        })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }


    @Singleton
    @Provides
    fun provideGSONConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    @Named("baseURL")
    fun provideBaseURL(): String {
        return Constants.BASE_URL
    }

    @Singleton
    @Provides
    @Named("imagesURLPrefix")
    fun getImagesURL(): String {
        return Constants.IMAGES_URL_PREFIX
    }

    @Singleton
    @Provides
    fun getMainInterface(retrofit: Retrofit): RestService {
        return retrofit.create(RestService::class.java)
    }


}