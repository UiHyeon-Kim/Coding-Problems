fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val aDigits = a.toString().toCharArray().sortedDescending() // A의 숫자들을 내림차순 정렬
    val bStr = b.toString()
    val used = BooleanArray(aDigits.size) // 사용 여부 체크
    var result = -1

    fun backtrack(current: String) {
        if (current.length == aDigits.size) {
            val num = current.toInt()
            if (num < b) result = maxOf(result, num)
            return
        }
        for (i in aDigits.indices) {
            if (used[i] || (current.isEmpty() && aDigits[i] == '0')) continue
            used[i] = true
            backtrack(current + aDigits[i])
            used[i] = false
        }
    }

    backtrack("")
    println(result)
}
