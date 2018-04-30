package pay.acount.com.main.model.network.api

import io.reactivex.Single
import pay.acount.com.main.model.CustomerTransactions
import retrofit2.Response
import retrofit2.http.*

interface TransactionApi {
    companion object {
        const val PARAM_ID = "transactionId"
    }

    @GET("/transactions")
    fun getTransactions(): Single<Response<MutableList<CustomerTransactions>>>

    @POST("/transactions")
    fun setTransaction(@Body transactions: CustomerTransactions): Single<Response<Void>>

    @DELETE("/transactions")
    fun deleteTransaction(@Query(PARAM_ID) id: String)

    @PUT("/transactions")
    fun editTransaction(@Query(PARAM_ID) id: String, @Body transactions: CustomerTransactions)

}