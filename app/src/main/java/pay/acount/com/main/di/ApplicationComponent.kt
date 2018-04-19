package pay.acount.com.main.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import pay.acount.com.main.AccountPayApplication
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class,
        NetworkModule::class))
interface ApplicationComponent : AndroidInjector<DaggerApplication> {
    fun inject(application: AccountPayApplication)
    override fun inject(instance: DaggerApplication?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(applicaton: Application): Builder

        fun build(): ApplicationComponent
    }
}