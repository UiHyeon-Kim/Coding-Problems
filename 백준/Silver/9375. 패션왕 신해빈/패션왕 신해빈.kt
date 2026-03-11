import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val case = readLine().toInt()
    val sb = StringBuilder()

    repeat(case) {
        val clothesCount =  readLine().toInt()
        val clothes = HashMap<String, Int>()

        repeat(clothesCount) {
            val st = StringTokenizer(readLine())
            st.nextToken()
            val type = st.nextToken()

            clothes[type] = clothes.getOrDefault(type, 1) + 1
        }

        val result = clothes.values.fold(1) { acc, value -> acc * value }
        sb.append(result - 1).append("\n")
    }

    println(sb)
}