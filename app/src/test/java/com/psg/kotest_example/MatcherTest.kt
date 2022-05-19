package com.psg.kotest_example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.sorted
import io.kotest.matchers.maps.contain
import io.kotest.matchers.maps.haveKey
import io.kotest.matchers.maps.haveValue
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.*

class MatcherTest : StringSpec() {
    init {
        // 'shouldBe' 동일함을 체크하는 Matcher 입니다.
        "hello world" shouldBe haveLength(11) // length가 11이어야 함을 체크 합니다.
        "hello" should include("ll") // 파라미터가 포함되어 있는지 체크 합니다.
        "hello" should endWith("lo") // 파라미터가 끝의 포함되는지 체크 합니다.
        "hello" should match("he...") // 파라미터가 매칭되는지 체크 합니다.
        "hello".shouldBeLowerCase() // 소문자로 작성되었는지 체크 합니다.

        val list = emptyList<String>()
        val list2 = listOf("aaa", "bbb", "ccc")
        val map = mapOf<String, String>(Pair("aa", "11"))

        list should beEmpty() // 원소가 비었는지 체크 합니다.
        list2 shouldBe sorted<String>() // 해당 자료형이 정렬 되었는지 체크 합니다.
        map should contain("aa", "11") // 해당 원소가 포함되었는지 체크 합니다.
        map should haveKey("aa") // 해당 key가 포함되었는지 체크 합니다.
        map should haveValue("11") // 해당 value가 포함되었는지 체크 합니다.
    }



}