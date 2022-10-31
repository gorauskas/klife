//import org.junit.jupiter.api.Test
//import kotlin.test.assertEquals
//import kotlin.test.assertTrue
//
//typealias Cell = Pair<Int, Int>
//typealias Board = Set<Cell>
//fun boardOf(vararg liveCells: Cell) = setOf(*liveCells)
//
//fun Board.step(): Board =
//    filter { cell ->
//        shouldBeAlive(isAliveNow = true, liveNeighbors(cell).count())
//    }.toSet() + flatMap { cell ->
//        deadNeighbors(cell).filter { deadCell ->
//            shouldBeAlive(isAliveNow = false, liveNeighbors(deadCell).count())
//        }
//    }
//
//private fun shouldBeAlive(isAliveNow: Boolean, neighbourCount: Int) =
//    (isAliveNow && neighbourCount in 2..3) || (!isAliveNow && neighbourCount == 3)
//
//private fun Board.countNeighbors(cell: Cell): Int = liveNeighbors(cell).count()
//
//private fun Board.liveNeighbors(cell: Cell): List<Cell> = cell.neighbors().filter { it in this }
//
//private fun Board.deadNeighbors(cell: Cell): List<Cell> = cell.neighbors().filter { it !in this }
//
//private fun Cell.neighbors(): List<Cell> {
//    val rw = this.first
//    val cl = this.second
//    return listOf(
//        rw - 1 to cl - 1, rw - 1 to cl, rw - 1 to cl + 1,
//        rw to cl - 1, /*             */ rw to cl + 1,
//        rw + 1 to cl - 1, rw + 1 to cl, rw + 1 to cl + 1,
//    )
//}
//
//class LifeTest {
//    @Test
//    fun `count neighbors of a cell`() {
//        val board = boardOf(0 to 0, 0 to 1, 0 to 2)
//        val result = board.map { board.countNeighbors(it) }
//        assertEquals(listOf(1, 2, 1), result)
//    }
//
//    @Test
//    fun `cell with 1 neighbor dies`() {
//        val board = boardOf(0 to 0, 0 to 1, 0 to 2)
//        assertTrue(0 to 0 !in board.step())
//        assertTrue(0 to 2 !in board.step())
//    }
//
//    @Test
//    fun `cell with 2 neighbors lives`() {
//        val board = boardOf(0 to 0, 0 to 1, 0 to 2)
//        assertTrue(0 to 1 in board.step())
//    }
//
//    @Test
//    fun `cell with 3 neighbors lives`() {
//        val board = boardOf(0 to 0, 0 to 1, 1 to 1, 0 to 2)
//        assertTrue(0 to 1 in board.step())
//    }
//
//    @Test
//    fun `cell with 4 neighbors dies`() {
//        val board = boardOf(0 to 0, 0 to 1, -1 to 1, 1 to 1, 0 to 2)
//        assertTrue(0 to 1 !in board.step())
//    }
//
//    @Test
//    fun `dead cell with 3 neighbors comes to life`() {
//        val board = boardOf(0 to 0, 0 to 1, 0 to 2)
//        assertTrue(1 to 1 in board.step())
//    }
//}
