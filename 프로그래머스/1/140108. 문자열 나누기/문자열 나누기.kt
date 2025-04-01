class Solution {
    fun solution(s: String): Int {
        var answer = 0
        var firstLetter = 0
        var restLetter = 0
        var str = 'A'
        
        for (i in s) {
            if (str == 'A') {
                str = i
                firstLetter = 0
                restLetter = 0
                answer++
            } 
            
            if (str == i) {
                firstLetter++
            } else {
                restLetter++
            }
            
            if (firstLetter == restLetter) {
                str = 'A'
            }
        }
        
        return answer
    }
}