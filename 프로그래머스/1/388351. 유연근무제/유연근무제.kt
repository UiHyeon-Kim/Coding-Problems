class Solution {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer: Int = 0
        val holiday = listOf(6, 7)
        
        timelogs.forEachIndexed { index, times ->
            val result = IntArray(7)
            var possibleTime = (schedules[index] / 100) * 100 + (schedules[index] % 100) + 10
            if (possibleTime % 100 >= 60) possibleTime += 40
            times.forEachIndexed { day, time ->
                val currentDay = (day + startday - 1) % 7
                if (currentDay + 1 !in holiday) {
                    if(possibleTime < time) result[currentDay]++
                }
            }
            if(result.sum() == 0) answer++
        }
        
        return answer
    }
}