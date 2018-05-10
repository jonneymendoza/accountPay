package pay.acount.com.main.model.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import pay.acount.com.main.model.CustomerTransactions
import pay.acount.com.main.model.network.api.TransactionApi
import pay.acount.com.main.model.network.contract.NetworkHelperContract
import pay.acount.com.main.model.network.contract.TransactionsNetworkControllerContract
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class TransactionNetwork @Inject constructor() : TransactionsNetworkControllerContract {

    @Inject
    lateinit var networkHelper: NetworkHelperContract

    private val url: String = "http://localhost:58237"

    private fun getMerchantApi(): TransactionApi {
        val gson = GsonBuilder().setLenient().create()
        val httpClient = networkHelper.createHttpClient()
        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(TransactionApi::class.java)
    }

    override fun getTransactions(): Single<Response<MutableList<CustomerTransactions>>> {
       return getMerchantApi().getTransactions()

    }

    override fun setTransaction(transactions: CustomerTransactions): Single<Response<Void>> {
        return getMerchantApi().setTransaction(transactions)
    }

    override fun deleteTransaction(id: String) {
       return getMerchantApi().deleteTransaction(id)
    }

    override fun editTransaction(id: String, transactions: CustomerTransactions) {
       return getMerchantApi().editTransaction(id, transactions)
    }

}