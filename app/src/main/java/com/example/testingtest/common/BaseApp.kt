package com.example.testingtest.common

import android.app.Application
import android.content.Context

import com.example.testingtest.common.di.components.AppComponent
import com.example.testingtest.common.di.components.DaggerAppComponent
import com.example.testingtest.common.di.modules.MvpModule


class BaseApp : Application() {
    /*baseDI*/
    private var appComponent: AppComponent? = null

    val injector: AppComponent?
        get() {
            if (appComponent == null) {
                appComponent = DaggerAppComponent
                    .builder()
                    .mvpModule(MvpModule(this))
                    .build()
            }
            return appComponent
        }

    companion object {
        operator fun get(ctx: Context): BaseApp {
            return ctx.applicationContext as BaseApp
        }
    }
}
