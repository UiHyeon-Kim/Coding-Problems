import kotlin.math.*

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): List<Int> {
        var days = progresses.mapIndexed { index, progress ->
            ceil((100.0 - progress) / speeds[index]).toInt()
        }
        var maxDay = days[0]
        var count = 0
        var answer = mutableListOf<Int>()
        
        for(day in days) {
            if(maxDay >= day) {
                count++
            } else {
                answer.add(count)
                maxDay = day
                count = 1
            }
        }
        
        answer.add(count)
        
        return answer
    }
}