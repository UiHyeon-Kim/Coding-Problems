class Solution {
    fun solution(s: String): Int {
        if (s.length == 1) return 1
        var minLen = Int.MAX_VALUE
        
        for (cutLen in 1..s.length / 2) {
            var compress = StringBuilder()
            var count = 1
            var prev = s.substring(0, cutLen) // 이전(자른) 글자
            
            for (start in cutLen until s.length step cutLen) {
                val end = minOf(start + cutLen, s.length)
                val curr = s.substring(start, end) // 비교할 문자
                
                if (prev == curr) {
                    count++
                } else {
                    // 글자가 다르면 문자열 압축. 현재 문자를 기준 문자로
                    compress.append(if (count > 1) "$count$prev" else prev)
                    prev = curr
                    count = 1
                }
            }
            compress.append(if (count > 1) "$count$prev" else prev)
            minLen = minLen.coerceAtMost(compress.length)
            // println(compress)
        }
        
        return minLen
    }
}