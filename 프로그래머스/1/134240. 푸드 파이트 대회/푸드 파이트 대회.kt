class Solution {
    fun solution(food: IntArray): String {
        var answer = StringBuilder()
        
        for ((index, value) in food.withIndex()) {
            if (value / 2 == 0) continue
            repeat(value / 2) { answer.append(index) }
        }
        
        answer.append(0)
        answer.append(answer.reversed().drop(1))
        
        return answer.toString()
    }
}