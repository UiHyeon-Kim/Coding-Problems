class Solution {
    fun solution(n: Int) = (1..n / 2).fold(0) { acc, num -> if (n % num == 0) acc + num else acc } + n
}