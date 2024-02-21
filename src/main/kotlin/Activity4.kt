import java.text.DecimalFormat

fun main() {
    println("*********************************************************************************************")
    println("***                   Welcome to the Computer Products Inventory System!                  ***")
    println("*********************************************************************************************")

    var productName = ""
    var productQuantity = 0
    var productPrice = 0.0
    var productCondition = ""
    var productRemarks = ""

    var continueAdd = true

    while (continueAdd) {
        println("\nMenu:")
        println("1. Add a product to inventory:")
        println("2. Exit")
        print("\nSelect  option: ")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("\nEnter details:")
                print("Name: ")
                productName = readLine() ?: ""
                print("Quantity: ")
                productQuantity = readLine()?.toIntOrNull() ?: 0
                print("Price (in PHP): ")
                val priceString = readLine()
                productPrice = if (priceString != null) priceString.toDoubleOrNull() ?: 0.0 else 0.0
                val formatter = DecimalFormat("PHP#,###.00")
                val formattedPrice = formatter.format(productPrice)
                print("Condition(good/bad): ")
                productCondition = readLine() ?: ""
                productRemarks = if (productCondition.equals("good", ignoreCase = true)) "product is buyable" else "not buyable"

                println("\nProduct added to inventory!")
                println("Product: Name: $productName, Quantity: $productQuantity, Price: $formattedPrice, Condition: $productCondition, Remarks: $productRemarks")

                println("\nDo you want to add another product to the inventory? (yes/no)")
                val addAnother = readLine()?.toLowerCase()
                if (addAnother == "yes") {
                    // Clear the input
                    println()
                } else if (addAnother == "no" || addAnother == "n") {
                    continueAdd = false
                }
            }
            2 -> {
                continueAdd = false
            }
            else -> {
                println("\nInvalid option. Please select a valid option.")
                println()
            }
        }
    }
    println("Exiting the Inventory System. Goodbye!")
}
