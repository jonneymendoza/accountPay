package pay.acount.com.main.di

import dagger.Module
import dagger.Provides
import pay.acount.com.main.model.network.MerchantNetwork
import pay.acount.com.main.model.network.NetworkHelper
import pay.acount.com.main.model.network.TransactionNetwork
import pay.acount.com.main.model.network.contract.MerchantNetworkControllerContract
import pay.acount.com.main.model.network.contract.NetworkHelperContract
import pay.acount.com.main.model.network.contract.TransactionsNetworkControllerContract
import javax.inject.Singleton

@Module
class NetworkModule {
    @Module
    companion object {
        @Provides
        @Singleton
        fun providesNetworkHelper(networkHelper: NetworkHelper): NetworkHelperContract = networkHelper

        @Provides
        @Singleton
        fun providesMerchantNetwork(networkHelper: MerchantNetwork): MerchantNetworkControllerContract = networkHelper

        @Provides
        @Singleton
        fun providesTransactionNetwork(networkHelper: TransactionNetwork): TransactionsNetworkControllerContract = networkHelper
    }
}