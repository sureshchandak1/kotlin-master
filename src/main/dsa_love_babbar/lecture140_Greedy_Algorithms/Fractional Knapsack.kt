package lecture140_Greedy_Algorithms

import kotlin.collections.ArrayList

/**
 *     https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
 *     Time Complexity : O(n log n)
 *     Space Complexity: O(1)
 */
fun main() {
    var value = intArrayOf(60,100,120)
    var weight = intArrayOf(10,20,30)
    var arr = ArrayList<ItemFK>()
    for (i in value.indices) arr.add(ItemFK(value[i], weight[i]))
    println(fractionalKnapsack(50, arr, value.size))

    value = intArrayOf(60,100); weight = intArrayOf(10,20); arr = ArrayList<ItemFK>()
    for (i in value.indices) arr.add(ItemFK(value[i], weight[i]))
    println(fractionalKnapsack(50, arr, value.size))
}

private fun fractionalKnapsack(w: Int, arr: MutableList<ItemFK>, n: Int): Double {

    var w = w
    val list: MutableList<PairFK> = ArrayList()

    for (i in 0..< n) {
        val perUnitValue: Double = (1.0 * arr[i].value) / arr[i].weight
        list.add(PairFK(perUnitValue, arr[i]))
    }

    list.sortByDescending { it.perUnit }

    var totalValue = 0.0

    for (i in 0..<n) {
        if (list[i].item.weight > w) {
            // include portioin for item
            totalValue += w * list[i].perUnit
            w = 0
        } else {
            // include full item
            totalValue += list[i].item.value
            w -= list[i].item.weight
        }
    }

    return totalValue
}

private class PairFK(var perUnit: Double, var item: ItemFK)

private class ItemFK(var value: Int, var weight: Int)

