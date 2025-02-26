class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        s.forEach { c ->
            if(c in listOf('(', '{', '[')) stack.push(c)
            else if (stack.isEmpty() && c in listOf(')', '}', ']')) return false
            else if (stack.peek() == '(' && c ==')') stack.pop()
            else if (stack.peek() == '{' && c =='}') stack.pop()
            else if (stack.peek() == '[' && c ==']') stack.pop()
            else return false
        }

        return if (stack.isNotEmpty()) false else true
    }
}