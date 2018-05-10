package pay.acount.com.main.model.network.contract

import okhttp3.OkHttpClient

interface NetworkHelperContract{
    fun createHttpClient() :OkHttpClient
}