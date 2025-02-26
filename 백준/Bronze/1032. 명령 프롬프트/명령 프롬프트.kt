fun main() {
    val n = readln().toInt()
    val file = Array(n) { readln() }
    val sb = StringBuilder()

    for (i in file[0].indices) {
        val compare = file[0][i]
        var isCompare = true
        for (j in 0..<n) {
            if (compare != file[j][i]) isCompare = false
        }
        if (isCompare) sb.append(file[0][i])
        else sb.append("?")
    }

    print(sb)
}
