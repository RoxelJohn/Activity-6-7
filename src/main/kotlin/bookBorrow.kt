import java.time.LocalDate
import java.time.format.DateTimeFormatter

val books = arrayListOf("English", "Math", "Science", "Filipino")
val borrowers = arrayListOf<Borrower>()
val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

fun main() {
    while (true) {
        println("BOOK BORROWING SYSTEM\n[1] Add new book\n[2] Remove a book\n[3] Cater borrower\n[4] Display Details\n[5] Display Available Books\n[6] Exit")

        when (readLine()?.toIntOrNull() ?: continue) {
            1 -> addBook()
            2 -> removeBook()
            3 -> caterBorrower()
            4 -> displayDetails()
            5 -> displayAvailableBooks()
            6 -> exit()
            else -> println("Invalid option. Please select from given options.")
        }
    }
}

fun addBook() {
    println("Enter Book Name: ")
    val bookName = readLine()!!
    if (books.contains(bookName)) {
        println("Book already exists.")
    } else {
        books.add(bookName)
        println("Book $bookName added.")
    }
}

fun removeBook() {
    println("Enter a book name to remove: ")
    val bookName = readLine()!!
    if (books.contains(bookName)) {
        books.remove(bookName)
        println("Book $bookName removed.")
    } else {
        println("Book $bookName not found.")
    }
}

fun caterBorrower() {
    println("Enter Borrower's name: ")
    val borrowerName = readLine()!!
    val borrower = borrowers.find { it.name == borrowerName }
        ?: Borrower(borrowerName, arrayListOf(), LocalDate.MIN, LocalDate.MIN).also { borrowers.add(it) }

    println("Enter number of books to borrow: ")
    val numBooks = readLine()?.toIntOrNull() ?: return

    for (i in 1..numBooks) {
        println("Enter name of book to borrow: ")
        var bookName = readLine()!!
        while (!books.contains(bookName)) {
            println("Book $bookName is unavailable. Enter new book name.")
            bookName = readLine()!!
        }
        println("Confirm borrowing $bookName ? (yes/no)")
        if (readLine()?.toLowerCase() == "yes") {
            borrower.borrowedBooks.add(bookName)
        }
    }

    println("Enter return date (yyyy-MM-dd): ")
    val returnDateInput = readLine() ?: ""
    val returnDate = LocalDate.parse(returnDateInput, formatter)
    borrower.borrowDate = LocalDate.now()
    borrower.returnDate = returnDate
    println("Borrower $borrowerName added with ${borrower.borrowedBooks.size} borrowed Books.")
}

fun displayDetails() {
    println("Borrower Details:")
    for (borrower in borrowers) {
        println("[Borrower: ${borrower.name}] [Number of books borrowed: ${borrower.borrowedBooks.size}] [Name of Books: ${borrower.borrowedBooks.joinToString()}] [Date Borrowed: ${borrower.borrowDate.format(formatter)}] [Return Date: ${borrower.returnDate.format(formatter)}]")
        println()
    }
}

fun displayAvailableBooks() {
    println("Available Books:")
    books.forEach { println(it) }
}

fun exit() {
    println("Do you want to exit program? (yes/no)")
    if (readLine()?.toLowerCase() == "yes") {
        System.exit(0)
    }
}

data class Borrower(
    val name: String,
    val borrowedBooks: ArrayList<String>,
    var borrowDate: LocalDate,
    var returnDate: LocalDate
)
