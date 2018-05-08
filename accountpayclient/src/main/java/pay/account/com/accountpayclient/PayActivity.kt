package pay.account.com.accountpayclient


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.samples.vision.barcodereader.BarcodeCaptureActivity
import com.google.android.gms.vision.barcode.Barcode
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_pay.*
import pay.acount.com.main.model.CustomerTransactions

class PayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)
        val barcode = intent.extras.getParcelable<Barcode>(BarcodeCaptureActivity.BarcodeObject)
        val transaction = Gson().fromJson<CustomerTransactions>(barcode.rawValue, CustomerTransactions::class.java)

        amount.text = "£ ${transaction.amount}"


    }

}
