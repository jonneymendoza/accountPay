package pay.acount.com.main.model.network.utils

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Response

class NetworkConsumer<T>(val callback: NetworkCallBack<T>) {

    private var disposable: Disposable? = null

    fun subscribeToNetworkRequest(single: Single<Response<T>>) {
        disposable = single
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn { error: Throwable ->
                    createErrorResponse(error)
                }
                .subscribe({
                    if (it.isSuccessful && callback is VoidCallback) {
                        callback.onSuccess()
                    } else if (it.isSuccessful && it.body() != null) {
                        callback.onComplete(it.body()!!)
                    } else {
                        try {
//                            val error = Gson().fromJson(it.errorBody()!!.string(), PianoNetworkError::class.java)
                            callback.onError("some network error has occured")
                        } catch (ex: Exception) {
                            callback.onError(ex.toString())
                        }
                    }
                }, {
                    callback.onError(it.message!!)
                })
    }

    private fun createErrorResponse(error: Throwable): Response<T> {
        val response = ResponseBody.create(null, error.localizedMessage)
        return Response.error<T>(401, response)
    }
}