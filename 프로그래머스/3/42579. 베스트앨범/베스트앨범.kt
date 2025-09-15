class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        
        // map<String, Int>
        val genreTotal = genres.zip(plays.toList()) { a, b -> a to b }
            .groupBy { it.first }
            .mapValues { it.value.sumOf { it.second } }
            .entries.sortedByDescending { it.value }
            
        // map<String, List<Pair<Int, Int>>>
        val genreSong = genres.indices.groupBy { genres[it] }
            .mapValues { it.value.map { it to plays[it] } }
            
        genreTotal.map { (genre, _) ->
            val songs = genreSong[genre]!!
                .sortedWith(compareByDescending<Pair<Int, Int>> { it.second }.thenBy { it.first }).take(2)
            answer.addAll(songs.map { it.first })
        }
        
        return answer.toIntArray()
    }
}