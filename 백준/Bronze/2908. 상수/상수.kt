fun main() {
    val (A, B) = readln().split(" ")

    val num1 = A.reversed()
    val num2 = B.reversed()

    if (num1 > num2) println(num1)
    else println(num2)
}