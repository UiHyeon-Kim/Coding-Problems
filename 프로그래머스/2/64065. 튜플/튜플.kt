class Solution {
    fun solution(s: String): List<Int> {
        var strs = s.split(",{")
        var tmp = mutableListOf<List<String>>()

        repeat(strs.size){
            tmp.add(strs[it].filter { it !in setOf('{', '}') }.split(","))
        }

        return tmp.sortedBy { it.size }.flatten().distinct().map { it.toInt() }
    }
}