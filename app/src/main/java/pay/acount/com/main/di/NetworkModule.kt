package pay.acount.com.main.di

import dagger.Module
import dagger.Provides
import pay.acount.com.main.model.network.NetworkHelper
import pay.acount.com.main.model.network.NetworkHelperContract
import javax.inject.Singleton

@Module
class NetworkModule {

    @Module
    companion object {
        @Provides
        @Singleton
        fun providesNetworkhelper(networkHelper: NetworkHelper): NetworkHelperContract = networkHelper
    }
}