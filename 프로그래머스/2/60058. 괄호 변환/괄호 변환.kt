class Solution {
    fun solution(p: String): String {
        if (p.isEmpty()) return ""
        
        var count = 0
        var correct = true
        var u = ""
        var v = ""
        
        for (i in p.indices) {
            if (p[i] == '(') count++
            else count--
            
            if (count < 0) correct = false
            
            if (count == 0) {
                u = p.substring(0, i + 1)
                v = p.substring(i + 1)
                break
            }
        }
        
        var sb = StringBuilder()
        if (correct) {
            return u + solution(v)
        } else {
            sb.append('(')
            sb.append(solution(v))
            sb.append(')')
            
            val subStr = u.substring(1, u.length - 1)
            subStr.forEach {
                sb.append(if (it == '(') ')' else '(')
            }
        }
        
        return sb.toString()
    }
}