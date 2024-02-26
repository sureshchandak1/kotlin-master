package lecture043_OOPs_Day2

/*
*  Information Hiding/ Data Hiding
*
*  - Increase Security
*  - Make class "Read Only" (Create only getter not setter)
*  - Code Reusability
*  - Easy to Unit Testing
*
* */

class Student {

    private var name: String = ""
    private var age: Int = 18
    private var height: Float = 5F

    public fun setName(name: String) {
        this.name = name
    }

    public fun getName(): String {
        return name
    }

}