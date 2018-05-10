package pay.acount.com.main.model.network.api

import io.reactivex.Single
import okhttp3.ResponseBody
import pay.acount.com.main.model.Merchant
import retrofit2.Response
import retrofit2.http.*

interface MerchantApi {

    companion object {
       const val PARAM_ID = "id"
    }

    @POST("/merchants")
    fun sendMerchant(@Body merchant: Merchant): Single<Response<ResponseBody>>

    @DELETE("/merchants")
    fun deleteMerchant(@Query(PARAM_ID) id: String): Single<Response<ResponseBody>>

    @GET("/merchants")
    fun getMerchant(@Query(PARAM_ID) id: String): Single<Response<Merchant>>


}