package com.psg.kotest_example

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FunSpecTest: FunSpec() {
    init {
        test("String length should return length of the string") { // 테스트 코드 설명 - description
            "sanggun".length shouldBe 7
            "".length shouldBe 5
        }
    }
}