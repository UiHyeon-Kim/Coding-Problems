class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val map = mutableMapOf<String, Int>()
        
        for ((name, type) in clothes) {
            map[type] = map.getOrDefault(type, 0) + 1
        }
        
        for (i in map.values) {
            answer *= (i + 1)
        }
        
        return answer - 1
    }
}