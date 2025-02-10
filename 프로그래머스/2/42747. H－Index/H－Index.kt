class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        val c = citations.sortedDescending()
        
        for(i in c.indices) {
            if(i >= c[i]) return i else answer++
        }
        
        return answer
    }
}