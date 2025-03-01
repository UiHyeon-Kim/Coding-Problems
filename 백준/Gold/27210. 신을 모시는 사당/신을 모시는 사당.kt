fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }
    var enlightenment = 0
    var leftSum = 0
    var rightSum = 0

    for (i in 0..<n) {
        if (arr[i] == 1) {
            leftSum++
            rightSum--
        } else {
            leftSum--
            rightSum++
        }
        if (leftSum < 0) leftSum = 0
        if (rightSum < 0) rightSum = 0
        enlightenment = maxOf(enlightenment, leftSum, rightSum)
    }

    println(enlightenment)
}
