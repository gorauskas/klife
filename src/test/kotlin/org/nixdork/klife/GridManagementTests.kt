package org.nixdork.klife

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.shouldBe

class GridManagementTests : AnnotationSpec() {
    @Test
    fun `new grid has specified size`() {
        val grid = gridOf(width = 4, height = 3)
        grid.width shouldBe 4
        grid.height shouldBe 3
    }

    @Test
    fun `new grid is empty`() {
        val grid = gridOf(width = 4, height = 3)
        grid.keys.map { cell ->
            grid.isAliveAt(cell).shouldBeFalse()
        }
    }

    @Test
    fun `render grid`() {
        val grid = gridOf(width = 4, height = 3)
        grid.display() shouldBe
            """
                ....
                ....
                ....
            """.trimIndent()
    }

    @Test
    fun `parse grid`() {
        val gridAsString =
            """
                ...#
                ...#
                ....
            """.trimIndent()
        gridOf(gridAsString).display() shouldBe gridAsString
    }
}