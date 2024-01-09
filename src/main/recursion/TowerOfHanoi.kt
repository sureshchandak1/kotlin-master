fun main() {
    var n = 1
    println("n = $n")
    towerOfHanoi(n, "S", "H", "D")
    println("--------------------------------------------------")
    n = 2
    println("n = $n")
    towerOfHanoi(n, "S", "H", "D")
    println("--------------------------------------------------")
    n = 3
    println("n = $n")
    towerOfHanoi(n, "S", "H", "D")
    println("--------------------------------------------------")
}

private fun towerOfHanoi(n: Int, source: String, helper: String, destination: String) {

    if (n == 1) {
        println("transfer disk $n from $source to $destination")
        return
    }

    towerOfHanoi(n - 1, source, destination, helper)
    println("transfer disk $n from $source to $destination")
    towerOfHanoi(n - 1, helper, source, destination)

}