package org.nixdork.klife

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class GenerationsTests : AnnotationSpec() {
    @Test
    fun `next generation is empty`() {
        val grid = gridOf(3, 3)
        grid.next() shouldBe grid
    }

    @Test
    fun `next generation dies off`() {
        val grid = gridOf("...", ".#.", "...")
        grid.next() shouldBe gridOf(3, 3)
    }

    @Test
    fun `next 5 generations of glider`() {
        val grid1 = gridOf("..#.....", "...#....", ".###....", "........", "........", "........")
        val grid2 = gridOf("........", ".#.#....", "..##....", "..#.....", "........", "........")
        val grid3 = gridOf("........", "...#....", ".#.#....", "..##....", "........", "........")
        val grid4 = gridOf("........", "..#.....", "...##...", "..##....", "........", "........")
        val grid5 = gridOf("........", "...#....", "....#...", "..###...", "........", "........")

        grid1.next() shouldBe grid2
        grid2.next() shouldBe grid3
        grid3.next() shouldBe grid4
        grid4.next() shouldBe grid5
    }
}