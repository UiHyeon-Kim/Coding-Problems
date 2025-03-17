class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        return (if (n > b) n - b else 0) / (a - b) * b
    }
}