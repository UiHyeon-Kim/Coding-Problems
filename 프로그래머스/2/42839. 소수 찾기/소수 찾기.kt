class Solution {
    fun solution(numbers: String): Int {
        var answer = mutableSetOf<Int>()
        val visited = BooleanArray(numbers.length)
        
        fun backtrack(current: String) {
            if(current.isNotEmpty()) {
                val num = current.toInt()
                if (num.isPrime()) answer.add(num)
            }
            
            for (i in numbers.indices) {
                if (!visited[i]) {
                    visited[i] = true
                    backtrack(current + numbers[i])
                    visited[i] = false
                }
            }
        }
        
        backtrack("")
        return answer.size
    }
     fun Int.isPrime(): Boolean {
        if(this < 2) return false
        if(this == 2) return true
        if (this % 2 == 0) return false
        for (i in 3..Math.sqrt(toDouble()).toInt() step 2) {
            if (this % i == 0) return false
        }
        return true
    }
}