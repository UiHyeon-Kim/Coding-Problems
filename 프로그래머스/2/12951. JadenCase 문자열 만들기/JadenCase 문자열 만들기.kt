class Solution {
    fun solution(s: String): String {
        var answer = ""
        answer = s.lowercase().split(" ").joinToString(" ") { it.replaceFirstChar { it.uppercase() } }
        return answer
    }
}