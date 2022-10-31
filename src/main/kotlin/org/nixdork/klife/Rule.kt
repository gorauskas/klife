package org.nixdork.klife

typealias RulePredicate = (state: Boolean, count: Int) -> Boolean

/**
 * Classic Life Rules - https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#Rules
 *
 * 1. Any live cell with two or three live neighbours survives.
 * 2, Any dead cell with three live neighbors becomes a live cell.
 * 3. All other live cells die in the next generation.
 * 4. All other dead cells stay dead.
 */
@Suppress("MagicNumber")
val shouldBeAlive: RulePredicate = { isAlive, liveNeighbors ->
    when (isAlive) {
        true -> liveNeighbors in listOf(2, 3)
        false -> liveNeighbors == 3
    }
}
