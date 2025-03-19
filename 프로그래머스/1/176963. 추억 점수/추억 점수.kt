class Solution {
    fun solution(names: Array<String>, yearning: IntArray, photos: Array<Array<String>>): IntArray {
        val memory = names.zip(yearning.toList()).toMap()
    
        return photos.map { photo ->
            photo.sumOf { memory[it] ?: 0 }
        }.toIntArray()
    }
}