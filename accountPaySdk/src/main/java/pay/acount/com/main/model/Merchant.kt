package pay.acount.com.main.model

/**
 * Created by Jonathan on 10/04/2018.
 */
data class Merchant(
        var merchantId: String,
        var accountId: String,
        var name: String,
        var address: String,
        var mobileNumber: String,
        var email: String,
        var status: String,
        var pushNotifications: Boolean,
        var mcc: String,
        var cashBackAmount: String
)