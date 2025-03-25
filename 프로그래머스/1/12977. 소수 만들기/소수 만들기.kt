import kotlin.math.sqrt

class Solution {
    fun solution(nums: IntArray): Int {
        var answer = 0
 
        for (i in 0 until nums.size) {
            for (j in (i+1) until nums.size) {
                for (k in (j+1) until nums.size) {
                    if (isPrime(nums[i], nums[j], nums[k])) answer++
                }
            }
        }

        return answer
    }
    
    fun isPrime(n1: Int, n2: Int, n3: Int): Boolean {
        val sum = n1 + n2 + n3
        
        if (sum < 2) return false
        for (i in 2..sqrt(sum.toDouble()).toInt()) {
            if (sum % i == 0) return false
        }
        
        return true
    }
}