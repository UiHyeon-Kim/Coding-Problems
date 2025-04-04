class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var total = 1
        for (i in 1..11) {
            total *= i
            if (total > n) {
                answer = i - 1
                break
            }
        }
        return answer
    }
}