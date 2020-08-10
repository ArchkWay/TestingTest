package com.example.testingtest.common.di.components

import com.example.testingtest.main.MainActivity
import com.example.testingtest.common.di.modules.MvpModule
import com.example.testingtest.main.MainModel
import com.example.testingtest.main.MainPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MvpModule::class])
interface AppComponent {
    fun inject(view: MainActivity)
    fun inject(presenter: MainPresenter)
    fun inject(model: MainModel)
}