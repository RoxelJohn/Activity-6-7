package org.example

import java.util.Scanner

fun main(args: Array<String>) {

    // Creates a reader instance which takes
    // input from standard input - keyboard
    val reader = Scanner(System.`in`)
    print("Enter first number: ")

    // nextInt() reads the next integer from the keyboard
    val first:Int = reader.nextInt()

    print("Enter second number: ")
    val second:Int = reader.nextInt()

    var sum = first + second

    // println() prints the following line to the output screen
    println("You entered: $sum")
}

