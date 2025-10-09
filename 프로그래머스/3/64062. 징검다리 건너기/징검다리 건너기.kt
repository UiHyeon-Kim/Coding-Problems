class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var left = 0
        var right = stones.maxOrNull()!!
        var answer = 0
        
        while(left <= right) {
            val mid = (left + right) / 2
            
            if (canCross(mid, stones, k)) {
                answer = mid + 1
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return answer
    }
    
    private fun canCross(people: Int, stones: IntArray, k: Int): Boolean {
        var count = 0
        
        for (stone in stones) {
            if (stone - people <= 0) count++
            else count = 0
            
            if (count >= k) return false
        }
        return true
    }
}