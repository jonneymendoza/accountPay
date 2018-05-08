package pay.acount.com.main

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import pay.acount.com.main.di.DaggerApplicationComponent


class AccountPayApplication : DaggerApplication(){

    companion object {


    }
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val applicationComponent = DaggerApplicationComponent.builder()
                .application(this)
                .build()
        applicationComponent.inject(this)
        return applicationComponent

    }

}