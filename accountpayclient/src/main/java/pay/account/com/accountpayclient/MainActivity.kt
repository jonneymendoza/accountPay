package pay.account.com.accountpayclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.gms.samples.vision.barcodereader.BarcodeCaptureActivity
import android.content.Intent
import com.google.android.gms.common.api.CommonStatusCodes


class MainActivity : AppCompatActivity() {

    private val RC_BARCODE_CAPTURE = 9001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scanBtn.setOnClickListener {
            //todo open camera
            val intent = Intent(this, BarcodeCaptureActivity::class.java)
            intent.putExtra(BarcodeCaptureActivity.AutoFocus, true)
            intent.putExtra(BarcodeCaptureActivity.UseFlash, false)
            startActivityForResult(intent, RC_BARCODE_CAPTURE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RC_BARCODE_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    val intent = Intent(this, PayActivity::class.java)
                    intent.putExtras(data)
                    startActivity(intent)
                }
            }
        }
    }
}
