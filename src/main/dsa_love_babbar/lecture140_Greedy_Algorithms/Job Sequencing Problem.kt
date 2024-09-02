package lecture140_Greedy_Algorithms

import printArray
import java.util.*

/**
 *    https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
 */
fun main() {
    printArray(jobScheduling(arrayOf(Job(1, 4, 20),
        Job(2, 1, 1),
        Job(3, 1, 40), Job(4, 1, 30)), 4))

    printArray(jobScheduling(arrayOf(Job(1, 2, 100),
        Job(2, 1, 19),
        Job(3, 2, 27), Job(4, 1, 25),
        Job(5, 1, 15)), 5))
}

private fun jobScheduling(arr: Array<Job>, n: Int): IntArray {

    arr.sortByDescending { it.profit }
    //Arrays.sort(arr) { j1, j2 -> j2.profit - j1.profit }

    var maxiDeadline = Int.MIN_VALUE
    for (job in arr) {
        maxiDeadline = Math.max(maxiDeadline, job.deadline)
    }

    val schedule = IntArray(maxiDeadline + 1) { -1 }

    var count = 0
    var maxProfit = 0
    for (job in arr) {
        val currProfit: Int = job.profit
        val currJobId: Int = job.id
        val currDeadline: Int = job.deadline

        for (k in currDeadline downTo 1) {
            if (schedule[k] == -1) {
                count++
                maxProfit += currProfit
                schedule[k] = currJobId
                break
            }
        }
    }

    val ans = IntArray(2)
    ans[0] = count
    ans[1] = maxProfit

    return ans
}

private class Job(var id: Int, var deadline: Int, var profit: Int)




