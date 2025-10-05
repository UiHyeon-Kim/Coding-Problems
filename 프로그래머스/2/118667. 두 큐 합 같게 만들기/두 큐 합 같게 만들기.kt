class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val totalSum = queue1.sum().toLong() + queue2.sum().toLong()
        val goalSum = totalSum / 2
        
        if (totalSum % 2 != 0L) return -1
        
        val q1 = ArrayDeque<Int>(queue1.toList())
        val q2 = ArrayDeque<Int>(queue2.toList())
        var count = 0
        val maxCount = q1.size * 3
        var sum = q1.sum().toLong()
        
        while (sum != goalSum) {
            if (count >= maxCount) return -1
            if (sum > goalSum) {
                val v = q1.removeFirst()
                q2.add(v)
                sum -= v
            } else {
                val v = q2.removeFirst()
                q1.add(v)
                sum += v
            }
            count++
        }
        
        return count
    }
}