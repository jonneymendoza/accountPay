package pay.acount.com.main.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.google.gson.Gson
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.journeyapps.barcodescanner.BarcodeEncoder
import pay.acount.com.main.model.CustomerTransactions

/**
 * Created by Jonathan on 09/04/2018.
 *
 * Create a QR code based on customer transaction details
 *
 */
class TransactionQR : ImageView {

    private lateinit var customerTransaction: CustomerTransactions


    constructor(context: Context, attrs: AttributeSet) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

    }


    fun generateTransactioQrCode(customerTransactions: CustomerTransactions) {
        this.customerTransaction = customerTransaction
        var qrText = Gson().toJson(customerTransaction)

        val multiFormatWriter = MultiFormatWriter()

        var bitmatrix = multiFormatWriter.encode(qrText, BarcodeFormat.QR_CODE, measuredWidth, measuredHeight)
        var barcodeEncoer = BarcodeEncoder()
        setImageBitmap(barcodeEncoer.createBitmap(bitmatrix))

    }


}