package com.example.soal_1_feli

import java.util.*

class App {
    val scannerString = Scanner(System.`in`)
    val scannerInt = Scanner(System.`in`)
    var ListMenu = ArrayList<Menu>()
    var ListOrder = ArrayList<Order>()

    init {
        ListMenu.add(Menu("Nasi Goreng", "Nasi goreng spesial", 25))
        ListMenu.add(Menu("Mie Ayam", "Mie ayam dengan bakso", 20))
        ListMenu.add(Menu("Es Teh", "Es teh manis", 5))
    }

    fun startMenu() {
        var running = true
        while (running == true) {
            try {
                println("")
                println("===== ORDER SYSTEM =====")
                println("1. Make Order")
                println("2. View Orders")
                println("3. View Menu")
                println("4. Add Menu")
                println("5. Edit Menu")
                println("6. Delete Menu")
                println("7. Exit")
                print("Pick a menu: ")
                val option: Int = scannerInt.nextInt()

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
                    println("Thank you")
                    running = false
                    System.exit(0)
                } else {
                    println("Invalid option")
                }
            } catch (e: InputMismatchException) {
                println("Invalid input")
                scannerInt.nextLine()
            } catch (e: Exception) {
                println("Error, invalid")
            }
        }
    }

    fun viewMenu() {
        try {
            if (ListMenu.isEmpty()) {
                println("Menu empty")
                return
            }
            println("")
            println("--- MENU LIST ---")
            var number = 1
            for (item in ListMenu) {
                println("$number. ${item.name} - ${item.desc} - $${item.price}")
                number += 1
            }
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

    fun addMenu() {
        try {
            print("Food name: ")
            val name: String = scannerString.nextLine()
            if (name.isEmpty()) {
                println("Name cant be empty")
                return
            }

            print("Description: ")
            val desc: String = scannerString.nextLine()
            if (desc.isEmpty()) {
                println("Description cant be empty")
                return
            }

            print("Price: ")
            val price: Int = scannerInt.nextInt()
            if (price == 0) {
                println("Price cant be empty")
                return
            }

            ListMenu.add(Menu(name, desc, price))
            println("Menu '$name' added.")
        } catch (e: InputMismatchException) {
            println("Invalid")
            scannerInt.nextLine()
        } catch (e: Exception) {
            println("Invalid input")
        }
    }

    fun editMenu() {
        try {
            viewMenu()
            print("Choose the menu you want to edit: ")
            val choice: Int = scannerInt.nextInt()
            val index = choice - 1
            if (index < 0 || index >= ListMenu.size) {
                println("Invalid input")
                return
            }

            val item = ListMenu[index]
            print("New name (just enter to skip): ")
            val name: String = scannerString.nextLine()
            if (name != "") {
                item.name = name
            }

            print("New description (just enter to skip): ")
            val desc: String = scannerString.nextLine()
            if (desc != "") {
                item.desc = desc
            }

            print("New price (just enter 0 to skip): ")
            val price: Int = scannerInt.nextInt()
            if (price != 0) {
                item.price = price
            }
            println("Menu updated")
        } catch (e: InputMismatchException) {
            println("Invalid input")
            scannerInt.nextLine()
        } catch (e: Exception) {
            println("Invalid input")
        }
    }

    fun deleteMenu() {
        try {
            viewMenu()
            print("Choose the menu you want to delete: ")
            val choice: Int = scannerInt.nextInt()
            val index = choice - 1
            if (index < 0 || index >= ListMenu.size) {
                println("Invalid input")
                return
            }
            val removed = ListMenu[index]
            ListMenu.removeAt(index)
            println("Menu is successfully deleted")
        } catch (e: InputMismatchException) {
            println("Invalid input")
            scannerInt.nextLine()
        } catch (e: Exception) {
            println("Invalid input")
        }
    }

    fun viewOrders() {
        try {
            if (ListOrder.isEmpty()) {
                println("Empty orders")
                return
            }
            println("")
            println("--- CUSTOMER LIST ---")
            var count = 1
            for (order in ListOrder) {
                println("$count. ${order.namaCust}")
                count += 1
            }
            print("Pick a customer (0 to go back): ")
            val choice: Int = scannerInt.nextInt()
            if (choice == 0) {
                return
            }
            val index = choice - 1
            if (index < 0 || index >= ListOrder.size) {
                println("Invalid input")
                return
            }
            ListOrder[index].print()
        } catch (e: InputMismatchException) {
            println("Invalid input")
            scannerInt.nextLine()
        } catch (e: Exception) {
            println("Invalid input")
        }
    }

    fun makeOrder() {
        try {
            if (ListMenu.isEmpty()) {
                println("Menu is empty.")
                return
            }

            print("Customer name: ")
            val customerName: String = scannerString.nextLine()
            if (customerName == "") {
                println("Name cant be empty")
                return
            }

            val order = Order(customerName)
            var counter = true
            while (counter) {
                try {
                    viewMenu()
                    print("Pick a number (0 to exit): ")
                    val choice: Int = scannerInt.nextInt()
                    if (choice == 0) {
                        counter = false
                    } else {
                        val index = choice - 1
                        if (index < 0 || index >= ListMenu.size) {
                            println("Invalid input")
                        } else {
                            print("Jumlah: ")
                            val qty: Int = scannerInt.nextInt()
                            if (qty <= 0) {
                                println("Invalid input")
                            } else {
                                val menu = ListMenu[index]
                                order.addItem(menu.name, menu.price, qty)
                                println("Order is successfully added")
                            }
                        }
                    }
                } catch (e: InputMismatchException) {
                    println("Invalid input")
                    scannerInt.nextLine()
                }
            }
            if (order.pesanan.isEmpty()) {
                println("Order is empty.")
                return
            }
            ListOrder.add(order)
            println("Order for '${order.namaCust}' is saved.")
        } catch (e: Exception) {
            println("Invalid input")
        }
    }
}