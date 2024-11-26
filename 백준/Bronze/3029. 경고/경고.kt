fun main() {
    val br = System.`in`.bufferedReader()
    val currentTime = br.readLine().split(":").map { it.toInt() }
    val sodiumThrow = br.readLine().split(":").map { it.toInt() }
    val resultTime = mutableListOf<Int>()

    var h = sodiumThrow[0] - currentTime[0]
    var m = sodiumThrow[1] - currentTime[1]
    var s = sodiumThrow[2] - currentTime[2]

    if (s < 0) {
        s += 60
        m--
    }
    if (m < 0) {
        m += 60
        h--
    }
    if (h < 0) h += 24

    resultTime.add(h)
    resultTime.add(m)
    resultTime.add(s)

    if (resultTime.sum() == 0) resultTime[0] = 24

    println(resultTime.joinToString(":") { String.format("%02d", it) })
}
