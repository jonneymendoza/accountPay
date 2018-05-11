package pay.acount.com.main.model.network.contract

import io.reactivex.Single
import pay.acount.com.main.model.CustomerTransactions
import retrofit2.Response
import retrofit2.http.Body

interface TransactionsNetworkControllerContract {

    fun getTransactions(): Single<Response<MutableList<CustomerTransactions>>>

    fun setTransaction(transactions: CustomerTransactions): Single<Response<Void>>

    fun deleteTransaction(id: String): Single<Response<Void>>

    fun editTransaction(id: String, @Body transactions: CustomerTransactions): Single<Response<Void>>
}