fun main() {
    println("IDENTIFY UNIQUE CHARACTERS")

    do {
        var uniqueCharsFirst = ""
        var uniqueCharsSecond = ""

        for (i in 1..2) {
            print("Enter string $i: ")
            val input = readLine() ?: ""
            val uniqueChars = input.groupBy { it }.filter { it.value.size == 1 }.keys.joinToString("")

            if (i == 1) {
                uniqueCharsFirst = uniqueChars
                println("Unique characters from first string:")
                println("[$uniqueCharsFirst]")
            } else {
                uniqueCharsSecond = uniqueChars
                println("Unique characters from second string:")
                println("[$uniqueCharsSecond]")
            }
        }

        val uniqueChars = (uniqueCharsFirst + uniqueCharsSecond).groupBy { it }.filter { it.value.size == 1 }.keys.joinToString("")

        if (uniqueChars.isEmpty()) {
            println("No unique characters in combined strings.")
        } else {
            println("Unique characters from both strings:")
            println("[$uniqueChars]")
        }

        print("Do you want to try again [yes/no]: ")
    } while (readLine()?.equals("yes", ignoreCase = true) == true)

    println("Thank You! ")
}
