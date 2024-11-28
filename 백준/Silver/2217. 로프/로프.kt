fun main() {
    val lopes = mutableListOf<Int>()
    var weight = 0
    var max = 0

    repeat(readln().toInt()) {
        lopes.add(readln().toInt())
    }

    lopes.sortDescending()
    for (i in lopes.indices) {
        weight = (i + 1) * lopes[i]
        if (max <= weight) max = weight
    }

    println(max)
}
