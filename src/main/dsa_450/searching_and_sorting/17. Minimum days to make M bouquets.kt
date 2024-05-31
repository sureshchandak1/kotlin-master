package searching_and_sorting

/**
 *    https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
 *    Time complexity: O(n (log n)), n for min max and (log n) for binary search
 *    Space complexity: O(1)
 */
fun main() {
    var bloomDay = intArrayOf(7, 7, 7, 7, 13, 11, 12, 7)
    println(minDays(bloomDay, 2, 3))
    bloomDay = intArrayOf(70545,40667,26392,42712,39599,8012,27194,71384,58079,2123,66655,48459,92802,16345,43374,15924,5480,48766,38512,44416,50530,14405,42803,4953,44480,31455,12440,72556,3593,74130,59278,72043,9508,66855,74237,46991,53829,61978,8137,47408,18152,3439,20331,28085,43180,36650,6053,62782,91043,32640,62145,79424,32256,89353,96289,85104,91235,80088,96025,59996,99511,24387,36850,21709,21253,45745,46148,80258,9365,27085,11183,38053,44747,24038,91223,32454,58318,77940,20208,98572,842,31307,90663,46331,8786,32234,24599,30552,78551,67424,19443,45458,49450,37665,79859,70847,30777,96178,96183,3153,98172,11893,35919,10268,21934,2335,50721,26460,73480,27509,19905,83061,64141,28707,73406,30908,80395,26159,41057,91277,5606,5661,88593,16020,69632,8323,15448,15620,70886,54549,73260,7253,60911,91137,20479,12094,8855,1836,28300,41499,91819,73008,74394,5665,52219,15620,54739,52384,58029,92968,17981,62083,91981,96508,19249,60972,39521,13830,15488,6608,13736,51362,27864,52448,51494,79885,95293,3884,70578,22710)
    println(minDays(bloomDay, 89945, 32127))
}
/*
   If the number of flowers in the array, represented by array-size,
   is less than m*k, it becomes impossible to form m bouquets even after all the flowers have bloomed.
 */
private fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {

    val requiredFlowers: Long = m.toLong() * k.toLong()
    if (requiredFlowers > bloomDay.size) {
        return -1
    }

    // find min and max value
    var mini = Int.MAX_VALUE
    var maxi = Int.MIN_VALUE
    for (value in bloomDay) {
        mini = Math.min(mini, value)
        maxi = Math.max(maxi, value)
    }

    // start binary search
    var start = mini
    var end = maxi
    var mid = start + (end - start) / 2

    while (start <= end) {

        if (possible(bloomDay, mid, m, k)) {
            end = mid - 1
        }
        else {
            start = mid + 1
        }

        mid = start + (end - start) / 2
    }

    return start
}

private fun possible(bloomDay: IntArray, day: Int, m: Int, k: Int): Boolean {

    var count = 0
    var noOfBouquets = 0

    for (value in bloomDay) {
        if (value <= day) {
            count++
        }
        else {
            noOfBouquets += count / k
            count = 0
        }
    }

    noOfBouquets += count / k

    return noOfBouquets >= m
}
















