fun main() {
    val (cardCount, shuffleCount) = readln().split(" ").map { it.toInt() }
    var shuffled = readln().split(" ").map { it.toInt() }.toIntArray()
    val sequence = readln().split(" ").withIndex().associate { (idx, num) -> num.toInt() to idx }
    val temp = IntArray(cardCount)

    repeat(shuffleCount) {
        for (cnt in 1..cardCount) {
            val idx = sequence[cnt]!!

            temp[cnt - 1] = shuffled[idx]
        }
        shuffled = temp.clone()
    }

    println(temp.joinToString(" "))
}