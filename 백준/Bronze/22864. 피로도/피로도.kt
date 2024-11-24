fun main() {
    val (a, b, c, m) = readln().split(" ").map { it.toInt() }
    var workload = 0
    var fatigueLevel = 0

    repeat(24) {
        if (fatigueLevel + a <= m) {
            fatigueLevel += a
            workload += b
        } else {
            fatigueLevel -= c
            if (fatigueLevel < 0) fatigueLevel = 0
        }
    }

    println(workload)
}
