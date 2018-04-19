package pay.acount.com.main.model.network

import okhttp3.OkHttpClient

interface NetworkHelperContract{
    fun createHttpClient() :OkHttpClient
}