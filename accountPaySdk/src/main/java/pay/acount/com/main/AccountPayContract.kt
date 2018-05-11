package pay.acount.com.main

import android.graphics.Bitmap
import pay.acount.com.main.model.types.AccountPaySdkErrorType
import pay.acount.com.main.model.types.TransactionErrorType
import pay.acount.com.main.model.types.TransactionResultType

interface AccountPayContract {

    interface MerchantContract {
        fun startTransaction(type: String,
                             transactionAmount: Long,
                             onTransactionStarted: (transactionId: String, qrCode: Bitmap) -> Unit,
                             onTransactionError: (transactionId: String, error: TransactionErrorType) -> Unit,
                             onTransactionCompleted: (transactionId: String, result: TransactionResultType) -> Unit)

        fun cancelTransaction(transactionId: String)
        fun initialiseSdk(onSDKInitialised: () -> Unit, onSDKInitialiseError: (error: AccountPaySdkErrorType) -> Unit)
        fun updatePublicKey()
    }

    interface CustomerContract {
        fun readQRCode()
        fun initialiseSdk()
        fun updatePublicKey()
    }

}