class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var whole = (1..n).map { if(it !in section) 0 else it }
        var index = 0
        var answer = 0
        
        while (index < n) {
            if(whole[index] != 0) {
                index += m
                answer++
            } else {
                index++
            }
        }
        
        return answer
    }
}