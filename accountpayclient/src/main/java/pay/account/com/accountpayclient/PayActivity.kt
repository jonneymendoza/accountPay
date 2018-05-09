package pay.account.com.accountpayclient


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import com.google.android.gms.samples.vision.barcodereader.BarcodeCaptureActivity
import com.google.android.gms.vision.barcode.Barcode
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_pay.*
import pay.account.com.accountpayclient.model.CustomerTransactions

class PayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)
        val barcode = intent.extras.getParcelable<Barcode>(BarcodeCaptureActivity.BarcodeObject)
        val transaction = Gson().fromJson<CustomerTransactions>(barcode.rawValue, CustomerTransactions::class.java)

        amount.text = "£ ${transaction.amount}"

        password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                payBtn.isEnabled = !editable.isNullOrBlank()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        payBtn.setOnClickListener{
            startActivity(Intent(this, SuccessActivity::class.java))
        }

    }

}
