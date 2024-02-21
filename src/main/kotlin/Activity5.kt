import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main() {
    var continueAddStudent = true

    while (continueAddStudent) {
        println("Welcome to the school library system")

        print("Enter student's ID: ")
        val studentId = readLine()?.let { "${it.substring(0, 2)}-${it.substring(2)}" } ?: ""

        print("Enter student's first name: ")
        val studentFname = readLine()?.toUpperCase() ?: ""
        print("Enter student's Middle Name: ")
        val studentMI = readlnOrNull()?.toCharArray()?.get(0)?.toUpperCase()
        print("Enter student's last name: ")
        val studentLName = readLine()?.toUpperCase() ?: ""
        val studentName = "$studentFname $studentMI. $studentLName"

        print("Enter Department: ")
        val studentDept = readlnOrNull()?.toCharArray()?.get(0)?.toUpperCase()
        println("Enter student's year level:")
        println("1. First year")
        println("2. Second year")
        println("3. Third year")
        println("4. Fourth year")
        print("Enter your choice: ")
        val yearLevelChoice = readLine()?.toIntOrNull()

        val yearLevel = when (yearLevelChoice) {
            1 -> "First year"
            2 -> "Second year"
            3 -> "Third year"
            4 -> "Fourth year"
            else -> "Unknown"
        }

        var continueAddBook = true
        var borrowedBooks = ""

        while (continueAddBook) {
            print("Enter book name to borrow: ")
            val borrowBook = readLine()?.toUpperCase() ?: ""

            borrowedBooks += if (borrowedBooks.isEmpty()) borrowBook else ", $borrowBook"

            println("Is book '$borrowBook' available: (yes/no)")
            val isAvailable = readLine()?.toLowerCase() == "yes"

            if (isAvailable) {
                println("Book '$borrowBook' is available. Borrowed!")
            } else {
                println("Book '$borrowBook' is unavailable.")
            }

            println("Do you want to borrow another book? (yes/no)")
            continueAddBook = readLine()?.toLowerCase() == "yes"
        }

        val currentDate = LocalDate.now()
        val formattedDate = currentDate.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"))

        println("\nStudent Details:")
        println("Student ID: $studentId, Student Name: $studentName, Department: $studentDept, Year Level: $yearLevel, Date: $formattedDate")
        if (borrowedBooks.isNotEmpty()) {
            println("Borrowed Books: $borrowedBooks")
        } else {
            println("No books borrowed.")
        }

        println("\nDo you want to add another student to borrow books? (yes/no)")
        continueAddStudent = readLine()?.toLowerCase() == "yes"
    }

    println("\nExiting the school library system. Goodbye!")
}
