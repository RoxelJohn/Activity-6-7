fun main() {
   do{
       println("*****Welcome to the Unique Character Finder!*****")
    println("*****Please enter two strings to find their unique characters******")

       println("Enter the first string:")
    var str1 = readLine() ?: ""

    println("Enter the second string:")
    var str2 = readLine() ?: ""
    val uniqueChars = mutableSetOf<Char>()
    for (char in str1) {
        if (!str2.contains(char)) {
            uniqueChars.add(char)
        }
    }
    for (char in str2) {
        if (!str1.contains(char)) {

            uniqueChars.add(char)
        }
    }
       println("Unique characters in both strings:")
    for (uniqueChar in uniqueChars) {
        println(uniqueChar)
    }
    print("DO YOU WANT TO CONTINUE [Y] IF YES, [N] IF NO: ")
} while (readLine()?.equals("y", ignoreCase = true) == true)

println("Arigatou Gozaimasu!")
}

