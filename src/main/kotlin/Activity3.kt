package org.example

fun main() {
    for(noOfStud in 1..4) {
        val birthYear = promptBirthYear()
        val age = calculateAge(birthYear)
        val ageGroup = determineAgeGroup(age)
        println("What is your name: ")
        var name = readLine()
        println("Hi $name. Your age is $age. You are $ageGroup")
    }
}
fun promptBirthYear():Int{
    println("Enter your birth year: ")
    val input = readLine()?.toIntOrNull()
    return if(input == null||input <0){
        println("Invalid input. Please enter a valid year.")
        promptBirthYear()
    }else{
        input
    }
}
fun calculateAge(birthYear: Int): Int
{
   val currentYear = 2024
    return currentYear - birthYear
    }
fun determineAgeGroup(age:Int):String{
    return when{
        age in 1..17 ->"Underage"
        age in 18..30->"Young Adult"
        age in 31..59->"Adult"
        else->"Old"
    }
}