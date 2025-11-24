fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val trains = IntArray(n)

    repeat(m) {
        val ints = readln().split(" ").map { it.toInt() }
        val (cmd, car) = ints[0] to ints[1] - 1

        when (cmd) {
            1 -> {
                val seat = ints[2] - 1
                trains[car] = trains[car] or (1 shl seat)
            }

            2 -> {
                val seat = ints[2] - 1
                trains[car] = trains[car] and (1 shl seat).inv()
            }

            3 -> {
                trains[car] = (trains[car] shl 1) and ((1 shl 20) - 1)
            }

            4 -> {
                trains[car] = trains[car] shr 1
            }
        }
    }

    println(trains.distinct().size)
}