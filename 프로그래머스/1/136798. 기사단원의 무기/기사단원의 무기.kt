import kotlin.math.*

class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0
        
        for (i in 1..number) {
            var sum = 1
            for (j in 1..(i / 2)) {
                if (i % j == 0) sum++ 
            }
            if (sum > limit) answer += power
            else answer += sum
        }
        
        return answer
    }
}