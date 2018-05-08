package pay.acount.com.acountpaymerchant

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_launch.*

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        initlaiseView()
    }

    private fun initlaiseView() {

        accountPayButton.setOnClickListener {
            startActivity(Intent(this, MerchantMenuActivity::class.java))
        }
    }
}
