fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    val n = br.readLine().toInt()
    val nums = Array(n) { br.readLine().toInt() }.sorted()
    br.close()

    repeat(n) {
        bw.write(nums[it].toString())
        bw.newLine()
    }

    bw.flush()
    bw.close()
}