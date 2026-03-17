import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val target = Array(n) { st.nextToken().toInt() }

    val pivot = ((n - 1) downTo 1).find { target[it - 1] > target[it] } ?: return@with println(-1)
    val swapIndex = ((n - 1) downTo pivot).find { target[pivot - 1] > target[it] }!!

    target[pivot - 1] = target[swapIndex].also { target[swapIndex] = target[pivot - 1] }
    target.reverse(pivot, n)

    println(target.joinToString(" "))
}