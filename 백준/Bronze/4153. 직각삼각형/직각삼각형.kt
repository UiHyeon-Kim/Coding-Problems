import kotlin.math.hypot

fun main() {
    while (true) {
        val side = readln().split(" ").map { it.toDouble() }.sorted()

        if (side.sum() == 0.0) return

        if (side[2] == hypot(side[0], side[1])) println("right") else println("wrong")
    }
}