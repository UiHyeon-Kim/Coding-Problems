class Solution {
    fun solution(X: String, Y: String): String {
        val x = (0..9).map { index -> X.count { it == index.digitToChar() } }
        val y = (0..9).map { index -> Y.count { it == index.digitToChar() } }
        var answer = mutableListOf<Int>()
        
        for (i in 9 downTo 0) {
            val count = minOf(x[i], y[i])
            repeat(count) {
                answer.add(i)       
            }
        }
        return when {
            answer.isEmpty() -> "-1"
            answer.sum() == 0 -> "0"
            else -> answer.joinToString("")
        }
    }
}