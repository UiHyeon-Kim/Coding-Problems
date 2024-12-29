fun main() {
    val a = readln().toInt()
    val t = readln().toInt()
    val pupa = readln().toInt()

    println(drinkingGame(a, t, pupa))
}

fun drinkingGame(personnel: Int, nth: Int, target: Int): Int {
    var pu = 0
    var pa = 0
    var n = 2
    while (true) {
        repeat(2) {
            pu++
            if (target == 0 && pu == nth) return (pu + pa - 1) % (personnel)
            pa++
            if (target == 1 && pu == nth) return (pu + pa - 1) % personnel
        }

        repeat(n) {
            pu++
            if (target == 0 && pu == nth) return (pu + pa - 1) % personnel
        }
        repeat(n) {
            pa++
            if (target == 1 && pa == nth) return (pu + pa - 1) % personnel
        }
        n++
    }
}
