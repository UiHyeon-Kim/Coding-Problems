class Solution {
    fun solution(n: Int): Int = (0..n).filter { it % 2 == 0 }.reduce { acc, sum -> acc + sum }
}