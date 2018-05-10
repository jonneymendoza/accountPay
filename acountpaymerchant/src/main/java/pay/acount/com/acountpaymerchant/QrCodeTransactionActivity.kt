package pay.acount.com.acountpaymerchant

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.android.synthetic.main.qr_code_transaction_layout.*

class QrCodeTransactionActivity : AppCompatActivity() {


    companion object {
        const val DATA_TRANSACTION = "TRASACION STRING"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.qr_code_transaction_layout)
        if (intent != null) {
            var transaction = intent.getStringExtra(DATA_TRANSACTION)
            var qrcodeWriter = QRCodeWriter()
            var bitmarix = qrcodeWriter.encode(transaction, BarcodeFormat.QR_CODE, 300, 300)
            var width = bitmarix.width
            var height = bitmarix.height
            var bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
            for (x in 0 until width) {
                for (y in 0 until height) {
                    bmp.setPixel(x, y, if (bitmarix.get(x, y)) Color.BLACK else Color.WHITE)
                }
            }
            transactionCode.setImageBitmap(bmp)
        }
    }
}