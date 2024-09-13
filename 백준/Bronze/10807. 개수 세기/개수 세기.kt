fun main() {
    val N = readln().toInt()
    val M = readln().split(" ")
    val V = readln().toInt()

    print(M.count() { it.toInt() == V })
}