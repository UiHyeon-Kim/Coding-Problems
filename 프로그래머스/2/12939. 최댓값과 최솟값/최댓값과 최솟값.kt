class Solution {
    fun solution(s: String): String {
        var answer = ""

        var result = s.split(" ").map { it.toInt() }

        answer = "${result.minOrNull()} ${result.maxOrNull()}"

        return answer
    }
}