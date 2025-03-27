class Solution {
    fun solution(num_list: IntArray): Int {
        var answer = -1
        
        for ((idx, v) in num_list.withIndex()) {
            if (v < 0) {
                answer = idx
                break
            }
        }
        
        return answer
    }
}