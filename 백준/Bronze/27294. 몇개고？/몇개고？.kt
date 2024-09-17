fun main() {
    val (t, s) = readln().split(" ").map { it.toInt() }

    if (s == 0 && t >= 12 && t <= 16) println(320)
    else println(280)
}