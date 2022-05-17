package com.psg.kotest_example

import io.kotest.core.spec.style.AnnotationSpec

class AnnotationTest: AnnotationSpec() {

    @BeforeEach
    fun beforeTest() {
        println("before each Test")
    }

    init {

    }
}