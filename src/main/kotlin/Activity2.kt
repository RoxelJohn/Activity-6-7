package org.example

fun main(){
    val noOfStud = 5
    val subjects = listOf("Math", "English", "Filipino", "Science")
    for (i in 1..noOfStud) {
        println("Write your name: ")
        val name = readLine()
        var totalGrade = 0.0

        println("The grades for $name:")
        subjects.forEach { subject ->
            totalGrade += getGrade(subject)
        }
        val averageGrade = totalGrade / subjects.size
        println("$name, your average grade is : $averageGrade")
    }
}

fun getGrade(subject: String): Double {
    println("Enter your grade in $subject: ")
    return readLine()?.toDoubleOrNull() ?: run {
        println("Invalid input. Please enter a valid grade.")
        getGrade(subject)
    }
}