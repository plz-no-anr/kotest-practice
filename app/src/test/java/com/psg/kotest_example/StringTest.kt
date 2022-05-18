package com.psg.kotest_example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * 가장 간단한 테스트 스타일 , Spec 들은 테스트를 설명하는  description만 다름
 */
class StringTest: StringSpec() {
    init { // 테스트 코드 작성
        "strings.length should return size of string" {  // 테스트 코드 설명
            "hello".length shouldBe 5   // 테스트할 코드
        }
    }
}