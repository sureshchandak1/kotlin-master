package lecture078_Hashmaps

fun main() {
    val unorderedMap: MutableMap<String, String> = HashMap()
    unorderedMap["ifi1"] = "video1"
    unorderedMap["ifi2"] = "video2"
    unorderedMap["ifi3"] = "video3"
    unorderedMap["ifi4"] = "video4"
    unorderedMap["ifi5"] = "video5"
    unorderedMap["ifi6"] = "video6"
    unorderedMap["ifi7"] = "video7"
    unorderedMap["ifi8"] = "video8"
    unorderedMap["ifi9"] = "video9"

    for (entry in unorderedMap) {
        println("${entry.key} = ${entry.value}")
    }

    println("-----------------------------------------")

    val orderedMap: MutableMap<String, String> = LinkedHashMap()
    orderedMap["ifi1"] = "video1"
    orderedMap["ifi2"] = "video2"
    orderedMap["ifi3"] = "video3"
    orderedMap["ifi4"] = "video4"
    orderedMap["ifi5"] = "video5"
    orderedMap["ifi6"] = "video6"
    orderedMap["ifi7"] = "video7"
    orderedMap["ifi8"] = "video8"
    orderedMap["ifi9"] = "video9"

    for (entry in orderedMap) {
        println("${entry.key} = ${entry.value}")
    }

    //unorderedMap.clear()
    //orderedMap.clear()

    println(unorderedMap["unknownKey"])
    println(unorderedMap.get("unknownKey"))

    println(orderedMap.containsKey("abc")) // if key not present return false

    orderedMap.remove("ifi9")

    println("-----------------------------------------")
    for (entry in orderedMap) {
        println("${entry.key} = ${entry.value}")
    }

    println("----------------- Iterator -----------------")
    val iterator = unorderedMap.iterator()

    while (iterator.hasNext()) {
        val entry = iterator.next()
        println("${entry.key} = ${entry.value}")
    }
}