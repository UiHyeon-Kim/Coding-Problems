class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = mutableListOf<Int>()
        val userMap = mutableMapOf<String, MutableList<String>>()   // 유저가 신고한 ID
        val reportedUser = mutableMapOf<String, Int>()              // 신고된 유저 to 횟수
        
        report.toSet().forEach {
            it.split(" ").let { (user, repot) ->
                userMap.getOrPut(user) { mutableListOf() }.add(repot)
                reportedUser[repot] = reportedUser.getOrDefault(repot, 0) + 1
            }
        }
        
        val bened = reportedUser.filterValues { it >= k }.keys

        id_list.forEach { id ->
            val mail = userMap[id]?.count { it in bened } ?: 0
            answer.add(mail)
        }
        
        return answer.toIntArray()
    }
}