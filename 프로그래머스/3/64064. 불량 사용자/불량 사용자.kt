class Solution {
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        val subset = mutableSetOf<String>()
        val result = mutableSetOf<Set<String>>()
        
        fun dfs(depth: Int) {
            if (depth == banned_id.size) {
                result.add(subset.toSet())
                return
            }
            
            for (uid in user_id) {
                if (uid !in subset && isMatch(uid, banned_id[depth])) {
                    subset.add(uid)
                    dfs(depth + 1)
                    subset.remove(uid)
                }
            }
        }
        dfs(0)
        return result.size
    }
    
    private fun isMatch(uid: String, banid: String): Boolean {
        if (uid.length != banid.length) return false
        return uid.indices.all { banid[it] == '*' || uid[it] == banid[it] }
    }
}