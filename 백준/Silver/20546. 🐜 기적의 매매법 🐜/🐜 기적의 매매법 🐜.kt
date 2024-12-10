fun main() {
    val cash = readln().toInt()
    val stockPrices = readln().split(" ").map { it.toInt() }
    var junCash = cash
    var sungCash = cash
    var junStock = 0
    var sungStock = 0
    var riseCount = 0
    var declineCount = 0

    stockPrices.forEach { stockPrice ->
        if (stockPrice <= junCash) {
            junStock += junCash / stockPrice
            junCash %= stockPrice
        }
    }

    for (index in 1..<stockPrices.size) {
        if (stockPrices[index - 1] < stockPrices[index]) riseCount++
        else riseCount = 0
        if (stockPrices[index - 1] > stockPrices[index]) declineCount++
        else declineCount = 0

        if (declineCount >= 3) {
            sungStock += sungCash / stockPrices[index]
            sungCash %= stockPrices[index]
        }
        if (riseCount >= 3 && sungStock > 0) {
            sungCash += stockPrices[index] * sungStock
            sungStock = 0
        }
    }

    val junAssets = junCash + junStock * stockPrices.last()
    val sungAssets = sungCash + sungStock * stockPrices.last()

    when {
        junAssets > sungAssets -> println("BNP")
        junAssets < sungAssets -> println("TIMING")
        else -> println("SAMESAME")
    }
}
