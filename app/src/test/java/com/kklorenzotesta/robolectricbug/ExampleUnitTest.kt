package com.kklorenzotesta.robolectricbug

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.LooperMode

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleUnitTest {
    @Test
    @LooperMode(LooperMode.Mode.PAUSED)
    fun swipeToReorder() {
        launchActivity<MainActivity>()
        println("RUNNING")
        onView(withId(R.id.recycler))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<MainViewHolder>(5,
                    GeneralSwipeAction(
                        Swipe.FAST,
                        GeneralLocation.CENTER,
                        CoordinatesProvider { floatArrayOf(0F, 0F) },
                        Press.FINGER
                    )))
    }
}
