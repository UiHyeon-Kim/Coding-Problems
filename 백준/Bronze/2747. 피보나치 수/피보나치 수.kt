fun main() {
    val n = readln().toInt()
    val fibonacci = mutableListOf<Int>()

    fibonacci.add(0)
    fibonacci.add(1)

    for (i in 2..<n + 1) {
        fibonacci.add(fibonacci[i - 1] + fibonacci[i - 2])
    }

    println(fibonacci[n])
}
