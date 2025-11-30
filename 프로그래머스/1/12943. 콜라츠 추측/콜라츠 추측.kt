class Solution {
    fun solution(num: Int): Int = collatz(num.toLong(), 0)
    
    private tailrec fun collatz(num: Long, count: Int): Int {
        if (num == 1L) return count
        if (count >= 500) return -1
        
        val next = if (num % 2 == 0L) num / 2 else num * 3 + 1
        
        return collatz(next, count + 1)
    } 
}