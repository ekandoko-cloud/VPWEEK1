package com.example.soal_1_feli
import java.util.*
class App {
    val scanner = Scanner(System.`in`)
    var ListMenu = ArrayList<Menu>()
    var ListOrder = ArrayList<Order>()

    init{
        ListMenu.add(Menu("Nasi Goreng", "Nasi goreng spesial", 25000.00))
        ListMenu.add(Menu("Mie Ayam", "Mie ayam dengan bakso", 20000.0))
        ListMenu.add(Menu("Es Teh", "Es teh manis", 5000.0))
    }

    fun startMenu(){
        var running = true
        while (running == true){
            println("")
            println("===== ORDER SYSTEM =====")
            println("1. Make Order")
            println("2. View Orders")
            println("3. View Menu")
            println("4. Add Menu")
            println("5. Edit Menu")
            println("6. Delete Menu")
            println("7. Exit")
            print("Pilih menu: ")
            val option : Int
            option = scanner.nextInt()

           if (option == 1) {
                makeOrder()
            } else if (option == 2) {
                viewOrders()
            } else if (option == 3) {
                viewMenu()
            } else if (option == 4) {
                addMenu()
            } else if (option == 5) {
                editMenu()
            } else if (option == 6) {
                deleteMenu()
            } else if (option == 7) {
                println("The app will be closed")
                running = false
               System.exit(0)
            } else {
                println("Invalid Option")
            }
        }
    }
}