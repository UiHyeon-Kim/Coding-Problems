fun main() {
    val n = readln().toInt()
    val cow = mutableMapOf<Int, Int>()
    var count = 0

    repeat(n) {
        val (a, b) = readln().split(" ").map { it.toInt() }

        if (cow.containsKey(a)) {
            if (cow[a] != b) {
                cow[a] = b
                count++
            }
        } else {
            cow[a] = b
        }
    }
    println(count)
}
