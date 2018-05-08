package pay.acount.com.main.model.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pay.acount.com.main.BuildConfig
import javax.inject.Inject

class NetworkHelper @Inject constructor() : NetworkHelperContract {
    override fun createHttpClient(): OkHttpClient {

        val okHttpClient: OkHttpClient

        val builder = OkHttpClient.Builder()

        builder.addInterceptor { chain ->
            val originalRequest = chain.request()

            val requestBuilder = originalRequest.newBuilder()

            val newRequest = requestBuilder.build()
            val response = chain.proceed(newRequest)
            //get any new cookie from a response due to refresh token
            //TODO:Can this be unit tested?

            response
        }

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }

        okHttpClient = builder.build()
        return okHttpClient

    }

}