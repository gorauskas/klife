import org.nixdork.klife.display
import org.nixdork.klife.gridOf
import org.nixdork.klife.next
import java.util.concurrent.TimeUnit
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
fun main() {
    lateinit var buffer: List<String>
    println("Life! building buffer...")
    val elapsed1: Duration = measureTime {
        var grid = gridOf(Patterns.GLIDER_PATTERN)
        buffer = (0..220).map {
            grid = grid.next()
            "\nGeneration $it:\n${grid.display()}"
        }
    }
    println("\n buffered! $elapsed1")

    val elapsed2: Duration = measureTime {
        for (frame in buffer) {
            println(frame)
            TimeUnit.MILLISECONDS.sleep(36)
        }
    }
    println("\n BUFFERING! $elapsed1")
    println("\n DONE! $elapsed2")
}

object Patterns {
    val PULSAR_PATTERN =
        """
            .......................
            .......................
            .......................
            .......###...###.......
            .......................
            .....#....#.#....#.....
            .....#....#.#....#.....
            .....#....#.#....#.....
            .......###...###.......
            .......................
            .......###...###.......
            .....#....#.#....#.....
            .....#....#.#....#.....
            .....#....#.#....#.....
            .......................
            .......###...###.......
            .......................
            .......................
            .......................
        """.trimIndent()

    val GLIDER_PATTERN =
        """
            .............................................................
            .....#.......................................................
            ......#......................................................
            ....###......................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
            .............................................................
        """.trimIndent()
}
