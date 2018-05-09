package pay.account.com.accountpayclient.model

/**
 * Created by Jonathan on 10/04/2018.
 */
data class CustomerTransactions(
        var transactionId: String,
        var transactionType: String,
        var amount: String,
        var currencyCode: String,
        var cashbackAmount: String,
        var gratuityAmount: String,
        var confirmDateTime: String,
        var responseCode: Int,
        var merchantName: String,
        var merhcantMcc: String,
        var status: String,
        var lastUpdateDateTime: String,
        var savedPences: String
)