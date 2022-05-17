package com.psg.kotest_example

import io.kotest.assertions.asClue
import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.comparables.shouldBeGreaterThanOrEqualTo
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.*

class AssertionsTest : FreeSpec() {
    init {
        "Matchers" - {
            val testStr = "I am iron man"
            val testNum = 5
            val testList = listOf("iron", "bronze", "silver")

            "일치 하는지" {
                testStr shouldBe "I am iron man"
            }
            "일치 안 하는지" {
                testStr shouldNotBe "I am silver man"
            }
            "해당 문자열로 시작하는지" {
                testStr shouldStartWith "I am"
            }
            "해당 문자열을 포함하는지" {
                testStr shouldContain "iron"
            }
            "리스트에서 해당 리스트의 값들이 모두 포함되는지" {
                testList shouldContainAll listOf("iron", "silver")
            }
            "대소문자 무시하고 일치하는지" {
                testStr shouldBeEqualIgnoringCase "I AM IRON MAN"
            }
            "보다 큰거나 같은지" {
                testNum shouldBeGreaterThanOrEqualTo 3
            }
            "해당 문자열과 길이가 같은지" {
                testStr shouldHaveSameLengthAs "I AM SUPERMAN"
            }
            "문자열 길이" {
                testStr shouldHaveLength 13
            }
            "여러개 체이닝" {
                testStr.shouldStartWith("I").shouldHaveLength(13).shouldContainIgnoringCase("IRON")
            }
        }

        "Exception" - {
            "ArithmeticException Exception 발생하는지" {
                val exception = shouldThrow<ArithmeticException> {
                    1 / 0
                }
                exception.message shouldStartWith ("/ by zero")
            }
            "어떤 Exception이든 발생하는지" {
                val exception = shouldThrowAny {
                    1 / 0
                }
                exception.message shouldStartWith ("/ by zero")
            }
        }

        "Clues" - {
            data class HttpResponse(val status: Int, val body: String)

            val response = HttpResponse(404, "the content")

            "Not Use Clues" {
                response.status shouldBe 200
                response.body shouldBe "the content"
                // 결과: expected:<200> but was:<404>
            }
            "With Clues" {
                withClue("status는 200이여야 되고 body는 'the content'여야 한다") {
                    response.status shouldBe 200
                    response.body shouldBe "the content"
                }
                // 결과: status는 200이여야 되고 body는 'the content'여야 한다
            }
            "As Clues" {
                response.asClue {
                    it.status shouldBe 200
                    it.body shouldBe "the content"
                }
                // 결과: HttpResponse(status=404, body=the content)
            }
        }


        "Soft Assertions" - { // assert가 중간에 실패해도 끝까지 체크가 가능함
            val testStr = "I am iron man"
            val testNum = 5

            "Not Soft" {
                testStr shouldBe "IronMan"
                testNum shouldBe 1
                // 결과: expected:<"IronMan"> but was:<"I am iron man">
            }
            "Use Soft" {
                assertSoftly {
                    testStr shouldBe "IronMan"
                    testNum shouldBe 1
                }
                // 결과: expected:<"IronMan"> but was:<"I am iron man">
                //      expected:<1> but was:<5>
            }
        }

    }

}