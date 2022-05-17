package com.psg.kotest_example

import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe

internal class FreeTest: FreeSpec() {

    override fun beforeSpec(spec: Spec) {
        println("beforeSpec")
    }

    override fun beforeTest(testCase: TestCase) {
        println("beforeTest")
    }

    override fun beforeContainer(testCase: TestCase) {
        println("beforeContainer")
    }

    override fun beforeEach(testCase: TestCase) {
        println("beforeEach")
    }

    override fun beforeAny(testCase: TestCase) {
        println("beforeAny")
    }

    init {
        "FreeSpec Container" - {
            "FreeSpec Terminal1" { // 테스트 설명
                println("테스트1")
                "".length shouldBe 0
            }
            "FreeSpec Terminal2" {
                println("테스트2")
                "12345".length shouldBe 5 // shouldBe는 12345의 문자열 개수
            }
        }
    }
}

