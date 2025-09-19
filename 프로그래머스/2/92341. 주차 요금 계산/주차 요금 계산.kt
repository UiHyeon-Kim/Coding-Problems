class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val carTotalMin = mutableMapOf<Int, Int>()      // 차 번호, 총 시간
        val carHistMap = mutableMapOf<Int, String>()    // 차 번호, 입차 시간
        
        val (baseMin, baseWon, partMin, partWon) = fees
        
        // 기록 있는 차 총 시간 합
        records.forEach { record ->
            val (time, c, hist) = record.split(" ")
            val car = c.toInt()
            
            if (hist == "IN") {
                carHistMap.put(car, time)
            } else {
                val (inH, inM) = carHistMap.remove(car)!!.split(":").map(String::toInt)
                val inTime = inH * 60 + inM
                
                val (outH, outM) = time.split(":").map(String::toInt)
                val outTime = outH * 60 + outM
                
                carTotalMin[car] = carTotalMin.getOrDefault(car, 0) + (outTime - inTime)
            }
        }
        
        // 출차 이력 없는 차 시간 합
        carHistMap.forEach { (car, inTimeStr) ->
            val (inH, inM) = inTimeStr.split(":").map(String::toInt)
            val inTime = inH * 60 + inM
            val outTime = 23 * 60 + 59
            
            carTotalMin[car] = carTotalMin.getOrDefault(car, 0) + (outTime - inTime)
        }
        
        // 금액 계산
        return carTotalMin.entries.sortedBy { it.key }.map {
            if (it.value <= baseMin) {
                baseWon
            } else {
                baseWon + Math.ceil((it.value - baseMin) / partMin.toDouble()).toInt() * partWon
            }            
        }.toIntArray()
    }
}