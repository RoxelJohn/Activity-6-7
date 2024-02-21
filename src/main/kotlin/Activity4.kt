package src.main.kotlin



import java.text.DecimalFormat

data class CompProducts(val name: String, val quantity: Int, val price: Double, val condition: String, val remarks: String)

fun main() {
    println("*********************************************************************************************")
    println("***                   Welcome to the Computer Products Inventory System!                  ***")
    println("*********************************************************************************************")



    var continueAdd = true

    while (continueAdd) {
        println("\nMenu:")
        println("1. Add a product to inventory:")
        println("2. Exit")
        print("\nSelect an option: ")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("\nEnter details:")
                print("Name: ")
                val name = readLine() ?: ""
                print("Quantity: ")
                val quantity = readLine()?.toIntOrNull() ?: 0
                print("Price (in PHP): ")
                val priceString = readLine()
                val price = if (priceString != null) priceString.toDoubleOrNull() ?: 0.0 else 0.0
                val formatter = DecimalFormat("PHP#,###.00")
                val formattedPrice = formatter.format(price)
                print("Condition(good/bad): ")
                val condition = readLine() ?: ""
                val remarks = if (condition.equals("good", ignoreCase = true)) "product is buyable" else "not buyable"
                val product = CompProducts(name, quantity, price, condition, remarks)


                println("\nProduct added to inventory!")
                println("Product: Name: ${product.name}, Quantity: ${product.quantity}, Price: ${formattedPrice}, Condition: ${product.condition}, Remarks: ${product.remarks}")

                println("\nDo you want to add another product to the inventory? (yes/no)")
                val addAnother = readLine()?.toLowerCase()
                if (addAnother == "yes") {
                    // Clear the input
                    println()
                } else if (addAnother == "no") {
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