class Solution {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val courseCount = mutableMapOf<String, Int>()
        val result = mutableListOf<String>()
        
        for(order in orders) {
            val menus = order.toCharArray().sorted()
            for (len in course) {
                combinations(menus, len).forEach { comb ->     
                    val cb = comb.joinToString("")
                    courseCount[cb] = courseCount.getOrDefault(cb, 0) + 1  
                }
            }
        }
        
        println(courseCount)
        for (len in course) {
            val currentMap = courseCount.filter { (k, v) -> k.length == len && v > 1 }
            if (currentMap.isEmpty()) continue
            val max = currentMap.maxOf { it.value }
            result += currentMap.filter { (k, v) -> v == max }.keys
        }
        
        return result.sorted().toTypedArray()
    }
}

private fun combinations(menus: List<Char>, len: Int): MutableList<List<Char>> {
    val subset = mutableListOf<Char>()
    val result = mutableListOf<List<Char>>()
    
    fun backtrack(start: Int) {
        if (subset.size == len) {
            result.add(subset.toList())
            return
        }
        
        for (i in start until menus.size) {
            subset.add(menus[i])
            backtrack(i + 1)
            subset.removeLast()
        }
    }
    backtrack(0)

    return result
}