class Solution {
    fun solution(numbers: IntArray): String {
        var answer =  numbers.map { it.toString() }
            .sortedWith { a, b -> (b + a).compareTo(a + b) }
            .joinToString("")
        
        return if(answer[0] == '0') "0" else answer
    }
}