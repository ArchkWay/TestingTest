package com.example.testingtest.common.di.modules

import android.content.Context
import com.example.testingtest.data.net.RetrofitProvider
import com.example.testingtest.main.MainContract
import com.example.testingtest.main.MainModel
import com.example.testingtest.main.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MvpModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext(): Context = context

    @Provides
    @Singleton
    fun provideRetrofit(): RetrofitProvider = RetrofitProvider()

    @Provides
    @Singleton
    fun provideMainContractPresenter (context:Context): MainContract.Presenter = MainPresenter(context)


    @Provides
    @Singleton
    fun provideMainContractModel (context:Context): MainContract.Model = MainModel(context)


}

