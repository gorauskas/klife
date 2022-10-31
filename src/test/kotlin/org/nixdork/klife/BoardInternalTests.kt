package org.nixdork.klife

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class BoardInternalTests : AnnotationSpec() {
    @Test
    fun `live neighbors count should be 0`() {
        val grid = gridOf("...", "...", "...")
        grid.keys.map { cell ->
            grid.liveNeighborCount(cell) shouldBe 0
        }
    }

    @Test
    fun `live neighbors count may be 1 or 0`() {
        val grid = gridOf("...", ".#.", "...")
        grid.keys.map { cell ->
            if (cell.first == 1 && cell.second == 1) {
                grid.liveNeighborCount(cell) shouldBe 0
            } else {
                grid.liveNeighborCount(cell) shouldBe 1
            }
        }
    }
}
