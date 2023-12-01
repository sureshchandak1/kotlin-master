package prototype

fun main(args: Array<String>) {

    val person = Person(
        name = "John",
        age = 22,
        birthDate = "20-11-1990",
        address = Address(10)
    )
    println(person)

    val copyPerson1 = person.copy()
    val copyPerson2 = person.copy(address = Address(person.address.houseNumber))
    val copyPerson3 = person.copyPerson()

    person.address.houseNumber = 12

    println(copyPerson1)
    println(copyPerson2)
    println(copyPerson3)

}

private data class Person(
    var name: String,
    var age: Int,
    var birthDate: String,
    var address: Address
)

private fun Person.copyPerson() : Person {
    return Person(
        name = this.name,
        age = this.age,
        birthDate = this.birthDate,
        address = Address(houseNumber = this.address.houseNumber)
    )
}

private data class Address(
    var houseNumber: Int
)