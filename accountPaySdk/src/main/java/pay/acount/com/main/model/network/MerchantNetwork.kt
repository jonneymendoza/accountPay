package pay.acount.com.main.model.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import okhttp3.ResponseBody
import pay.acount.com.main.model.Merchant
import pay.acount.com.main.model.network.api.MerchantApi
import pay.acount.com.main.model.network.contract.MerchantNetworkControllerContract
import pay.acount.com.main.model.network.contract.NetworkHelperContract
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MerchantNetwork @Inject constructor() : MerchantNetworkControllerContract {

    @Inject
    lateinit var networkHelper: NetworkHelperContract

    private val url: String = "http://localhost:58237"

    private fun getMerchantApi(): MerchantApi {
        val gson = GsonBuilder().setLenient().create()
        val httpClient = networkHelper.createHttpClient()
        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        return retrofit.create(MerchantApi::class.java)
    }

    override fun sendMerchant(merchant: Merchant): Single<Response<ResponseBody>> {
        return getMerchantApi().sendMerchant(merchant)
    }

    override fun deleteMerchant(id: String): Single<Response<ResponseBody>> {
        return getMerchantApi().deleteMerchant(id)
    }

    override fun getMerchant(id: String): Single<Response<Merchant>> {
        return getMerchantApi().getMerchant(id)
    }

}