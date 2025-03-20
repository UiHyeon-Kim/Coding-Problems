import kotlin.math.*

class Solution {
    fun solution(n: Int): Int = if(Math.sqrt(n.toDouble()) % 1 == 0.0) 1 else 2
}