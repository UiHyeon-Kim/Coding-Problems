class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = mutableListOf<Pair<String, String>>()
        val map = mutableMapOf<String, String>()
        
        record.forEach {
            val v = it.split(" ")
            if(v[0] != "Leave") map[v[1]] = v[2]
            
            when(v[0]) {
                "Enter" -> answer.add(Pair(v[1], "님이 들어왔습니다."))
                "Leave" -> answer.add(Pair(v[1], "님이 나갔습니다."))
                "Change" -> map[v[1]] = v[2]
            }
        }
        
        
        
        return answer.map { (nick, message) ->
            map[nick] + message
        }.toTypedArray()
    }
}