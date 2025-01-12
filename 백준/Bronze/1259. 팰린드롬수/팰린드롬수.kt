fun main() {
    while (true) {
        val num = readln()
        if (num == "0") break
        if (num.length == 1) {
            println("yes")
            continue
        }

        val half = num.length / 2
        val comparisonStr = num.substring(half, num.length).reversed()
        var equal = true

        repeat(half) {
            if (comparisonStr[it] != num[it]) {
                equal = false
            }
        }

        println(if (equal) "yes" else "no")
    }
}
