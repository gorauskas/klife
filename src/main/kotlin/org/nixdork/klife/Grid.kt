package org.nixdork.klife

/**
 * A simple implementation of the Game of Life
 * using only a Map and a Pair for representation
 */
typealias Grid = Map<Cell, Boolean>

val Grid.width: Int get() = this.keys.maxOf { it.second + 1 }
val Grid.height: Int get() = this.keys.maxOf { it.first + 1 }

fun Grid.display(): String =
    keys.map { cell ->
        (if (isAliveAt(cell)) "#" else ".").let {
            if (cell.second >= width - 1) it + "\n" else it
        }
    }.joinToString("")
        .dropLast(1)

fun Grid.isAliveAt(cell: Cell): Boolean = this[cell] == true

fun Grid.liveNeighborCount(cell: Cell): Int = cell.neighbors(this).count { isAliveAt(it) }

fun Grid.next(): Grid =
    generation { cell ->
        shouldBeAlive(isAliveAt(cell), liveNeighborCount(cell))
    }

fun Grid.rangeConstraint(row: Int, col: Int) {
    check(row in 0 until this.height)
    check(col in 0 until this.width)
}

inline fun Grid.generation(fn: (cell: Cell) -> Boolean): Grid =
    keys.map { it to fn(it) }.toMap()
