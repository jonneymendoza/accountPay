package pay.acount.com.main.model.network

import io.reactivex.Single
import okhttp3.ResponseBody
import pay.acount.com.main.model.Merchant
import retrofit2.Response

interface MerchantNetworkControllerContract {

    fun sendMerchant(merchant: Merchant): Single<Response<ResponseBody>>
    fun deleteMerchant(id: String): Single<Response<ResponseBody>>
    fun getMerchant(id: String): Single<Response<Merchant>>
}