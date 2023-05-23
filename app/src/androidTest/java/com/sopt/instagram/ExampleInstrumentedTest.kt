package com.sopt.instagram

<<<<<<< HEAD
import androidx.test.platform.app.InstrumentationRegistry // ktlint-disable import-ordering
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.* // ktlint-disable no-wildcard-imports
=======
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.* // ktlint-disable no-wildcard-imports
import org.junit.Test
import org.junit.runner.RunWith
>>>>>>> f68f2c0ecf1ebbc396733e32ba4c7d3be90f3ca2

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.sopt.instagram", appContext.packageName)
    }
}
