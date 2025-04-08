class Solution {
    fun solution(my_string: String, queries: Array<IntArray>): String {
        var answer = StringBuilder(my_string)
        
        for((start, end) in queries) {
            val reverse = answer.substring(start, end + 1).reversed()
            answer.replace(start, end + 1, reverse)
        }
        
        return answer.toString()
    }
}