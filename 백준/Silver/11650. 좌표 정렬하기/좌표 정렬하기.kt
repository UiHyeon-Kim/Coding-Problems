fun main() {
    val br = System.`in`.bufferedReader()

    val cnt = br.readLine().toInt()
    val arr = ArrayList<Pair<Int,Int>>()

    repeat(cnt) {
        val tmp = br.readLine().split(" ")
        arr.add(Pair(tmp[0].toInt(), tmp[1].toInt()))
    }

    arr.sortWith(compareBy({it.first},{it.second}))

    repeat(cnt) {
        println("${arr[it].first} ${arr[it].second}")
    }
}