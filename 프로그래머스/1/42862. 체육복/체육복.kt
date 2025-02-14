import java.util.*

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val lostStudent = (lost.toSet() - reserve.toSet()).toMutableList()
        val resStudent = reserve.toSet() - lost.toSet()
        
        for (studentNo in resStudent.sorted()) {
            if (studentNo - 1 in lostStudent) lostStudent.remove(studentNo - 1)
            else if (studentNo + 1 in lostStudent) lostStudent.remove(studentNo + 1)
        }
        
        return n - lostStudent.size
    }
}