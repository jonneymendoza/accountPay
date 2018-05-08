package pay.acount.com.acountpaymerchant

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_menu_layout.*

class MerchantMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu_layout)

        initlaiseView()
    }

    private fun initlaiseView() {

        startTransactionButton.setOnClickListener {
            startActivity(Intent(this, NewTransactionActivity::class.java))
        }

    }
}