package com.mobiquity

import com.mobiquity.di.repo.MainRepo
import com.mobiquity.di.repo.RestService
import com.mobiquity.ui.products_list.ProductsListViewModel
import com.mobiquity.utils.bases.mock
import com.mobiquity.utils.entities.CommonResponse
import com.mobiquity.utils.entities.Loading
import io.reactivex.Observer
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class ViewModelTest {


//    private lateinit var viewModel: ProductsListViewModel
//
//    private val observer: Observer<CommonResponse<Any?>> = mock()
//
//
//    private var mockWebServer = MockWebServer()
//
//    private lateinit var apiService: RestService
//
//    @Before
//    fun setup() {
//        mockWebServer.start()
//
//        apiService = Retrofit.Builder()
//            .baseUrl(mockWebServer.url("/"))
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(OkHttpClient.Builder().build())
//            .build()
//            .create(RestService::class.java)
//
//        viewModel = ProductsListViewModel(MainRepo(apiService))
//
//        viewModel.getProducts()
//    }
//
//    @Test
//    fun testGetProducts() = runBlocking<Unit> {
//        val result = viewModel.result
//
//
//        val captor = ArgumentCaptor.forClass(CommonResponse::class.java)
//        captor.run {
//            verify(observer, times(1)).onNext(capture())
//            assertTrue(1 == 1)
//        }
//        //       }
//
//    }
//
//    @After
//    fun teardown() {
//        //mockWebServer.shutdown()
//    }


}
