package pay.acount.com.main.model.network.utils

interface NetworkCallBack<T> {
    fun onComplete(response: T)
    fun onError(error: String)
}