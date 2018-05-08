package pay.acount.com.main.model

/**
 * Created by Jonathan on 10/04/2018.
 */
data class Customer(
        var customerId: String,
        var accountNo: String,
        var name: String,
        var address: String,
        var mobileNumber: String,
        var email: String,
        var pushNotifications: Boolean,
        var campaignAlerts: Boolean,
        var GratuityOption: String,
        var roundPences: String
)