fun main() {
    val s1 = readln()
    val s2 = readln()
    val lcsChart = Array(s1.length + 1) { IntArray(s2.length + 1) }

    for (i in 1..s1.length) {
        for (j in 1..s2.length) {
            if (s1[i - 1] == s2[j - 1]) {
                lcsChart[i][j] = lcsChart[i - 1][j - 1] + 1
            } else {
                lcsChart[i][j] = maxOf(lcsChart[i - 1][j], lcsChart[i][j-1])
            }
        }
    }
    println(lcsChart[s1.length][s2.length])
}