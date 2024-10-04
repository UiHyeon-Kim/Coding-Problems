class Solution {
    fun solution(s: String): List<Int> {
        var strs = s.split(",{")
        var tmp = mutableListOf<List<String>>()

        repeat(strs.size){
            tmp.add(strs[it].filter { it !in setOf('{', '}') }.split(","))
        }
        tmp.sortBy { it.size }

        return tmp.flatten().distinct().map { it.toInt() }
    }
}