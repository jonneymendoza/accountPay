package pay.acount.com.acountpaymerchant

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.new_transaction_layout.*
import pay.acount.com.acountpaymerchant.QrCodeTransactionActivity.Companion.DATA_TRANSACTION
import pay.acount.com.main.model.CustomerTransactions
import java.util.*

class NewTransactionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.new_transaction_layout)
        initialiseView()
    }

    private fun initialiseView() {
        proceedButton.setOnClickListener {
            //generate QR code
            var intent = Intent(this, QrCodeTransactionActivity::class.java)
            intent.putExtra(DATA_TRANSACTION, createTransactionData())
            startActivity(intent)
        }
    }

    //todo: shoudl be in a presenter
    private fun createTransactionData(): String? {
        var transaction = CustomerTransactions(UUID.randomUUID().toString(),
                "Payment",
                amountText.text.toString(),
                "currencyCode",
                "Cashback",
                "gratuityAmount",
                "confirmDateTime",
                1234,
                "merchantName",
                "merchantcc",
                "status",
                "lastUpdatedDateTime",
                "savedPences")
        return Gson().toJson(transaction)
    }
}