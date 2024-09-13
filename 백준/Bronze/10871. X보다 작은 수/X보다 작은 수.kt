fun main() {
    val (N, X) = readln().split(" ").map { it.toInt() }
    val A = readln().split(" ").map { it.toInt() }

    for (i in A) {
        if (i < X) print("$i ")
    }
}