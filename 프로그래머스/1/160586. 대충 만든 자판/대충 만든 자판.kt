class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer = targets.map { str ->
            var sum = 0
            for(c in str) {
                var index = 101
                keymap.forEach { words ->
                    val find = if (words.indexOf(c) == -1) 100 else words.indexOf(c) + 1
                    index = minOf(index, find)
                }
                if (index == 100) {
                    sum = 0
                    -1
                    break
                } else {
                    sum += index
                }
            }
            if (sum % 101 == 0) -1 else sum
        }
        return answer.toIntArray()
    }
}