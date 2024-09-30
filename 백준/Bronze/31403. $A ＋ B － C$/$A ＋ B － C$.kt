fun main() {
    var intSum = 0
    var strSum = 0
    var tmp = ""
    val one = readln()
    val two = readln()
    val three = readln()

    tmp = one + two
    strSum = (tmp.toInt() - three.toInt())

    intSum = one.toInt() + two.toInt() - three.toInt()

    println(intSum)
    println(strSum)
}