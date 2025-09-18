import java.util.Stack

class Solution {
    fun solution(number: String, k: Int): String {
        val stack = Stack<Char>()
        var remove = k
        
        for (c in number) {
            while(stack.isNotEmpty() && stack.peek() < c && remove > 0) {
                stack.pop()
                remove--
            }
            stack.push(c)
        }
        
        return stack.joinToString("").substring(0, number.length - k)
    }
}