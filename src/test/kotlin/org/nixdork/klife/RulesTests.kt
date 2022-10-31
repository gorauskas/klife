package org.nixdork.klife

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class RulesTests : AnnotationSpec() {
    @Test
    fun `a dead cell with 3 live neighbors comes to life`() {
        shouldBeAlive(false, 3).shouldBeTrue()
    }

    @Test
    fun `a dead cell with without 3 live neighbors stays dead`() {
        shouldBeAlive(false, 0).shouldBeFalse()
        shouldBeAlive(false, 1).shouldBeFalse()
        shouldBeAlive(false, 2).shouldBeFalse()
        shouldBeAlive(false, 4).shouldBeFalse()
        shouldBeAlive(false, 5).shouldBeFalse()
        shouldBeAlive(false, 6).shouldBeFalse()
        shouldBeAlive(false, 7).shouldBeFalse()
        shouldBeAlive(false, 8).shouldBeFalse()
    }

    @Test
    fun `a live cell with 0 or 1 live neighbors dies off`() {
        shouldBeAlive(true, 0).shouldBeFalse()
        shouldBeAlive(true, 1).shouldBeFalse()
    }

    @Test
    fun `a live cell with 4 or more live neighbors dies off`() {
        shouldBeAlive(true, 4).shouldBeFalse()
        shouldBeAlive(true, 5).shouldBeFalse()
        shouldBeAlive(true, 6).shouldBeFalse()
        shouldBeAlive(true, 7).shouldBeFalse()
        shouldBeAlive(true, 8).shouldBeFalse()
    }

    @Test
    fun `a live cell with 2 or 3 live neighbors lives on`() {
        shouldBeAlive(true, 2).shouldBeTrue()
        shouldBeAlive(true, 3).shouldBeTrue()
    }
}