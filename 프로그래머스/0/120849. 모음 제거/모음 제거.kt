class Solution {
    fun solution(my_string: String) = my_string.filter { !"aeiou".contains(it) }
}