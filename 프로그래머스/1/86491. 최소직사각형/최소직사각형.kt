data class Card(val x: Int, val y: Int)

class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0
        val card = mutableListOf<Card>()
        
        sizes.forEach { (x, y) ->
            card.add(Card(maxOf(x, y), minOf(x, y)))
        }
        
        answer = card.maxOf { it.x } * card.maxOf { it.y }
        
        return answer
    }
}