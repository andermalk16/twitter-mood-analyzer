package com.spider.twitteranalyzer.tests.shared

import androidx.test.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice

object DeviceTestUtils {
    fun wakeUp() {
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation()).apply {
            wakeUp()
            swipe(68, 848, 459, 236, 20)
        }
    }
}