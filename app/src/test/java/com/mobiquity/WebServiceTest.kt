package com.mobiquity

import com.mobiquity.di.repo.RestService
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class WebServiceTest {

    private var mockWebServer = MockWebServer()

    private lateinit var apiService: RestService

    @Before
    fun setup() {
        mockWebServer.start()

        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(RestService::class.java)
    }

    @Test
    fun testGetProducts() = runBlocking<Unit> {

        this::class.java.getResource("/sample.json")?.readText()?.let {
            val response = MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(it)
            mockWebServer.enqueue(response)
            val product = apiService.getData()
            assertTrue(2 == product.size)
        }

    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }


}
