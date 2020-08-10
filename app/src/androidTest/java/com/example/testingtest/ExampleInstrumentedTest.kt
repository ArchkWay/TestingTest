package com.example.testingtest

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.testingtest.domain.Constants
import com.example.testingtest.main.MainPresenter
import com.example.testingtest.main.MainActivity
import io.reactivex.Single

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mock
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Mock
    @Inject
    lateinit var mainPresenter: MainPresenter

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.testingtest", appContext.packageName)
    }

    var count = 0

    @Test
    fun loadTest() {
        while (count < 100){
            Single.just(activityRule.activity.presenter.attachPosts(
                activityRule.activity,
                Constants.MOSTPOPULAR,
                10,
                ""
            )).delay(1, TimeUnit.SECONDS).subscribe()
            count++
        }
    }

}