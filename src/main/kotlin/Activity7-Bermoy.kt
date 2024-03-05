fun main() {
    var continueChecking: Boolean
    do {
        print("Enter a string: ")
        val input = readLine()?.takeUnless { it.isNullOrBlank() }

        for (i in 1..1) {
            if (input != null) {
                val cleanInput = input.replace("\\s+".toRegex(), "").toLowerCase()
                val result = if (cleanInput == cleanInput.reversed()) "is" else "is not"
                println("$input $result a palindrome.")
            } else {
                println("Invalid input. Please enter a non-empty string.")
            }
        }

        print("Do you want to check another string? (yes/no): ")
        continueChecking = readLine()?.equals("yes", ignoreCase = true) == true
        println("Thank You.")
    } while (continueChecking)
}
