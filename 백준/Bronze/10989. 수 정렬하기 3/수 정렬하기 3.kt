import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()
    val nums = IntArray(N) { br.readLine().toInt() }

    br.close()

    nums.sort()

    for (i in 0 until N) {
        bw.write(nums[i].toString())
        bw.newLine()
    }

    bw.flush()
    bw.close()
}