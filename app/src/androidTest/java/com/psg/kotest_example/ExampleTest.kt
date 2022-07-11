package com.psg.kotest_example

import androidx.test.core.app.launchActivity
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.android.synthetic.main.activity_main.*

// UI Test
class ExampleTest: FunSpec({

    test("test!") {
        val activity = launchActivity<MainActivity>()
        activity.onActivity {
            it.tv_main.text shouldBe "Hello World!"
        }

    }
})