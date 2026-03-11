fun main() = with(System.`in`.bufferedReader()){
    val case = readLine().toInt()

    repeat(case) {
        val clotheCount = readLine().toInt()
        val clothes = mutableMapOf<String, Int>()

        repeat(clotheCount) {
            val (_, type) = readLine().split(' ')
            clothes[type] = clothes.getOrDefault(type, 1) + 1
        }

        val result = clothes.values.fold(1) { acc, value -> acc * value }
        println(result - 1)
    }
}