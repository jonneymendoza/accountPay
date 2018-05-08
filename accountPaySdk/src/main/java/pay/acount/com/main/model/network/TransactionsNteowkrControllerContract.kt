package pay.acount.com.main.model.network

import io.reactivex.Single
import pay.acount.com.main.model.CustomerTransactions
import retrofit2.Response
import retrofit2.http.Body

interface TransactionsNteowkrControllerContract {

    fun getTransactions(): Single<Response<MutableList<CustomerTransactions>>>

    fun setTransaction(transactions: CustomerTransactions): Single<Response<Void>>

    fun deleteTransaction(id: String)

    fun editTransaction(id: String, @Body transactions: CustomerTransactions)
}