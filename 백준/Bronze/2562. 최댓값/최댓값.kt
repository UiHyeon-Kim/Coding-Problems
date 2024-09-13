fun main() = with(System.`in`.bufferedReader()) {
    var M = 0
    var C = 0
    repeat(9) {
        var N = readln().toInt()

        if (M < N) {
            M = N
            C = it + 1
        }
    }
    println(M)
    println(C)
}