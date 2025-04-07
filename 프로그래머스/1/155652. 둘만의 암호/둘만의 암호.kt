class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        var answer = s.map { 
            var current = it
            var count = 0
            
            while (count < index) {
                current++
                if (current > 'z') current = 'a'
                if (!skip.contains(current)) count++
            }
            current
        }
        return answer.joinToString("")
    }
}