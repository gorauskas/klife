package org.nixdork.klife

fun gridOf(width: Int, height: Int): Grid =
    (0 until height).flatMap { row ->
        (0 until width).map { col ->
            (row to col) to false
        }
    }.toMap()

fun gridOf(grid: String): Grid = gridOf(grid.lines())

fun gridOf(vararg grid: String): Grid = gridOf(grid.toList())

fun gridOf(grid: List<String>): Grid =
    (0 until grid.size).flatMap { row ->
        (0 until grid[0].length).map { col ->
            (row to col) to if (grid[row][col] == '#') true else false
        }
    }.toMap()
