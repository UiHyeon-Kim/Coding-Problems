fun main() {
    val N = readln().toInt()
    val M = readln().split(" ").map { it.toInt() }
    val V = readln().toInt()
    var c = 0

    for (i in M) {
        if (i == V) c++
    }
    print(c)
}