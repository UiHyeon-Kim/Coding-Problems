class Solution {
    fun solution(angle: Int): Int {
        if (angle == 90) return 2
        
        return when(angle / 90) {
            0 -> 1
            1 -> 3
            else -> 4
        }
    }
}