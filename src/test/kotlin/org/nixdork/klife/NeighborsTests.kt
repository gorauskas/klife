package org.nixdork.klife

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class NeighborsTests : AnnotationSpec() {
    @Test
    fun `single cell has no neighbors`() {
        Cell(0, 0).neighbors(gridOf(1, 1)) shouldBe emptyList()
    }

    @Test
    fun `3 in a row`() {
        Cell(0, 0).neighbors(gridOf(3, 1)) shouldBe listOf(0 to 1)
        Cell(0, 1).neighbors(gridOf(3, 1)) shouldBe listOf(0 to 0, 0 to 2)
        Cell(0, 2).neighbors(gridOf(3, 1)) shouldBe listOf(0 to 1)
    }
}