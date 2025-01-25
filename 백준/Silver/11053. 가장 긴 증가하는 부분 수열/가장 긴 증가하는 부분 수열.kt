import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val lis = mutableListOf<Int>() // LIS 배열

    for (num in arr) {
        val pos = lis.binarySearch(num).let { if (it < 0) -(it + 1) else it }

        if (pos < lis.size) {
            lis[pos] = num
        } else {
            lis.add(num)
        }
    }

    println(lis.size) 
}
