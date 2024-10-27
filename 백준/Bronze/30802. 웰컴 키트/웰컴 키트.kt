fun main() {
    val person = readln().toInt()
    val tshirt = readln().split(" ").map { it.toInt() }
    val (T, P) = readln().split(" ").map { it.toInt() }
    var cnt = 0

    tshirt.forEach { if (it % T >= 1) cnt += it / T + 1 else cnt += it / T }

    println(cnt)
    println("${person / P} ${person % P}")
}