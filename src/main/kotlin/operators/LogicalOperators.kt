package operators

fun main() {

    var above70Percentage = false
    var knowsProgramming = false

    // && AND
    println("----------------- && AND -----------------")
    var calledForInterview = above70Percentage && knowsProgramming // both false
    println(calledForInterview)
    knowsProgramming = true
    calledForInterview = above70Percentage && knowsProgramming // 1 false, 1 true
    println(calledForInterview)
    above70Percentage = true
    calledForInterview = above70Percentage && knowsProgramming // both true
    println(calledForInterview)

    above70Percentage = false
    knowsProgramming = false

    // || OR
    println("-------------- || OR ------------------")
    calledForInterview = above70Percentage || knowsProgramming // both false
    println(calledForInterview)
    knowsProgramming = true
    calledForInterview = above70Percentage || knowsProgramming // 1 false, 1 true
    println(calledForInterview)
    above70Percentage = true
    calledForInterview = above70Percentage || knowsProgramming // both true
    println(calledForInterview)

    // ! NOT
    println("-------------- ! NOT ------------------")
    // false --> ! --> true
    // true --> ! --> false

    var answer = false
    println(!answer)
    println(answer)
    println(!!answer)
    println(!!!answer)
    println(!!!!answer)


    // Short Circuiting
    println("Short Circuiting")
    var i = 10
    var j = 11
    var result = i == 10 || j++ == 11 // first condition is true then not check second condition
    println(i)
    println(j)

    result = i == 20 && j++ == 11 // first condition is false then not check second condition
    println(i)
    println(j)
}