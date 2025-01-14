package academy.learnprogramming.accessmodifiers

fun main(args: Array<String>) {

    val emp = Employee("John")
    println(emp.firstName)
    emp.fullTime = false
    println(emp.fullTime)

    val emp2 = Employee("Joe")
    println(emp2.firstName)
    println(emp2.fullTime)

    val emp3 = Employee("Jane", false)
    println(emp3.firstName)
    println(emp3.fullTime)

    println(Demo().dummy)

}

class Employee(val firstName: String, fullTime: Boolean = true){

    var fullTime = fullTime
    get() {
        println("Running the custom get")
        return field
    }
    set(value) {
        println("Running the custom set")
        field = value
    }

}

class Demo {
    val dummy: String

    constructor() {
        dummy = "Hello"
    }
}


