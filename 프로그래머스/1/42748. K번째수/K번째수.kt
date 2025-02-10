class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): List<Int> {
        var answer = mutableListOf<Int>()
        
        commands.forEach { command ->
            val sub = array.slice(command[0]-1 until command[1]).sorted()
            answer.add(sub[command[2] - 1])
        }
        
        return answer
    }
}