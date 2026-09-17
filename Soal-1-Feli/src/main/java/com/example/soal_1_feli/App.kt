package com.example.soal_1_feli
import java.util.*
class App {
    val scannerString= Scanner(System.`in`)
    val scannerInt = Scanner(System.`in`)
    var ListMenu = ArrayList<Menu>()
    var ListOrder = ArrayList<Order>()

    init{
        ListMenu.add(Menu("Nasi Goreng", "Nasi goreng spesial", 25000))
        ListMenu.add(Menu("Mie Ayam", "Mie ayam dengan bakso", 20000))
        ListMenu.add(Menu("Es Teh", "Es teh manis", 5000))
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
            val option : Int = scannerInt.nextInt()

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

    fun viewMenu() {
        if (ListMenu.isEmpty()) {
            println("Empty Menu.")
            return
        }
        println("")
        println("--- DAFTAR MENU ---")
        var number = 1
        for (item in ListMenu) {
            println("$number. ${item.name} - ${item.desc} - Rp${item.price}")
            number += 1
        }
    }

    fun addMenu() {
        print("food name: ")
        val name : String = scannerString.nextLine()
        if(name.isEmpty()){
            println("Invalid Name.")
            return
        }

        print("Description: ")
        val desc : String = scannerString.nextLine()
        if(desc.isEmpty()){
            println("Invalid Description.")
            return
        }

        print("Price: ")
        val price:Int = scannerInt.nextInt()
        if (price == 0) {
            println("Invalid Price.")
            return
        }

        ListMenu.add(Menu(name, desc, price))
        println("Menu '$name' successfully added.")
    }

    fun editMenu() {
        viewMenu()
        print("Choose the menu you want to edit: ")
        val choice:Int = scannerInt.nextInt()
        val index = choice - 1
        if (index < 0 || index >= ListMenu.size) {
            println("invalid choice.")
            return
        }

        val item = ListMenu[index]
        print("New name(empty it if you don't want it to change): ")
        val name:String = scannerString.nextLine()
        if (name != "") {
            item.name = name
        }

        print("New description(empty it if you want it to change): ")
        val desc:String = scannerString.nextLine()
        if (desc != "") {
            item.desc = desc
        }

        print("New price(empty it if you dont want it to change): ")
        val price:Int = scannerInt.nextInt()
        if (price != 0) {
            item.price = price
        }
        println("Menu successfully updated.")
    }

    fun deleteMenu() {
        viewMenu()
        print("Choose the menu you want to delete: ")
        val choice:Int = scannerInt.nextInt()
        val index = choice - 1
        if (index < 0 || index >= ListMenu.size) {
            println("invalid number.")
            return
        }
        val removed = ListMenu[index]
        ListMenu.removeAt(index)
        println("Menu '${removed.name}' successfully deleted.")
    }

    fun viewOrders() {
        if (ListOrder.isEmpty()) {
            println("Belum ada order.")
            return
        }
        for (order in ListOrder) {
            order.print()
            println("")
        }
    }

    fun makeOrder() {
        if (ListMenu.isEmpty()) {
            println("Menu is empty, cant make an order")
            return
        }

        print("Nama customer: ")
        val customerName: String = scannerString.nextLine()
        if (customerName == "") {
            println("name cant be empty")
            return
        }

        val order = Order(customerName)
        var counter = true
        while (counter) {
            viewMenu()
            print("Pick a number (0 to exit): ")
            val choice : Int = scannerInt.nextInt()
            if (choice == 0) {
                counter = false
            } else {
                val index = choice - 1
                if (index < 0 || index >= ListMenu.size) {
                    println("Invalid choice.")
                } else {
                    print("Jumlah: ")
                    val qty : Int = scannerInt.nextInt()
                    if (qty <= 0) {
                        println("Invalid amount.")
                    } else {
                        val menu = ListMenu[index]
                        order.addItem(menu.name, menu.price, qty)
                        println("Item added to order")
                    }
                }
            }
        }
    }


}