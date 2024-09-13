fun main() {
    val N = readln().toInt()
    val M = readln().split(" ").map { it.toInt() }
    var max = M[0]
    var min = M[0]

    for (i in M) {
        when {
            max < i -> max = i
            min > i -> min = i
        }
    }
    print("$min $max")
}