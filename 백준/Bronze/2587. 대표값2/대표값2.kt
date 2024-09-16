fun main() {
    val su = IntArray(5) { readln().toInt() }

    su.sort()

    println(su.average().toInt())
    println(su[2])
}