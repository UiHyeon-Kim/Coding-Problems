class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        val answer = StringBuilder()
        val phone = mapOf(
            1 to Pair(0, 0), 2 to Pair(0, 1), 3 to Pair(0, 2),
            4 to Pair(1, 0), 5 to Pair(1, 1), 6 to Pair(1, 2),
            7 to Pair(2, 0), 8 to Pair(2, 1), 9 to Pair(2, 2),
            -1 to Pair(3, 0), 0 to Pair(3, 1), -2 to Pair(3, 2),
        )
        
        var leftHand = phone[-1]!!
        var rightHand = phone[-2]!!
        
        for (num in numbers) {
            val cur = phone[num]!!
            
            when(num) {
                1, 4, 7 -> {
                    answer.append("L")
                    leftHand = cur
                }
                3, 6, 9 -> {
                    answer.append("R")
                    rightHand = cur
                }
                else -> {
                    val leftDist = distinct(leftHand, cur)
                    val rightDist = distinct(rightHand, cur)
                    
                    if (leftDist < rightDist) {
                        answer.append("L")
                        leftHand = cur
                    } else if (rightDist < leftDist) {
                        answer.append("R")
                        rightHand = cur
                    } else {
                        if (hand == "right") {
                            answer.append("R")
                            rightHand = cur
                        } else {
                            answer.append("L")
                            leftHand = cur
                        }
                    }
                }
            }
        }        
        
        return answer.toString()
    }
    
    private fun distinct(p1: Pair<Int, Int>, p2: Pair<Int, Int>) = 
        Math.abs(p1.first - p2.first) + Math.abs(p1.second - p2.second)
}