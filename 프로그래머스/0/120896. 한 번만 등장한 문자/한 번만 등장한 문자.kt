class Solution {
    fun solution(s: String)  = s.groupBy { it }.filter { (_, v) -> v.size == 1 }.keys.sorted().joinToString("")
}