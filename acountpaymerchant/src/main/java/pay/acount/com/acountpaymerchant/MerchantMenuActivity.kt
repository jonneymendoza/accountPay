package pay.acount.com.acountpaymerchant

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import dagger.android.support.DaggerAppCompatActivity

class MerchantMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.main_menu_layout)

        initlaiseView()
    }

    private fun initlaiseView() {


    }
}