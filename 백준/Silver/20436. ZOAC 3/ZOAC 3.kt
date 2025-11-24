import kotlin.math.abs

fun main() {
    var (left, right) = readln().split(" ").map { it.first() }
    val word = readln()
    val keyboard = mapOf(
        'q' to (0 to 0), 'w' to (0 to 1), 'e' to (0 to 2), 'r' to (0 to 3), 't' to (0 to 4), 'y' to (0 to 5), 'u' to (0 to 6), 'i' to (0 to 7), 'o' to (0 to 8), 'p' to (0 to 9),
        'a' to (1 to 0), 's' to (1 to 1), 'd' to (1 to 2), 'f' to (1 to 3), 'g' to (1 to 4), 'h' to (1 to 5), 'j' to (1 to 6), 'k' to (1 to 7), 'l' to (1 to 8),
        'z' to (2 to 0), 'x' to (2 to 1), 'c' to (2 to 2), 'v' to (2 to 3), 'b' to (2 to 4), 'n' to (2 to 5), 'm' to (2 to 6),
    )
    val rightKeyboard = setOf('y', 'u', 'i', 'o', 'p', 'h', 'j', 'k', 'l', 'b', 'n', 'm')
    var result = 0

    // 맨하튼 거리
    for (letter in word) {
        val letterIndex = keyboard[letter]!!
        val lHand = keyboard[left]!!
        val rHand = keyboard[right]!!

        val dist = if (letter in rightKeyboard) {
            right = letter
            abs(rHand.first - letterIndex.first) + abs(rHand.second - letterIndex.second)
        } else {
            left = letter
            abs(lHand.first - letterIndex.first) + abs(lHand.second - letterIndex.second)
        }

        result += dist

        // 클릭 시간
        result++
    }

    println(result)
}
