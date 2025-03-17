class Solution {
    fun solution(a: Int, b: Int, n: Int) = getEmptyBottle(a, b, n, 0)
    
    fun getEmptyBottle(a: Int, b: Int, n: Int, total: Int) : Int {
        if (n < a) return total
        
        var currentBottle = n % a + (n / a * b)
        
        return getEmptyBottle(a, b, currentBottle, total + n / a * b)
    }
}