class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        for (c in s) {
            if (c in listOf('(', '{', '[')) {
                stack.push(c)
            } else {
                if (stack.isEmpty() ||
                    (c == ')' && stack.pop() != '(') ||
                    (c == '}' && stack.pop() != '{') ||
                    (c == ']' && stack.pop() != '[')) {
                        return false
                    }
            }
        }
        return stack.isEmpty()
    }
}