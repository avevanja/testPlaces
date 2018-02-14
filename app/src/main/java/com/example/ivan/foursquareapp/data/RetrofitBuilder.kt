package com.example.ivan.foursquareapp.data


import com.example.ivan.foursquareapp.Constants
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private var retrofit: Retrofit? = null
    private const val TIMEOUT = 30
    val foursquareApiWithRx = retrofitBuilder.create(FoursquareApi::class.java)!!


    private val retrofitBuilder: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(Constants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient)
                        .build()
            }
            return retrofit!!
        }

    private val httpClient: OkHttpClient
        get() {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS).build()
        }
}
