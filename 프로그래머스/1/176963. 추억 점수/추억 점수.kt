class Solution {
    fun solution(names: Array<String>, yearning: IntArray, photos: Array<Array<String>>): IntArray {
        var answer = IntArray(photos.size)
        val memory = names.zip(yearning.toList()).toMap()
        
        photos.forEachIndexed { index, photo ->
            photo.forEach { person ->
                answer[index] += memory.getOrDefault(person, 0)
            }
        }
        
        return answer
    }
}