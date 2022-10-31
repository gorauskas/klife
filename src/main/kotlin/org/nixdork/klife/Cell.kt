package org.nixdork.klife

typealias Cell = Pair<Int, Int>

@Suppress("UNCHECKED_CAST")
fun Cell.neighbors(grid: Grid): List<Cell> =
    let { (row, col) ->
        grid.rangeConstraint(row, col)
        val up = if (row == 0) null else row - 1
        val down = if (row == grid.height - 1) null else row + 1
        val left = if (col == 0) null else col - 1
        val right = if (col == grid.width - 1) null else col + 1
        val cells = listOf(
            up to left,   up to col,    up to right,
            row to left,  null to null, row to right,
            down to left, down to col,  down to right,
        ).filter { (x, y) -> x != null && y != null } as List<Cell>
        cells
    }
