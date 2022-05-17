package com.psg.kotest_example

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.comparables.shouldBeGreaterThanOrEqualTo
import io.kotest.matchers.shouldBe

/**
 * 다른 매개변수를 정의하여 각각 테스트가 가능
 */
class DataDrivenTest: FreeSpec() {

    init {
        "data test" - {
            "forAll" {
                forAll(
                    row("haha", 13),
                    row("hoho", 22),
                ) { name, age ->
                    name.length shouldBe 4
                    age shouldBeGreaterThanOrEqualTo 10
                }
            }
            "table forAll" {
                table(
                    headers("name", "age"),
                    row("haha", 13),
                    row("hoho", 22)
                ).forAll { name, age ->
                    name.length shouldBe 4
                    age shouldBeGreaterThanOrEqualTo 10
                }
            }
            "collection" {
                listOf(
                    row("haha", 13),
                    row("hoho", 22)
                ).map { (name: String, age: Int) ->
                    name.length shouldBe 4
                    age shouldBeGreaterThanOrEqualTo 10
                }
            }
        }
    }

}