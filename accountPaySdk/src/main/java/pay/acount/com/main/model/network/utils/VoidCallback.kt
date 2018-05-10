package pay.acount.com.main.model.network.utils

interface VoidCallback : NetworkCallBack<Void> {

    override fun onComplete(response: Void) {
    }

    fun onSuccess()
}