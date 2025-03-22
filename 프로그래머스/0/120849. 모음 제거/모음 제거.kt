class Solution {
    fun solution(my_string: String): String {
        var answer = StringBuilder()
        
        my_string.forEach {
            if (it !in listOf('a', 'e', 'i', 'o', 'u')) answer.append(it)
        }
        
        return answer.toString()
    }
}