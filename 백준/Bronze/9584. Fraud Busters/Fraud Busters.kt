fun main() {
    val findCarNum = readln()
    var carList = mutableListOf<String>()
    val t = readln().toInt()

    for (i in 0 until t) {
        val carNum = readln()
        var isCar = true
        for (j in findCarNum.indices) {
            if (findCarNum[j] != '*' && findCarNum[j] != carNum[j]) isCar = false
        }

        if (isCar == true) carList.add(carNum)
    }

    println(carList.size)
    println(carList.joinToString("\n"))
}